package com.fluffy.test.service;


import com.fluffy.test.entity.People;
import com.fluffy.test.repository.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PeopleServiceImpl.class)
class PeopleServiceImplTest_ExtendWithSpringExtension {
    public static final String FLUFFY_MAIL = "fluffy@fluffy.fluf";

    @MockBean
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleService peopleService;

    @Test
    void addPeople_whenNotInDatabase() {
        People fluffy = People.builder().name("Fluffy").email(FLUFFY_MAIL).build();

        peopleService.addPeople(fluffy);

        ArgumentCaptor<People> peopleArgumentCaptor = ArgumentCaptor.forClass(People.class);
        verify(peopleRepository).save(peopleArgumentCaptor.capture());

        Assertions.assertEquals(fluffy, peopleArgumentCaptor.getValue());

    }

    @Test
    void addPeople_whenInDatabase() {
        People fluffy = People.builder().name("Fluffy").email(FLUFFY_MAIL).build();
        when(peopleRepository.getPeopleByEmail(any())).thenReturn(fluffy);

        peopleService.addPeople(fluffy);

        verify(peopleRepository, times(0)).save(ArgumentMatchers.any());
    }
}