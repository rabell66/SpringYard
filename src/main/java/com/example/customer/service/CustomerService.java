package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    void add(Customer customer);
    Customer getById(int id);
    List<Customer>  getAll();
    void update(Customer customer);
    void delete(int id);
}
