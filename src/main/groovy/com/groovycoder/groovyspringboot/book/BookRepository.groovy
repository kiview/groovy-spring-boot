package com.groovycoder.groovyspringboot.book

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BookRepository extends CrudRepository<Book, Long> {

    List findByName(@Param("name") String name)

}
