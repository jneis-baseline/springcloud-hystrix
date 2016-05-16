package org.jneis.hack.springboot.netflix

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker

@SpringBootApplication
@EnableCircuitBreaker
class HelloWorldApp {

    static void main(String... args) {
        SpringApplication.run(HelloWorldApp, args)
    }

}
