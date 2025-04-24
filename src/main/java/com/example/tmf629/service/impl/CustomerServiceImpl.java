package com.example.tmf629.service.impl;

import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.model.enums.StatusType;
import com.example.tmf629.exception.IDNotFoundException;
import com.example.tmf629.mapper.party.CustomerMapper;
import com.example.tmf629.mapper.party.PatchCustomerMapper;
import com.example.tmf629.model.party.Customer;
import com.example.tmf629.respository.CustomerRepository;
import com.example.tmf629.service.CustomerService;
import com.example.tmf629.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        ValidationUtils.requireNotBlank(dto.getName(), "name");
        ValidationUtils.requireNotBlank(String.valueOf(dto.getType()), "@type");
        ValidationUtils.requireNotNull(dto.getEngagedParty(), "engagedParty");

        // Set status to Created
        dto.setStatus(StatusType.Created);

        Customer customer = customerRepository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getCustomersWithPagination(List<String> fields, int offset, int limit) {
        return customerRepository.findWithFilter(fields, offset, limit).stream()
                .map(CustomerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(String id, List<String> fields) {
        Customer customer = customerRepository.findById(id, fields);
        if (customer == null) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomerById(String id, CustomerDTO dto) {
        if (!customerRepository.existsById(id)) {
            throw new IDNotFoundException("ID " + id + " not exists");
        }
        Customer customer = PatchCustomerMapper.toEntity(dto);
        Customer updatedCustomer = customerRepository.updateById(id, customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(String id) {
        if (!customerRepository.existsById(id)) {
            throw new IDNotFoundException("ID " + id + " not exists");
        }
        customerRepository.deleteById(id);
    }
}
