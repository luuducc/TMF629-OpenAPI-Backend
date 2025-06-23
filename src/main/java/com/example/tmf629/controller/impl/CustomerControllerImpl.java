package com.example.tmf629.controller.impl;

import com.example.tmf629.controller.CustomerController;
import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.pagination.LiveSearchResult;
import com.example.tmf629.pagination.PageResponse;
import com.example.tmf629.pagination.PaginationMeta;
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

    // Get customers with pagination
//    @Override
//    @GetMapping
//    public ResponseEntity<PageResponse<CustomerDTO>> getCustomersWithPagination(
//            HttpServletRequest request,
//            @RequestParam(required = false) List<String> fields,
//            @RequestParam(defaultValue = "0") int offset,
//            @RequestParam(defaultValue = "20") int limit,
//            @RequestParam(required = false) String name
//    ) {
//        List<CustomerDTO> customerDTOS = customerService.getCustomersWithPagination(fields, offset, limit, name);
//        int pageCount = customerDTOS.size();
//        long total = customerService.getCustomerCount();
//
//        PaginationMeta paginationMeta = new PaginationMeta(total, pageCount, offset);
//
//        String baseUrl = request.getRequestURL().toString();
//        customerDTOS.forEach(customerDTO -> customerDTO.setHref(baseUrl + "/" + customerDTO.getId()));
//        PageResponse<CustomerDTO> response = new PageResponse<>(paginationMeta, customerDTOS);
//        return ResponseEntity.ok(response);
//    }

    // Get customer by ID
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(
            @PathVariable String id,
            @RequestParam(required = false) List<String> fields,
            HttpServletRequest request) {
        ValidationUtils.checkID(id);
        CustomerDTO customerDTO = customerService.getCustomerById(id, fields);
        customerDTO.setHref(request.getRequestURL().toString());
        return ResponseEntity.ok(customerDTO);
    }

    // Partially update customer by ID
    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDTO> patchCustomer(
            @PathVariable String id,
            @RequestBody @Valid CustomerDTO dto,
            HttpServletRequest request
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

    // Live search
    @Override
    @GetMapping
    public ResponseEntity<PageResponse<CustomerDTO>> searchCustomer(
            @RequestParam("search") String keyword,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String party,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sort
    ) {
        System.out.println("go to here");
        LiveSearchResult<CustomerDTO> searchResult = customerService.liveSearchCustomers(keyword, offset, limit, status, party, name, sort);
        PaginationMeta paginationMeta = new PaginationMeta(searchResult.total(), searchResult.items().size(), offset);
        return ResponseEntity.ok(new PageResponse<>(paginationMeta, searchResult.items()));
    }
}
