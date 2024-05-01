package com.example.webui.controller;

import com.example.webui.ds.Departments;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/ui")
public class DepartController {
    @Value("http://localhost:8080/")
    private String backendUrl;
    private RestTemplate restTemplate=new RestTemplate();
    @GetMapping("/departments")
    public String listDepartments(Model model){
        ResponseEntity<Departments> responseEntity=
                restTemplate.getForEntity(backendUrl+"department/departments"
                        ,Departments.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            model.addAttribute("departments",responseEntity
                    .getBody().getDepartments());
            return "index";
        }
        else
            throw new IllegalArgumentException(String
                    .format("Unable to list department, received status %s",
                            responseEntity.getStatusCode()));
    }













}