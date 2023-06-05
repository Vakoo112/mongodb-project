/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.controller;

import com.example.mongodbexample.entity.Student;
import com.example.mongodbexample.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VAKO
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PutMapping("/update")
    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable String id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/studentsByEmailAndName")
    public Student getByEmailAndName(@RequestParam String email, @RequestParam String name) {
        return studentService.getByEmailAndName(email, name);
    }

    @GetMapping("/studentsByEmailOrName")
    public Student getByEmailOrName(@RequestParam String email, @RequestParam String name) {
        return studentService.getByEmailOrName(email, name);
    }

    @GetMapping("/getByDepartmentDepartmentName")
    public List<Student> getByDepartmentDepartmentName(@RequestParam String deptname) {
        return studentService.getByDepartmentDepartmentName(deptname);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo,
            @RequestParam int pageSize) {
        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> allWithSorting() {
        return studentService.allWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName) {
        return studentService.getByDepartmentDepartmentName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName) {
        return studentService.getBySubjectSubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email) {
        return studentService.getByEmailIsLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name) {
        return studentService.getfindByNameStartsWith(name);
    }

}
