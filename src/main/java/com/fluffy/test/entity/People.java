package com.fluffy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    @SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private int age;

}
