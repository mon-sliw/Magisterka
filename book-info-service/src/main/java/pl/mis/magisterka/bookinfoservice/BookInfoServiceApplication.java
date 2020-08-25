package pl.mis.magisterka.bookinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.bookinfoservice.entity.Book;

@EnableEurekaClient
@SpringBootApplication
public class BookInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookInfoServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
