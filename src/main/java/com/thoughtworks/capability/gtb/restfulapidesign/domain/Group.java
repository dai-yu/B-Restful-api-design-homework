package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Group {
    private int id;
    private String name;
    private String note;
    private List<Student> students;

    public Group(int id) {
        this.id = id;
        this.name="第"+id+"组";
        this.students = new ArrayList<>();
    }
}
