/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.repository.query;

import com.example.mongodbexample.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author VAKO
 */
public class CustomRepositoryImpl implements CustomRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Student> findStudentsByDynamicQuery(DynamicQuery dynamicQuery) {
        Query query = dynamicQuery.buildQuery();
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> findStudentsByNameRegex(String regex) {
        Criteria criteria = Criteria.where("name").regex(regex);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> findStudentsWithNameStartingWithA() {
        Criteria criteria = Criteria.where("name").regex("^A");
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Student.class);
    }
    
}
