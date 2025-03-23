package org.example.springhomework002.controller;

import lombok.RequiredArgsConstructor;
import org.example.springhomework002.model.dto.request.InstructorRequest;
import org.example.springhomework002.model.dto.response.ApiResponse;
import org.example.springhomework002.model.entity.Instructor;
import org.example.springhomework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    //Retrieves a paginated list of instructors from the instructor repository.
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Integer page,
                                                                           @RequestParam(defaultValue = "10") Integer size) {
        List<Instructor> instructor = instructorService.getAllInstructors(page, size);
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .message("All instructors have been successfully fetched")
                .payload(instructor)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Retrieves an instructor with specific id from the instructor repository
    @GetMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> getAuthorById(@PathVariable("instructor_id") Long instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Get Instructor by ID " + instructorId + " successful!")
                .payload(instructor)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Update an instructor with specific id from the instructor repository
    @PutMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor_id") Long instructorId,
                                                                        @RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.updateInstructorById(instructorId, request);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Instructor ID " + instructorId + " updated successfully")
                .payload(instructor)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //Create new instructor
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.addInstructor(request);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("An Instructor was added successfully")
                .payload(instructor)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //Delete Instructor by ID
    @DeleteMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("instructor_id") Long instructorId) {
        instructorService.deleteInstructorById(instructorId);
        ApiResponse<Instructor> response =ApiResponse.<Instructor>builder()
                .message("Instructor ID " + instructorId + " was deleted!")
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
