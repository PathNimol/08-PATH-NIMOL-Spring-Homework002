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
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return instructorRepository.getAllInstructors(offset, size);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor addInstructor(InstructorRequest request) {
        return instructorRepository.addInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(Long id, InstructorRequest request) {
        return instructorRepository.updateInstructorById(id, request);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);
    }
}