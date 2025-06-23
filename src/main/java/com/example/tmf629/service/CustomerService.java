package com.example.tmf629.service;

import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.pagination.LiveSearchResult;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomersWithPagination(List<String> fields, int offset, int limit, String name);
    CustomerDTO getCustomerById(String id, List<String> fields);
    CustomerDTO patchCustomerById(String id, CustomerDTO customerDTO);
    long getCustomerCount();
    void deleteCustomerById(String id);
    LiveSearchResult<CustomerDTO> liveSearchCustomers(String keyword, int offset, int limit, String status, String party, String name, String sort);
}
