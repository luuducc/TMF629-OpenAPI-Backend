package com.example.tmf629.respository.impl;

import com.example.tmf629.model.party.Customer;
import com.example.tmf629.respository.CustomerRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    public Customer updateById(String id, Customer customer) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();

        if (customer.getName() != null) {
            update.set("name", customer.getName());
        }

        if (customer.getEngagedParty() != null) {
            update.set("engagedParty", customer.getEngagedParty());
        }

        if (customer.getStatus() != null) {
            update.set("status", customer.getStatus());
        }

        if (customer.getContactMedium() != null) {
            update.set("contactMedium", customer.getContactMedium());
        }
        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);

        System.out.println("result: " + result.getModifiedCount());
        System.out.println("result: " + result.getMatchedCount());

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
