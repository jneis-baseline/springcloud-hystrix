package org.jneis.hack.springboot.netflix

import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    private final AtomicLong counter = new AtomicLong()

    @RequestMapping("/hello")
    Hello hello(@RequestParam(value="name", defaultValue="World") String name) {
        new Hello(id: counter.incrementAndGet(), content: "Hello, ${name}!")
    }

}
