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

        // Remove id field from dto if exists
        dto.setId(null);

        Customer customer = customerRepository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getCustomersWithPagination(List<String> fields, int offset, int limit, String name) {

        return customerRepository.findWithFilter(fields, offset, limit, name).stream()
                .map(CustomerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(String id, List<String> fields) {
        Customer customer = customerRepository.findById(id, fields);
        if (customer == null) {
            throw new IDNotFoundException(id);
        }
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomerById(String id, CustomerDTO dto) {
        if (!customerRepository.existsById(id)) {
            throw new IDNotFoundException(id);
        }
        Customer customer = PatchCustomerMapper.toEntity(dto);
        Customer updatedCustomer = customerRepository.updateById(id, customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    @Override
    public long getCustomerCount() {
        return customerRepository.countDocuments();
    }

    @Override
    public void deleteCustomerById(String id) {
        if (!customerRepository.existsById(id)) {
            throw new IDNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
}
