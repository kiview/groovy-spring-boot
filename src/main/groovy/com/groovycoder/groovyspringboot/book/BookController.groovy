package com.groovycoder.groovyspringboot.book

import groovy.json.JsonOutput
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class BookController {

    BookRepository bookRepository

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @RequestMapping(value = "/books", produces = ["application/json"])
    @ResponseBody
    String books() {
        JsonOutput.toJson(bookRepository.findAll())
    }

    @RequestMapping(value = "/books/{name}", produces = ["application/json"])
    @ResponseBody
    String findBookByName(@PathVariable String name) {
        JsonOutput.toJson(bookRepository.findByName(name))
    }
}
