package pl.mis.magisterka.bookinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookInfoServiceApplication.class, args);
    }

}
