package com.groovycoder.groovyspringboot.book

import org.springframework.data.repository.CrudRepository

interface BookRepository extends CrudRepository<Book, Long> {

    List findByName(String name)

}
