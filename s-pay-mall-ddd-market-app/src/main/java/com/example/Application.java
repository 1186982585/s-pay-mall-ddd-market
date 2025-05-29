package com.example;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example"
})
@Configurable
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
