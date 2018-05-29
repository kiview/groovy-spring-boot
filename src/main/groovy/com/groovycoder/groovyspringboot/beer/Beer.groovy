package com.groovycoder.groovyspringboot.beer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Beer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    String name

    String type

    String taste


}
