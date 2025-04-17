package com.example.tmf629.controller.impl;

import com.example.tmf629.controller.CustomerController;
import com.example.tmf629.dto.CustomerDTO;
import com.example.tmf629.dto.PatchCustomerDTO;
import com.example.tmf629.service.CustomerService;
import com.example.tmf629.utils.ValidationUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customerManagement/v1/customer")
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    private CustomerService customerService;

    // Create customer
    @Override
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(
            @RequestBody @Valid CustomerDTO dto,
            HttpServletRequest request
    ) {
        CustomerDTO createdUser = customerService.createCustomer(dto);

        String href = request.getRequestURL() + "/" + createdUser.getId();
        createdUser.setHref(href);

        return ResponseEntity.created(URI.create(href)).body(createdUser);
    }

    // Get all customer
    @Override
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(HttpServletRequest request) {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        String baseUrl = request.getRequestURL().toString();
        customerDTOS.forEach(customerDTO -> {
            customerDTO.setHref(baseUrl + "/" + customerDTO.getId());
        });

        return ResponseEntity.ok(customerDTOS);
    }

    // Get customer by ID
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id, HttpServletRequest request) {
        ValidationUtils.checkID(id);
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        customerDTO.setHref(request.getRequestURL().toString());
        return ResponseEntity.ok(customerDTO);
    }

    // Partially update customer by ID
    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDTO> patchCustomer(
            @PathVariable String id, @RequestBody PatchCustomerDTO dto, HttpServletRequest request
    ) {
        ValidationUtils.checkID(id);
        CustomerDTO updatedCustomerDto = customerService.patchCustomerById(id, dto);
        updatedCustomerDto.setHref(request.getRequestURL().toString());
        return ResponseEntity.ok(updatedCustomerDto);
    }

    // Delete customer by ID
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String id) {
        ValidationUtils.checkID(id);
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build(); // 204 status code
    }
}
