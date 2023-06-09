/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mongodbexample.repository;

import com.example.mongodbexample.entity.Student;
import com.example.mongodbexample.repository.query.CustomRepository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VAKO
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String>, CustomRepository {

    List<Student> findByName(String name);

    Student findByEmailAndName(String email, String name);

    Student findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptname);

    List<Student> findBySubjectsSubjectName(String subName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String deptId);

    @Query("{\"name\" : \"?0\"}")
    List<Student> getByName(String name);

}
