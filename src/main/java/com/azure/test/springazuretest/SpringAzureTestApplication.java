package com.azure.test.springazuretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAzureTestApplication {

    @GetMapping("/message")
    public String getMessage()
    {
        return "Welcome to Azure World";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAzureTestApplication.class, args);
    }

}
