package com.groovycoder.groovyspringboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@SpringBootApplication
class GroovySpringbootApplication {

    static void main(String[] args) {
        SpringApplication.run(GroovySpringbootApplication.class, args)
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        "Hello Gr8confEU!"
    }
}
