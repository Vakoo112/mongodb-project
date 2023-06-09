/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.service;

import com.example.mongodbexample.entity.Student;
import com.example.mongodbexample.repository.DepartmentRepository;
import com.example.mongodbexample.repository.StudentRepository;
import com.example.mongodbexample.repository.SubjectRepository;
import com.example.mongodbexample.repository.query.DynamicQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author VAKO
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        if (student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }
        if (student.getSubjects() != null && student.getSubjects().size() > 0) {
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentbyId(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted.";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student studentsByNameAndMail(String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    public Student studentsByNameOrMail(String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");

        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }

    public List<Student> getByName(String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> findStudentsByDynamicQuery(DynamicQuery dynamicQuery) {
        return studentRepository.findStudentsByDynamicQuery(dynamicQuery);
    }

    public List<Student> findStudentsByNameRegex(String regex) {
        return studentRepository.findStudentsByNameRegex(regex);
    }

    public List<Student> findStudentsWithNameStartingWithA() {
        return studentRepository.findStudentsWithNameStartingWithA();
    }
}
