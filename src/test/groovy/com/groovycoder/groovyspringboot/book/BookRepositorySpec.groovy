package com.groovycoder.groovyspringboot.book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@Testcontainers
class BookRepositorySpec extends Specification {

    @Shared
    PostgreSQLContainer postgres = new PostgreSQLContainer()

    @Autowired
    BookRepository bookRepository

    def setupSpec() {
        System.setProperty("spring.datasource.url", postgres.jdbcUrl)
        System.setProperty("spring.datasource.username", postgres.username)
        System.setProperty("spring.datasource.password", postgres.password)
        System.setProperty("spring.jpa.hibernate.ddl-auto", "create")
    }

    def setup() {
        bookRepository.deleteAll()
    }


    def "books can be saved"() {
        given: "a book"
        def book = new Book(name: "Spring-Boot in Action")

        when: "saving it"
        bookRepository.save(book)

        then: "there is a book in the repository"
        bookRepository.count() == 1
    }

}
