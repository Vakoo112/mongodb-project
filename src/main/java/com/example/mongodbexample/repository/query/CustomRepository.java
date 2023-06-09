/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mongodbexample.repository.query;

import com.example.mongodbexample.entity.Student;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VAKO
 */
@Repository
public interface CustomRepository {

    List<Student> findStudentsByDynamicQuery(DynamicQuery dynamicQuery);

    List<Student> findStudentsByNameRegex(String regex);

    List<Student> findStudentsWithNameStartingWithA();
}
