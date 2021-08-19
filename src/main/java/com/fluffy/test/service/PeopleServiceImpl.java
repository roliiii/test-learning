package com.fluffy.test.service;

import com.fluffy.test.controller.PeopleDto;
import com.fluffy.test.entity.People;
import com.fluffy.test.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    @Override
    public void addPeople(PeopleDto peopleDto){
        addPeople(People.builder().name(peopleDto.getName()).email(peopleDto.getEmail()).build());
    }

    @Override
    public void addPeople(People people){

        People peopleByEmail = peopleRepository.getPeopleByEmail(people.getEmail());

        if (peopleByEmail == null){
            peopleRepository.save(people);
        }

    }


}
