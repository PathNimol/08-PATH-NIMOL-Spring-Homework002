package org.example.springhomework002.service.impl;

import org.example.springhomework002.model.dto.request.StudentRequest;
import org.example.springhomework002.model.entity.Student;
import org.example.springhomework002.repository.StudentCourseRepository;
import org.example.springhomework002.repository.StudentRepository;
import org.example.springhomework002.service.StudentService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return studentRepository.getAllStudents(offset, size);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student addStudent(StudentRequest request) {
        try {
            Student student = studentRepository.addStudent(request);
            if (request.getCourseIds() != null && !request.getCourseIds().isEmpty()) {
                for (Long courseId : request.getCourseIds()) {
                    studentCourseRepository.saveStudentIdAndCourseId(student.getStudentId(), courseId);
                }
                student.setCourses(studentCourseRepository.getAllCoursesByStudentId(student.getStudentId()));
            }
            return student;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Failed to create student due to invalid data: " + e.getMostSpecificCause().getMessage(), e);
        }
    }

    @Override
    public Student updateStudentById(Long id, StudentRequest request) {
        Student updatedStudent = studentRepository.updateStudentById(id, request);
        if (updatedStudent != null && request.getCourseIds() != null) {
            studentCourseRepository.deleteCoursesByStudentId(id);
            for (Long courseId : request.getCourseIds()) {
                studentCourseRepository.saveStudentIdAndCourseId(id, courseId);
            }
            updatedStudent.setCourses(studentCourseRepository.getAllCoursesByStudentId(id));
        }
        return updatedStudent;
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " not found");
        }
        studentRepository.deleteStudentById(id);
    }
}