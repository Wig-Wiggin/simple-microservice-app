package com.example.customerservice.controller;

import com.example.customerservice.dao.CustomerDao;
import com.example.customerservice.ds.Customer;
import com.example.customerservice.ds.Customers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDao customerDao;


    @GetMapping("/customers")
    public Customers customers(Iterable<Customer> all){
        return customers(customerDao.findAll());
    }
}
