package com.example.tmf629.controller.impl;

import com.example.tmf629.controller.CustomerController;
import com.example.tmf629.dto.CustomerDTO;
import com.example.tmf629.service.CustomerService;
import com.example.tmf629.utils.ValidationUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerManagement/v1/customer")
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    private CustomerService customerService;

    @Override
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO dto, HttpServletRequest request) {
        ValidationUtils.checkRequired(dto.getName(), "name");

        CustomerDTO createdUser = customerService.createCustomer(dto);

        String href = request.getRequestURL() + "/" + createdUser.getId();
        createdUser.setHref(href);
        return ResponseEntity.ok(createdUser);
    }

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

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id, HttpServletRequest request) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        customerDTO.setHref(request.getRequestURL().toString());
        return ResponseEntity.ok(customerDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build(); // 204 status code
    }
}
