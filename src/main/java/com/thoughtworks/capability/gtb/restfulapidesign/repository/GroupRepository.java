package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Group findById(int id) {
        return groups.get(id-1);
    }

    public void update(int id, Map<String, String> info) {
        Optional<String> name = Optional.ofNullable(info.get("name"));
        Optional<String> note = Optional.ofNullable(info.get("note"));
        if (name.isPresent()){
            groups.get(id-1).setName(name.get());
        }
        if (note.isPresent()){
            groups.get(id-1).setNote(note.get());
        }
    }
}
