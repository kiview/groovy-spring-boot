package com.groovycoder.groovyspringboot.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    String name

}
