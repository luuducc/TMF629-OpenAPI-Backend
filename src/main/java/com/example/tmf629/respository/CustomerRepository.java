package com.example.tmf629.respository;

import com.example.tmf629.model.party.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
    List<Customer> findWithFilter(List<String> fields, int offset, int limit);
    Customer findById(String id, List<String> fields);
    Customer updateById(String id, Customer customer);
    void deleteById(String id);
    boolean existsById(String id);
}
