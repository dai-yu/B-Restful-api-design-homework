package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudents(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}
