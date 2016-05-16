package org.jneis.hack.springboot.netflix

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @Autowired
    HelloWorldService service

    @RequestMapping("/hello")
    Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        service.hello(name)
    }

}
