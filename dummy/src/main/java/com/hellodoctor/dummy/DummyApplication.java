package com.hellodoctor.dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DummyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyApplication.class, args);
    }

}
