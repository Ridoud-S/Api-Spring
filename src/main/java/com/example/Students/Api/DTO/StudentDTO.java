package com.example.Students.Api.DTO;


/**
 * DTO para la entidad Student. Evita exponer directamente la estructura de la base de datos.
 */
public class StudentDTO {
    private Long id;
    private String name;
    private String email;

    public StudentDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
