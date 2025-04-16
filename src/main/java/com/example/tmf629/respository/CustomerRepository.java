package com.example.tmf629.respository;

import com.example.tmf629.model.partyrole.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(String id);
    Customer updateById(String id, Customer customer);
    void deleteById(String id);
    boolean existsById(String id);
}
