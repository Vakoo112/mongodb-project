/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.repository.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author VAKO
 */
public class DynamicQuery {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Query buildQuery() {
        Query query = new Query();

        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name));
        }

        if (email != null) {
            query.addCriteria(Criteria.where("email").is(email));
        }

        return query;
    }
}