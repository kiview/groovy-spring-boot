package com.groovycoder.groovyspringboot.greeting

import org.hamcrest.Matcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(GreetingController)
class GreetingControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @Autowired
    Greeter stubGreeter

    @Autowired
    ConferenceNameSelector stubNameSelector

    def "answers with http ok"() {
        expect:
        mvc.perform(get("/greeting"))
                .andExpect(status().isOk())
    }

    def "answer contains content from greeter and name selector"() {
        given: "some stub answers"
        stubGreeter.greet() >> "foo"
        stubNameSelector.selectConference() >> "bar"

        expect: "stubbed answers are part of response"
        mvc.perform(get("/greeting"))
                .andExpect(content().string({
                    it.contains("foo") && it.contains("bar")
        } as Matcher))

    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        Greeter greeter() {
            return detachedMockFactory.Stub(Greeter)
        }

        @Bean
        ConferenceNameSelector conferenceNameSelector() {
            return detachedMockFactory.Stub(ConferenceNameSelector)
        }
    }

}
