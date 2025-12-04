package io.github.natebelinghoo.aitravelplanner.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.natebelinghoo.aitravelplanner")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

