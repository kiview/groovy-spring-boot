package com.groovycoder.groovyspringboot.greeting

import org.springframework.stereotype.Component

@Component
class Greeter {

    List greetings = ["Hello", "Hallo", "Hej", "Hola", "Merhaba"]
    Random random = new Random()

    String greet() {
        greetings.get(random.nextInt(greetings.size()))
    }

}
