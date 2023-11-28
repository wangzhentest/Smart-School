package com.example.smart_campus_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@SpringBootTest
@Component
class SmartCampusBackendApplicationTests {
    @Value("${greeting.message}")
    private String greetingMessage;

    @Test
    void contextLoads() {
        System.out.println("----------------");
        System.out.println(greetingMessage);
        System.out.println("----------------");
    }

}
