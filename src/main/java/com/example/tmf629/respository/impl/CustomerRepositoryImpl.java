package com.example.tmf629.respository.impl;

import com.example.tmf629.model.partyrole.Customer;
import com.example.tmf629.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Customer save(Customer customer) {
        return mongoTemplate.insert(customer);
    }

    @Override
    public List<Customer> findAll() {
        return mongoTemplate.findAll(Customer.class);
    }

    @Override
    public Customer findById(String id) {
        return mongoTemplate.findById(id, Customer.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Customer.class);
    }

    @Override
    public boolean existsById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.exists(query, Customer.class);
    }
}
