package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {

    @Autowired
    private StudentRepository studentRepository;

    private List<Group> groups = initList();

    private List<Group> initList() {
        return new ArrayList<>(6);
    }

    public List<Group> getGroups() {
        return groups;
    }
}
