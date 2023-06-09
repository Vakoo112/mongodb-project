/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.controller;

import java.util.List;

/**
 *
 * @author VAKO
 */
public class ErrorResponse {
    private String message;
    private List<String> errors;

    public ErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}