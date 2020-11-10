package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students = initStudents();

    private List<Student> initStudents() {
        return new ArrayList<>(Arrays.asList(
                new Student(1, "成吉思汗", Student.Gender.MALE, null),
                new Student(2, "鲁班七号", Student.Gender.MALE, null),
                new Student(3, "太乙真人", Student.Gender.MALE, null),
                new Student(4, "钟无艳", Student.Gender.FEMALE, null),
                new Student(5, "花木兰", Student.Gender.FEMALE, null),
                new Student(6, "芈月", Student.Gender.FEMALE, null),
                new Student(7, "白起", Student.Gender.MALE, null),
                new Student(8, "庄周", Student.Gender.MALE, null),
                new Student(9, "马超", Student.Gender.MALE, null),
                new Student(10, "蔡文姬", Student.Gender.FEMALE, null),
                new Student(11, "哪吒", Student.Gender.MALE, null),
                new Student(12, "大乔", Student.Gender.FEMALE, null),
                new Student(13, "雅典娜", Student.Gender.FEMALE, null),
                new Student(14, "刘禅", Student.Gender.MALE, null),
                new Student(15, "刘备", Student.Gender.MALE, null)
        ));
    }

    public void save(Student student) {
        if (students.contains(student)) {
            students.set(students.indexOf(student), student);
        }else {
            student.setId(students.size() + 1);
            students.add(student);
        }
    }
}
