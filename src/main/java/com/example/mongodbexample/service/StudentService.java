/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodbexample.service;

import com.example.mongodbexample.entity.Student;
import com.example.mongodbexample.repository.DepartmentRepository;
import com.example.mongodbexample.repository.StudentRepository;
import com.example.mongodbexample.repository.SubjectRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    SubjectRepository subjectRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public Student createStudent(Student student) {
        if (student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }
        if (student.getSubjects() != null && student.getSubjects().size() > 0) {
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String deleteById(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student getByEmailAndName(String email, String name) {
        return studentRepository.findByEmailAndName(email, name);
    }

    public Student getByEmailOrName(String email, String name) {
        return studentRepository.findByEmailOrName(email, name);
    }

    public List<Student> getByDepartmentDepartmentName(String deptname) {
        return studentRepository.findByDepartmentDepartmentName(deptname);
    }

    public List<Student> getBySubjectSubjectName(String subName) {
        return studentRepository.findBySubjectSubjectName(subName);
    }

    public List<Student> getByEmailIsLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> getfindByNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> getfindByDepartmentId(String depId) {
        return studentRepository.findByDepartmentId(depId);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }
    
    	public List<Student> allWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
		
		return studentRepository.findAll(sort);		
	}
	

}
