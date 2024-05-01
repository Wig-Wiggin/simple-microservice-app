package com.example.webui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Data
@AllArgsConstructor
public class Departments {

    private List<Department> departments;

    public Departments(){

    }
    public Departments(Spliterator<Department> spliterator){
        departments = StreamSupport
                .stream(spliterator,false)
                .collect(Collectors.toList());
    }

}