package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student findById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new StudentNotFoundException("student is not found"));
    }

    public void deleteStudent(int id) {
        findById(id);
        studentRepository.deleteStudent(id);
    }

    public List<Student> findByGender(Student.Gender gender) {
        return studentRepository.findByGender(gender);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
