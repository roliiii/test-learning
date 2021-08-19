package com.fluffy.test.repository;

import com.fluffy.test.entity.People;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PeopleRepositoryTest {

    public static final String FLUFFY_MAIL = "fluffy@fluffy.fluf";

    @Autowired
    private PeopleRepository repository;

    @Test
    @Order(0)
    public void Should_foundByEmail_When_FluffyExists(){

        repository.save(People.builder().name("Fluffy").email(FLUFFY_MAIL).build());

        People peopleByEmail = repository.getPeopleByEmail(FLUFFY_MAIL);

        assertEquals("Fluffy", peopleByEmail.getName());

    }

    @Test
    @Order(1)
    public void Should_foundByEmail_When_FluffyNotExists(){

        People peopleByEmail = repository.getPeopleByEmail(FLUFFY_MAIL);

        assertNull(peopleByEmail);

    }

}