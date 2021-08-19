package com.fluffy.test.service;


import com.fluffy.test.entity.People;
import com.fluffy.test.repository.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PeopleServiceImplTest_ExtendWithMockitoExtension {
    public static final String FLUFFY_MAIL = "fluffy@fluffy.fluf";

    @Mock
    private PeopleRepository peopleRepository;

    @InjectMocks
    private PeopleServiceImpl peopleService;

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