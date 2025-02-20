package com.example.Students.Api.Service;

import com.example.Students.Api.Entities.Student;
import com.example.Students.Api.Repositories.StudentRepository;
import com.example.Students.Api.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servicio que maneja la lógica de negocio para la entidad Student.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retorna la lista de todos los estudiantes registrados en la base de datos como DTOs.
     *
     * @return Lista de objetos StudentDTO.
     */
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Registra un nuevo estudiante, verificando que el email no se encuentre en uso.
     *
     * @param student Objeto Student a registrar.
     */
    @Transactional
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está en uso.");
        }
        studentRepository.save(student);
    }

    /**
     * Elimina un estudiante de la base de datos si existe, en base a su ID.
     *
     * @param studentId Identificador del estudiante a eliminar.
     */
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalArgumentException("El estudiante con ID " + studentId + " no existe.");
        }
        studentRepository.deleteById(studentId);
    }

    /**
     * Actualiza el nombre y/o correo electrónico de un estudiante
     * si los valores proporcionados son válidos y el estudiante existe.
     *
     * @param studentId ID del estudiante a actualizar.
     * @param name      Nuevo nombre (opcional).
     * @param email     Nuevo email (opcional).
     */
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "El estudiante con ID " + studentId + " no existe."));

        if (name != null && !name.trim().isEmpty() && !name.equals(student.getName())) {
            student.setName(name);
        }

        if (email != null && !email.trim().isEmpty() && !email.equals(student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalArgumentException("El correo electrónico ya está en uso.");
            }
            student.setEmail(email);
        }
    }

    /**
     * Convierte una entidad Student a un StudentDTO.
     *
     * @param student Entidad Student.
     * @return Objeto StudentDTO.
     */
    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail());
    }
}
