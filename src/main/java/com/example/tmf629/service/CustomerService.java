package com.example.tmf629.service;

import com.example.tmf629.dto.CustomerDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(String id);
    void deleteCustomerById(String id);
}
