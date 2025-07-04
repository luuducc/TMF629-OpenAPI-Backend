package com.example.tmf629.respository;

import com.example.tmf629.model.party.Customer;
import com.example.tmf629.pagination.LiveSearchResult;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
    List<Customer> findWithFilter(List<String> fields, int offset, int limit, String name);
    Customer findById(String id, List<String> fields);
    Customer updateById(String id, Customer customer);
    void deleteById(String id);
    boolean existsById(String id);
    long countDocuments();
    LiveSearchResult<Customer> liveSearch(String keyword, int offset, int limit, String status, String party, String name, String sort);
}
