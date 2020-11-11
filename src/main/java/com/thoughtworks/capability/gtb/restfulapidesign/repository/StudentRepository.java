package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private int studentId = 15;
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

    public List<Student> getStudents() {
        return students;
    }

    public int getIndex(int id) {
        return students.indexOf(new Student(id));
    }

    public void save(Student student) {
        if (students.contains(student)) {
            students.set(students.indexOf(student), student);
        } else {
            student.setId(studentId + 1);
            students.add(student);
        }
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(id > students.size() ? null : students.get(getIndex(id)));
    }

    public void deleteStudent(int id) {
        students.remove(getIndex(id));
    }

    public List<Student> findByGender(Student.Gender gender) {
        return students.stream()
                .filter(student -> student.getGender() == gender)
                .sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
    }

    public List<Student> findAll() {
        return students;
    }

    public void updatePartialField(int id, Student student) {
        Student newStudent = students.get(getIndex(id));
        Field[] fields = Student.class.getDeclaredFields();
        Arrays.stream(fields).filter(field -> {
            Object o = null;
            field.setAccessible(true);
            try {
                if (!field.getName().equals("id"))
                    o = field.get(student);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return Objects.nonNull(o);
        }).forEach(field -> {
            try {
                field.set(newStudent, field.get(student));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        students.set(getIndex(id), newStudent);
    }
}
