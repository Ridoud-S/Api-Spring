package com.example.Students.Api.Entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Teacher")
public class Teacher
{
    @Id
    @SequenceGenerator(
            name = "teacher sequence",
            sequenceName = "teacher sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher sequence"
    )


    private Long id;


    private String name;
    private String especiality;
    private String email;

    public Teacher() {
    }

    public Teacher(String name, String especiality, String email) {
        this.name = name;
        this.especiality = especiality;
        this.email = email;
    }

    public Teacher(Long id, String name, String especiality, String email) {
        this.id = id;
        this.name = name;
        this.especiality = especiality;
        this.email = email;
    }
}
