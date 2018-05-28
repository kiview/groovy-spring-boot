package com.groovycoder.groovyspringboot.greeting

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController {

    Greeter greeter
    ConferenceNameSelector conferenceNameSelector

    GreetingController(Greeter greeter, ConferenceNameSelector conferenceNameSelector) {
        this.greeter = greeter
        this.conferenceNameSelector = conferenceNameSelector
    }


    @RequestMapping("/greeting")
    @ResponseBody
    String greeting() {
        "${greeter.greet()} ${conferenceNameSelector.selectConference()}!"
    }

}
