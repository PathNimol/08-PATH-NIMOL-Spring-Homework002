package org.example.springhomework002.controller;

import lombok.RequiredArgsConstructor;
import org.example.springhomework002.model.dto.request.StudentRequest;
import org.example.springhomework002.model.dto.response.ApiResponse;
import org.example.springhomework002.model.entity.Student;
import org.example.springhomework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(
            @RequestParam(defaultValue = "1") Long page,
            @RequestParam(defaultValue = "5") Long size) {
        List<Student> students = studentService.getAllStudents(page, size);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Get all students successful!")
                .payload(students)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long id) {
        Student student = studentService.getStudentById(id);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Get student by ID " + id + " successful!")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest request) {
        Student student = studentService.addStudent(request);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Student added successfully!")
                .payload(student)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable("student-id") Long studentId,
            @RequestBody StudentRequest request) {
        Student student = studentService.updateStudentById(studentId, request);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Student ID " + studentId + " updated successfully!")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("student-id") Long studentId) {
        studentService.deleteStudentById(studentId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Student ID " + studentId + " deleted successfully!")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}