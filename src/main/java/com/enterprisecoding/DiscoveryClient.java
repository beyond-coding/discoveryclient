package com.enterprisecoding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
public class DiscoveryClient {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryClient.class, args);
    }
}

@RefreshScope
@RestController
@RequestMapping("/")
class MessageController {

    @Value("${messagecontroller.message:property not found}")
    private String message;

    @GetMapping
    public String message() {
        return message;
    }

}

@RestController
@RequestMapping("/roll")
class RollController {

    @GetMapping
    public String message() {
        return "We roll like this";
    }

}