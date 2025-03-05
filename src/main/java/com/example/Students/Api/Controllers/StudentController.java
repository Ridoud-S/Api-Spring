package com.example.Students.Api.Controllers;

import com.example.Students.Api.Service.StudentService;
import com.example.Students.Api.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Students.Api.DTO.StudentDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST que expone endpoints para la gestión de estudiantes.
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{

    /**
     * Servicio para la gestión de operaciones relacionadas con estudiantes.
     */
    private final StudentService studentService;

    /**
     * Constructor que inyecta la dependencia StudentService.
     *
     * @param studentService Servicio que maneja la lógica de negocio.
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Endpoint para obtener la lista de todos los estudiantes.
     *
     * @return Lista de objetos Student.
     */
    @GetMapping
    public List<StudentDTO> getStudents()
    {
        return studentService.getStudents(); // Retorna la lista de DTOs
    }

    /**
     * Endpoint para registrar un nuevo estudiante.
     / @param student Objeto Student que contiene los datos del nuevo estudiante.
     */
    @PostMapping
    public void registerNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentService.addNewStudent(student);
    }

    private Student convertToEntity(StudentDTO studentDTO) {

        return new Student(
                studentDTO.getName(),
                studentDTO.getAge(),
                LocalDate.now(),
                studentDTO.getEmail()
        );
    }

    /**
     * Endpoint para eliminar un estudiante en base a su ID.
     *
     * @param studentId Identificador del estudiante a eliminar.
     */
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    /**
     * Endpoint para actualizar un estudiante. Permite actualizar el nombre y/o email.
     *
     * @param studentId ID del estudiante a actualizar.
     * @param name      Nuevo nombre (opcional).
     * @param email     Nuevo email (opcional).
     */
    @PutMapping(path = "/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
