package com.fluffy.test.repository;

import com.fluffy.test.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

    public People getPeopleByEmail(String email);

}
