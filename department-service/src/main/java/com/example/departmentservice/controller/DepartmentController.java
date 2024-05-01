package com.example.departmentservice.controller;

import com.example.departmentservice.dao.DepartmentDao;
import com.example.departmentservice.ds.Departments;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentDao departmentDao;

    @GetMapping("/departments")
    public Departments listDepartments(){
        return new Departments(departmentDao
                .findAll()
                .spliterator());
    }
}