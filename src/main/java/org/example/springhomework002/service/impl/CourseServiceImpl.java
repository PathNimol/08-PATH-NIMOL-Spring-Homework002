package org.example.springhomework002.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springhomework002.model.dto.request.CourseRequest;
import org.example.springhomework002.model.entity.Course;
import org.example.springhomework002.repository.CourseRepository;
import org.example.springhomework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        page = (page - 1) * size;
        return courseRepository.getAllCourses(page, size);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest request) {
        return courseRepository.updateCourseById(courseId, request);
    }

    @Override
    public Course addCourse(CourseRequest request) {
        return courseRepository.createCourse(request);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteCorseById(courseId);
    }

}

