package com.jpa.jpaexample.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class User {

    @Id
    private String id;
    private String name;
    private String department;
    private int age;

}
