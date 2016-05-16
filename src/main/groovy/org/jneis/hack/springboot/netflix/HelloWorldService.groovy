package org.jneis.hack.springboot.netflix

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import java.util.concurrent.atomic.AtomicLong
import org.springframework.stereotype.Service

@Service
class HelloWorldService {

    private final AtomicLong counter = new AtomicLong()

    @HystrixCommand(fallbackMethod = "helloNotFound", commandProperties = [
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")//,
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    ])
    Hello hello(String name) {
        if ('hello'.equals(name)) {
            throw new RuntimeException("command failed")
        }
        new Hello(id: counter.incrementAndGet(), content: "Hello, ${name}!")
    }

    Hello helloNotFound(String name) {
        new Hello(id: -1, content: "Hello!")
    }

}
