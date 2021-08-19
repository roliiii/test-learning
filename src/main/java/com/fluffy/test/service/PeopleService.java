package com.fluffy.test.service;

import com.fluffy.test.controller.PeopleDto;
import com.fluffy.test.entity.People;

public interface PeopleService {
    void addPeople(People people);
    void addPeople(PeopleDto people);
}
