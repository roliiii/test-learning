package com.fluffy.test.controller;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PeopleDto {

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int age;

}
