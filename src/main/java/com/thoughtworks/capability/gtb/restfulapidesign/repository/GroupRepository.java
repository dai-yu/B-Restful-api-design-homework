package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepository {

    @Autowired
    private StudentRepository studentRepository;

    private List<Group> groups = initList();

    private ArrayList initList() {
        return new ArrayList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Group> regroup() {
        groups.clear();
        List<Student> students = studentRepository.getStudents();
        Collections.shuffle(students);
        for (int i=1;i<=6;i++){
            groups.add(new Group(i));
        }
        int index = 0;
        while (index < students.size()) {
            groups.get(index % 6).getStudents().add(students.get(index));
            index++;
        }
        return groups;
    }
}
