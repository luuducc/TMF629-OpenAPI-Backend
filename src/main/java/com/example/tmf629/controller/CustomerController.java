package com.example.tmf629.controller;

import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.dto.party.PatchCustomerDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerController {
    ResponseEntity<CustomerDTO> createCustomer(CustomerDTO dto, HttpServletRequest request);
    ResponseEntity<List<CustomerDTO>> getAllCustomers(HttpServletRequest request);
    ResponseEntity<CustomerDTO> getCustomerById(String id, HttpServletRequest request);
    ResponseEntity<CustomerDTO> patchCustomer(String id, CustomerDTO dto, HttpServletRequest request);
    ResponseEntity<Void> deleteCustomerById(String id);
}
