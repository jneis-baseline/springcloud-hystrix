package org.jneis.hack.springboot.netflix

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
class HelloWorldApp {

    static void main(String... args) {
        SpringApplication.run(HelloWorldApp, args)
    }

}
