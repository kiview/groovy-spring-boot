package com.groovycoder.groovyspringboot.greeting

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController {

    Greeter greeter

    GreetingController(Greeter greeter) {
        this.greeter = greeter
    }


    @RequestMapping("/greeting")
    @ResponseBody
    String greeting() {
        greeter.greet()
    }

}
