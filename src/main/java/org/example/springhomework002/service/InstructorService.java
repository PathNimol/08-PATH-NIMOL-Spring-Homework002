package org.example.springhomework002.service;

import org.example.springhomework002.model.dto.request.InstructorRequest;
import org.example.springhomework002.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Long page, Long size);

    Instructor getInstructorById(Long instructorId);

    Instructor addInstructor(InstructorRequest request);

    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

    void deleteInstructorById(Long instructorId);
}