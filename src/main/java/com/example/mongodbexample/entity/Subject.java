/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author VAKO
 */
@Getter
@Setter
@Document(collection="subject")
public class Subject {
    
    @Id
    private String id;
    @Field(name="subject_name")
    private String subjectName;
    @Field(name="marks_obtained")
    private int marksObtained;
}
