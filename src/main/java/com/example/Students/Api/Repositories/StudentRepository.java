package com.example.Students.Api.Repositories;

import com.example.Students.Api.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de Spring Data JPA para la entidad Student.
 * Extiende de JpaRepository, lo que provee métodos CRUD
 * como save, findAll, findById, deleteById, etc.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    /**
     * Query personalizada para buscar un estudiante por su correo electrónico.
     *
     * @param email Correo electrónico a buscar.
     * @return Un Optional con el estudiante, si existe.
     */
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.id = ?1")
    Optional<Student> findById(Long id);

}
