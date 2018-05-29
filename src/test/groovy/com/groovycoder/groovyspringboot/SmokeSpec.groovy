package com.groovycoder.groovyspringboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class SmokeSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "boots up without error"() {
        expect:
        context != null
    }

}
