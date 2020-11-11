package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groups")
@Validated
public class  GroupController {

    private final GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups(@RequestParam(defaultValue = "false") boolean regroup) {
        if (regroup) {
            return groupService.regroup();
        }
        return groupService.getGroups();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void rename(@PathVariable int id, @RequestBody Map<String, String> info) {
        groupService.rename(id,info.get("name"));
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable @Min(0) @Max(6) int id) {
        return groupService.getGroup(id);
    }
}
