package com.example.webui.controller;

import com.example.webui.ds.Customers;
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
public class CustController {

    @Value("http://localhost:8080/customer/customers")
    private String backendUrl;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        ResponseEntity<Customers> responseEntity =
              restTemplate.getForEntity(backendUrl, Customers.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            model.addAttribute("customers", responseEntity
                    .getBody().getCustomers());
            return "index";
        } else
            throw new IllegalArgumentException(String
                    .format("Unable to list customer, received status %s",
                            responseEntity.getStatusCode()));

    }
}