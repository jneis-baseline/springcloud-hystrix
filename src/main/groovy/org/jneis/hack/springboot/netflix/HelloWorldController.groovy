package org.jneis.hack.springboot.netflix

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    private final AtomicLong counter = new AtomicLong()

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloNotFound")
    Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        if ('hello'.equals(name)) {
            throw new RuntimeException("command failed")
        }
        new Hello(id: counter.incrementAndGet(), content: "Hello, ${name}!")
    }

    Hello helloNotFound(String name) {
        new Hello(id: -1, content: "Hello!")
    }

}
