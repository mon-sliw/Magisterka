package pl.mis.magisterka.badania.service;

import lombok.AllArgsConstructor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Service
public class BadaniaServiceImpl implements BadaniaService {

    RestTemplate restTemplate;
    TestingData testingData;

    @Override
    public boolean test(int count) {
        System.out.println("Testing " + count);

        testingData.reset();

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new MyInterceptor(testingData));
        restTemplate.setInterceptors(interceptors);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<Boolean>> tasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            tasks.add(() -> {
                try {
                    if (restTemplate.getForEntity("http://localhost:8081/catalog/" + (finalI % 50 + 1), Void.class).getStatusCode().is2xxSuccessful())
                        testingData.addSuccessfulResponse();
                } catch (Exception e) {
                    testingData.addFailedResponse();
                }
                return true;
            });
        }
        try {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testingData.showResponses();
        testingData.showAverageTime();
        testingData.saveToCSV();
        return true;
    }
}
