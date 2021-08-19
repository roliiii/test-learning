package com.fluffy.test.controller;

import com.fluffy.test.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PeopleController {

    private PeopleService peopleService;

    @PostMapping()
    public ResponseEntity<Void> addPeople(@RequestBody() PeopleDto peopleDto){
        peopleService.addPeople(peopleDto);
        return ResponseEntity.ok().build();
    }

}
