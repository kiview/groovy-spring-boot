package com.groovycoder.groovyspringboot

import com.groovycoder.groovyspringboot.beer.Beer
import com.groovycoder.groovyspringboot.beer.BeerRepository
import com.groovycoder.groovyspringboot.book.Book
import com.groovycoder.groovyspringboot.book.BookRepository
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class Bootstrap {

    BookRepository bookRepository
    BeerRepository beerRepository

    Bootstrap(BookRepository bookRepository, BeerRepository beerRepository) {
        this.bookRepository = bookRepository
        this.beerRepository = beerRepository
    }

    @PostConstruct
    void bootstrap() {
        def books = [
                new Book(name: "Moby Dick"),
                new Book(name: "Groovy in Action")
        ]
        bookRepository.saveAll(books)


        def beers = [
            new Beer(name: "Grails Beer", type: "Lager", taste: "Euro Strong"),
            new Beer(name: "Trait Pilsener", type: "Pilsener", taste: "Bitter"),
            new Beer(name: "Groovy Ale", type: "Scotch Ale", taste: "Wee Heavy"),
            new Beer(name: "Anniversary Beer", type: "IPA", taste: "American Fruity"),
            new Beer(name: "Hansa Pils", type: "Pilsener", taste: "German taste explosion"),
            new Beer(name: "Fiege Pils", type: "Pilsener", taste: "The taste of the Ruhrgebiet")
        ]
        beerRepository.saveAll(beers)

    }

}
