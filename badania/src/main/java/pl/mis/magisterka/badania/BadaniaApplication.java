package pl.mis.magisterka.badania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.badania.service.TestingData;

@SpringBootApplication
public class BadaniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadaniaApplication.class, args);
    }

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    int getInt() {
        return 0;
    }

    @Bean
    TestingData getTD() {
        return new TestingData();
    }
}
