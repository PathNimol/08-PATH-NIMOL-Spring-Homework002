package org.example.springhomework002.service;

import org.example.springhomework002.model.dto.request.CourseRequest;
import org.example.springhomework002.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Long courseId);

    Course updateCourseById(Long courseId, CourseRequest request);

    Course addCourse(CourseRequest request);

    void deleteCourseById(Long courseId);
}
