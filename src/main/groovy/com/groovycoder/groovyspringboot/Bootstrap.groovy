package com.groovycoder.groovyspringboot

import com.groovycoder.groovyspringboot.book.Book
import com.groovycoder.groovyspringboot.book.BookRepository
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class Bootstrap {

    BookRepository bookRepository

    Bootstrap(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @PostConstruct
    void bootstrap() {
        def books = [
                new Book(name: "Moby Dick"),
                new Book(name: "Groovy in Action")
        ]

        bookRepository.saveAll(books)
    }

}
