package ar.dev.maxisandoval.footballapieditjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FootballApiEdItJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApiEdItJwtApplication.class, args);
    }

}