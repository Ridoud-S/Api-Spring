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

    /**
     * Edad del estudiante.
     */
    private Integer age;

    /**
     * Fecha de nacimiento del estudiante (Date of Birth).
     */
    private LocalDate dob; //Date of Birth

    /**
     * Correo electrónico del estudiante.
     */
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

    /**
     * Retorna el identificador único del estudiante.
     *
     * @return id del estudiante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna un nuevo valor al identificador único del estudiante.
     *
     * @param id Nuevo ID para el estudiante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el correo electrónico del estudiante.
     *
     * @return Email del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna un nuevo correo electrónico al estudiante.
     *
     * @param email Nuevo correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna la fecha de nacimiento del estudiante.
     *
     * @return Fecha de nacimiento.
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Asigna una nueva fecha de nacimiento al estudiante.
     *
     * @param dob Nueva fecha de nacimiento.
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Retorna la edad del estudiante.
     *
     * @return Edad del estudiante.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Asigna una nueva edad al estudiante.
     *
     * @param age Nueva edad del estudiante.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Retorna el nombre del estudiante.
     *
     * @return Nombre del estudiante.
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna un nuevo nombre al estudiante.
     *
     * @param name Nuevo nombre del estudiante.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Representación en cadena del objeto Student.
     *
     * @return Cadena con los datos del estudiante.
     */
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
