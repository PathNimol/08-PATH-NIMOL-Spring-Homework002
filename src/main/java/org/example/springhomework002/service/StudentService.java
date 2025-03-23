package org.example.springhomework002.service;

import org.example.springhomework002.model.dto.request.StudentRequest;
import org.example.springhomework002.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents(Integer page, Integer size);

    Student addStudent(StudentRequest request);

    Student getStudentById(Long studentId);

    Student updateStudentById(Long studentId, StudentRequest request);

    void deleteStudentById(Long studentId);
}
