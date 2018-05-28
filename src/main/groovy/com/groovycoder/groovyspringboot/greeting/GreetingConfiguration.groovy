package com.groovycoder.groovyspringboot.greeting

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GreetingConfiguration {

    @Bean
    ConferenceNameSelector conferenceNameSelector() {
        return new ConferenceNameSelector()
    }

}

