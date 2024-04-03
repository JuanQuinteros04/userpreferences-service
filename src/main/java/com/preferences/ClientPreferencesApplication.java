package com.preferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication@EntityScan({"com.commons.client.model"})
public class ClientPreferencesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientPreferencesApplication.class);
    }
}