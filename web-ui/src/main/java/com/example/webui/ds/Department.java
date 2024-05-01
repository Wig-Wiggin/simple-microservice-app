package com.example.webui.ds;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Department {

    private int id;
    private String code;
    private String name;
    private String country;
    public Department(){

    }
}