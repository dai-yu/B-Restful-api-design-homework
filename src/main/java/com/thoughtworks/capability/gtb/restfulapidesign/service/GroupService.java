package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public Group getGroup(int id) {
        return groupRepository.findById(id);
    }

    public void updateInformation(int id, Map<String, String> info) {
        groupRepository.update(id, info);
    }
}
