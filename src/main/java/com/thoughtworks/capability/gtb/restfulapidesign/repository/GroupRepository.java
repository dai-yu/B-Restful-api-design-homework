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
        ArrayList<Object> list = new ArrayList<>();
        for (int i=1;i<=6;i++){
            list.add(new Group(i));
        }
        return list;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Group> regroup() {
        List<Student> students = studentRepository.getStudents();
        Collections.shuffle(students);
        for (int i=0;i<6;i++){
            groups.get(i).getStudents().clear();
        }
        int index = 0;
        while (index < students.size()) {
            groups.get(index % 6).getStudents().add(students.get(index));
            index++;
        }
        return groups;
    }

    public void rename(int id, String name) {
        groups.get(id-1).setName(name);
    }

    public Group findById(int id) {
        return groups.get(id-1);
    }
}
