package com.example.tmf629.service.impl;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.dto.party.PatchCustomerDTO;
import com.example.tmf629.model.enums.CustomerStatus;
import com.example.tmf629.exception.IDNotFoundException;
import com.example.tmf629.mapper.party.CustomerMapper;
import com.example.tmf629.mapper.party.PatchCustomerMapper;
import com.example.tmf629.model.party.Customer;
import com.example.tmf629.respository.CustomerRepository;
import com.example.tmf629.service.CustomerService;
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
        // Set status to Created
        dto.setStatus(CustomerStatus.Created);

        // Set default value for account
        AccountRefDTO[] accounts = dto.getAccount();
        for (AccountRefDTO account : accounts != null ? accounts : new AccountRefDTO[]{}) {
            if (account.getBaseType() == null) {
                account.setBaseType("AccountRef");
            }
            if (account.getType() == null) {
                account.setType("AccountRef");
            }
        }
        Customer customer = customerRepository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomerById(String id, PatchCustomerDTO customerDTO) {
        if (!customerRepository.existsById(id)) {
            throw new IDNotFoundException("ID " + id + " not exists");
        }
        Customer customer = PatchCustomerMapper.toEntity(customerDTO);
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
