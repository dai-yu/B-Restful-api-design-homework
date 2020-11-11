package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public List<Group> regroup() {
        return groupRepository.regroup();
    }

    public void rename(int id, String name) {
        groupRepository.rename(id,name);
    }

    public Group getGroup(int id) {
        return groupRepository.findById(id);
    }
}
