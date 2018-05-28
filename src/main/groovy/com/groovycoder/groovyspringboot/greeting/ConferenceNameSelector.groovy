package com.groovycoder.groovyspringboot.greeting

class ConferenceNameSelector {

    List conferences = ["Gr8Conf EU", "Gr8Conf US", "SpringIO", "Greach"]
    Random random = new Random()

    String selectConference() {
        return conferences.get(random.nextInt(conferences.size()))
    }

}
