package org.example.springhomework002.service.impl;

import org.example.springhomework002.model.dto.request.InstructorRequest;
import org.example.springhomework002.model.entity.Instructor;
import org.example.springhomework002.repository.InstructorRepository;
import org.example.springhomework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors(Long page, Long size) {
        page = (page - 1) * size;
        return instructorRepository.getAllInstructors(page, size);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor addInstructor(InstructorRequest request) {
        return instructorRepository.addInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(Long instructorId, InstructorRequest request) {
        return instructorRepository.updateInstructorById(instructorId, request);
    }

    @Override
    public void deleteInstructorById(Long instructorId) {
        instructorRepository.deleteInstructorById(instructorId);
    }
}