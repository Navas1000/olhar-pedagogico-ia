package br.com.olharpedagogicoia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class InstitucionalApplication {
    public static void main(String[] args) {

        SpringApplication.run(InstitucionalApplication.class, args);
    }

}
