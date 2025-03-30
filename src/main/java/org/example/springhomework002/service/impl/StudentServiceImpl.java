package org.example.springhomework002.service.impl;

import org.example.springhomework002.model.dto.request.StudentRequest;
import org.example.springhomework002.model.entity.Student;
import org.example.springhomework002.repository.CourseRepository;
import org.example.springhomework002.repository.StudentCourseRepository;
import org.example.springhomework002.repository.StudentRepository;
import org.example.springhomework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<Student> getAllStudents(Long page, Long size) {
        page = (page - 1) * size;
        return studentRepository.getAllStudents(page, size);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student addStudent(StudentRequest request) {
        Student student = studentRepository.addStudent(request);
        for(Long courseId : request.getCourseIds()) {
            studentCourseRepository.saveStudentIdAndCourseId(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {
        return studentRepository.updateStudentById(studentId, request);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteStudentById(studentId);
    }
}