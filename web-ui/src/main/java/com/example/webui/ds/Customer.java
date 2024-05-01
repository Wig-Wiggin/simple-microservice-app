package com.example.webui.ds;


import lombok.*;


@AllArgsConstructor
@Data
public class Customer {


    private int id;

    private String name;

    private String email;

    private String address;

    public Customer(){}

}
