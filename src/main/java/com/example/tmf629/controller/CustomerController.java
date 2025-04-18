package com.example.tmf629.controller;

import com.example.tmf629.dto.partyrole.CustomerDTO;
import com.example.tmf629.dto.partyrole.PatchCustomerDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerController {
    ResponseEntity<CustomerDTO> createCustomer(CustomerDTO dto, HttpServletRequest request);
    ResponseEntity<List<CustomerDTO>> getAllCustomers(HttpServletRequest request);
    ResponseEntity<CustomerDTO> getCustomerById(String id, HttpServletRequest request);
    ResponseEntity<CustomerDTO> patchCustomer(String id, PatchCustomerDTO dto, HttpServletRequest request);
    ResponseEntity<Void> deleteCustomerById(String id);
}
