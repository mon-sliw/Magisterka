package pl.mis.magisterka.badania.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StopWatch;

import java.io.IOException;

@AllArgsConstructor
public class MyInterceptor implements ClientHttpRequestInterceptor {

    TestingData testingData;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        stopWatch.stop();
//        System.out.println("time: " + stopWatch.getLastTaskTimeMillis());
        testingData.addTime(stopWatch.getLastTaskTimeMillis());

        return response;
    }
}
