package gr.example.boot.securityexample;

import gr.example.boot.securityexample.model.User;
import gr.example.boot.securityexample.service.TourService;
import gr.example.boot.securityexample.service.UserRoleService;
import gr.example.boot.securityexample.service.UserService;
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
    ApplicationRunner init(TourService tc, UserRoleService userRoleService, UserService userService){
        return args -> {
            tc.init();

//            User user = new User();
//            user.setName("Aggelos");
//            user.setLastName("Negkas");
//            user.setPassword("01234567");
//            user.setEmail("aggelos@negkas.eu");
//            user.setRole(userRoleService.findByRole("USER"));
//            userService.save(user);
        };
    }
}
