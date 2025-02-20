package com.example.Students.Api.Config;

import com.example.Students.Api.Entities.Student;
import com.example.Students.Api.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*
 * Esta anotación se utiliza en clases de Java para indicar
 * que la clase es una clase de configuración de Spring.
 * Contiene definiciones de beans y configuraciones específicas
 * de la aplicación.
 */
@Configuration
public class StudentConfig {

    /**
     * Método que retorna un CommandLineRunner.
     * Este se ejecuta al iniciar la aplicación y sirve para
     * realizar acciones de inicialización, como cargar datos
     * por defecto en la base de datos.
     *
     * @param studentRepository Repositorio JPA para operaciones CRUD de Student.
     * @return Un CommandLineRunner que inserta dos estudiantes de ejemplo.
     */
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository)
    {
        return args ->
        {
            // Crea un objeto Student "maria"
            Student maria = new Student(
                    "Maria",
                    25,
                    LocalDate.of(2000, Month.APRIL, 23),
                    "mariamjamal@gmail.com"
            );

            // Crea un objeto Student "alex"
            Student alex = new Student(
                    "Alex",
                    22,
                    LocalDate.of(2004, Month.JANUARY, 12),
                    "alex@gmail.com"
            );

            // Guarda ambos estudiantes en la base de datos
            studentRepository.saveAll(List.of(maria, alex));
        };
    }
}
