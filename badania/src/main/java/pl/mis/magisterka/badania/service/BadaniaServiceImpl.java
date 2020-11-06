package pl.mis.magisterka.badania.service;

import lombok.AllArgsConstructor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BadaniaServiceImpl implements BadaniaService {

    RestTemplate restTemplate;
    TestingData testingData;
    int i;

    @Override
    public boolean test() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new MyInterceptor(testingData));
        restTemplate.setInterceptors(interceptors);

        for (int i = 0; i < 100; i++) {
            try {
                if (restTemplate.getForEntity("http://localhost:8081/catalog/" + (i % 50 + 1), Void.class).getStatusCode().is2xxSuccessful())
                    testingData.addSuccessfulResponse();
            } catch (Exception e) {
                testingData.addFailedResponse();
            }
        }
        testingData.showResponses();
        testingData.showAverageTime();
        testingData.saveToCSV();
        return true;
    }
}
