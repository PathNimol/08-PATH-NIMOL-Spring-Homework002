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
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<Student> students = studentService.getAllStudents(page, size);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Get all students successful!")
                .payload(students)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("id") Long id) {
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

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable("id") Long id,
            @RequestBody StudentRequest request) {
        Student student = studentService.updateStudentById(id, request);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Student ID " + id + " updated successfully!")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Student ID " + id + " deleted successfully!")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}