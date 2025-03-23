package org.example.springhomework002.service;

import org.example.springhomework002.model.dto.request.InstructorRequest;
import org.example.springhomework002.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer page, Integer size);
    Instructor getInstructorById(Long id);
    Instructor addInstructor(InstructorRequest request);
    Instructor updateInstructorById(Long id, InstructorRequest request);
    void deleteInstructorById(Long id);
}