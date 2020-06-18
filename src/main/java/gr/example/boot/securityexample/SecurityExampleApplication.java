package gr.example.boot.securityexample;

import gr.example.boot.securityexample.service.TourService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityExampleApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TourService tc){
        return args -> {
            tc.init();
        };
    }
}
