package org.example.springhomework002.controller;

import lombok.RequiredArgsConstructor;
import org.example.springhomework002.model.dto.request.CourseRequest;
import org.example.springhomework002.model.dto.response.ApiResponse;
import org.example.springhomework002.model.entity.Course;
import org.example.springhomework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<Course> courses = courseService.getAllCourses(page, size);
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched")
                .payload(courses)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course_id") Long courseId) {
        Course course = courseService.getCourseById(courseId);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Get Course by ID " + courseId + " successful!")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest request) {
        Course course = courseService.addCourse(request);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("A Course was added successfully")
                .payload(course)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(
            @PathVariable("course_id") Long courseId,
            @RequestBody CourseRequest request) {
        Course course = courseService.updateCourseById(courseId, request);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Course ID " + courseId + " updated successfully")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable("course_id") Long courseId) {
        courseService.deleteCourseById(courseId);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Course ID " + courseId + " was deleted!")
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}