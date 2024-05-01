package com.example.customerservice.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Data
public class Customers {

    private List<Customer> customerList;

    public Customers(){}

   public Customers(Spliterator<Customer> spliterator){
       customerList = StreamSupport.stream(spliterator,false).collect(Collectors.toList());
   }

}
