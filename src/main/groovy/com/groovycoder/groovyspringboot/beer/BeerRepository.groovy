package com.groovycoder.groovyspringboot.beer

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BeerRepository extends CrudRepository<Beer, Long> {
    List findByType(@Param("type") String type)
}
