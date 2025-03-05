package com.example.Students.Api.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa la entidad Student, que almacena información
 * sobre un estudiante, incluyendo su nombre, edad, fecha de
 * nacimiento y correo electrónico.
 */
@Entity
@Table
public class Student
{
    /**
     * Campo que representa el identificador único del estudiante.
     * Se genera automáticamente mediante una secuencia.
     */
    @Id
    @SequenceGenerator(
            name = "stutend_squence",
            sequenceName = "stutend_squence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stutend_squence"
    )
    private Long id;

    /**
     * Nombre del estudiante.
     */
    private String name;

    private Integer age;

    private LocalDate dob; //Date of Birth

    private String email;

    /**
     * Constructor por defecto sin parámetros.
     * Necesario para que JPA pueda crear instancias de la entidad.
     */
    public Student() {
    }

    /**
     * Constructor que incluye todos los campos, incluyendo el ID.
     *
     * @param id    Identificador único del estudiante.
     * @param name  Nombre del estudiante.
     * @param age   Edad del estudiante.
     * @param dob   Fecha de nacimiento del estudiante.
     * @param email Correo electrónico del estudiante.
     */
    public Student(Long id, String name, Integer age, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    /**
     * Constructor que excluye el ID, útil para crear nuevas
     * instancias antes de ser guardadas en la base de datos.
     *
     * @param name  Nombre del estudiante.
     * @param age   Edad del estudiante.
     * @param dob   Fecha de nacimiento del estudiante.
     * @param email Correo electrónico del estudiante.
     */
    public Student(String name, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", Email='" + email + '\'' +
                '}';
    }
}
