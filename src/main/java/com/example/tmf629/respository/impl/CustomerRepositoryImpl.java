package com.example.tmf629.respository.impl;

import com.example.tmf629.exception.DuplicateNameException;
import com.example.tmf629.model.party.Customer;
import com.example.tmf629.pagination.LiveSearchResult;
import com.example.tmf629.respository.CustomerRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Customer save(Customer customer) {
        try {
            return mongoTemplate.insert(customer);
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                // can miss cases here
                System.out.println("go in to exception");
                throw new DuplicateNameException(customer.getName());
            }
            System.out.println("Error: " + e.getMessage() + e.getClass().getName());
            return new Customer();
        }
    }

    @Override
    public List<Customer> findAll() {
        return mongoTemplate.findAll(Customer.class);
    }

    @Override
    public List<Customer> findWithFilter(List<String> fields, int offset, int limit, String name) {
        Query query = new Query().skip(offset).limit(limit);
        if (name != null && !name.isEmpty()) {
            // Use regex for "contains" search, case-insensitive
            query.addCriteria(Criteria.where("name").regex(".*" + Pattern.quote(name) + ".*", "i"));
        }

        if (fields != null && !fields.isEmpty()) {
            fields.forEach(field -> query.fields().include(field));
            // Optionally exclude _id if not explicitly requested
            if (!fields.contains("id") && !fields.contains("_id")) {
                query.fields().exclude("_id");
            }
        }
        return mongoTemplate.find(query, Customer.class);
    }

    @Override
    public Customer findById(String id, List<String> fields) {
        Query query = new Query(Criteria.where("id").is(id));

        if (fields != null && !fields.isEmpty()) {
            fields.forEach(field -> query.fields().include(field));

            // Optionally exclude _id if not explicitly requested
            if (!fields.contains("id") && !fields.contains("_id")) {
                query.fields().exclude("_id");
            }
        }

        return mongoTemplate.findOne(query, Customer.class);
    }

    @Override
    public Customer updateById(String id, Customer customer) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();

        setIfNotNull(update, "account", customer.getAccount());
        setIfNotNull(update, "agreement", customer.getAgreement());
        setIfNotNull(update, "characteristic", customer.getCharacteristic());
        setIfNotNull(update, "contactMedium", customer.getContactMedium());
        setIfNotNull(update, "creditProfile", customer.getCreditProfile());
        setIfNotNull(update, "description", customer.getDescription());
        setIfNotNull(update, "engagedParty", customer.getEngagedParty());
        setIfNotNull(update, "name", customer.getName());
        setIfNotNull(update, "partyRoleSpecification", customer.getPartyRoleSpecification());
        setIfNotNull(update, "paymentMethod", customer.getPaymentMethod());
        setIfNotNull(update, "relatedParty", customer.getRelatedParty());
        setIfNotNull(update, "role", customer.getRole());
        setIfNotNull(update, "status", customer.getStatus());
        setIfNotNull(update, "statusReason", customer.getStatusReason());
        setIfNotNull(update, "validFor", customer.getValidFor());

        try {
            if (!update.getUpdateObject().isEmpty()) {
                UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);
                System.out.println("result: " + result.getModifiedCount());
                System.out.println("result: " + result.getMatchedCount());
            } else {
                System.out.println("update is null");
            }
            return mongoTemplate.findById(id, Customer.class);
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                throw new DuplicateNameException(customer.getName());
            }
            System.out.println("Error: " + e.getMessage() + e.getClass().getName());
            return new Customer();
        }
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

    @Override
    public long countDocuments() {
        return mongoTemplate.estimatedCount(Customer.class);
    }

    @Override
    public LiveSearchResult<Customer> liveSearch(String keyword, int offset, int limit, String status, String party, String name, String sort) {
//        if (keyword == null || keyword.isEmpty()) {
//            return new LiveSearchResult<>(0, Collections.emptyList());
//        }
        // Create a case-insensitive regex pattern
        Pattern regex = Pattern.compile(".*" + Pattern.quote(keyword) + ".*", Pattern.CASE_INSENSITIVE);

        Criteria criteria = new Criteria().orOperator(
                Criteria.where("status").regex(regex),
                Criteria.where("name").regex(regex),
                Criteria.where("description").regex(regex),
                Criteria.where("engagedParty.referredType").regex(regex)
        );

        if (status != null && !status.isEmpty()) {
            criteria.and("status").is(status);
        }
        if (party != null && !party.isEmpty()) {
            criteria.and("engagedParty.referredType").is(party);
        }
        if (name != null && !name.isEmpty()) {
            criteria.and("name").regex(".*" + Pattern.quote(name) + ".*", "i");
        }

        Query query = new Query(criteria);

        if (sort != null && !sort.isEmpty()) {
            List<Sort.Order> orders = getOrders(sort);
            if (!orders.isEmpty()) {
                query.with(Sort.by(orders));
            }
        }

        long total = mongoTemplate.count(query, Customer.class);

        query.fields()
                .include("name")
                .include("status")
                .include("engagedParty.referredType")
                .include("description")
                .include("_id");
        query.skip(offset).limit(limit);

        return new LiveSearchResult<>(total, mongoTemplate.find(query, Customer.class));
    }

    // Helper methods
    private <T> void setIfNotNull(Update update, String fieldName, T value) {
        if (value != null) {
            update.set(fieldName, value);
        }
    }

    private List<Sort.Order> getOrders(String sortParams) {
        List<Sort.Order> orders = new ArrayList<>();

        for (String order : sortParams.split(",")) {
            if (order.isEmpty()) continue;

            if (order.startsWith("-")) {
                orders.add(Sort.Order.desc(order.substring(1)));
            } else {
                orders.add(Sort.Order.asc(order));
            }
        }
        return orders;
    }
}
