package com.example.departmentservice.dao;

import com.example.departmentservice.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
