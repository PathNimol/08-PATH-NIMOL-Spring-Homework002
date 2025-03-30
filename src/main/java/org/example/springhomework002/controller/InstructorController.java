package org.example.springhomework002.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    @Operation(summary = "Get All Instructors")
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Long page,
                                                                           @RequestParam(defaultValue = "5") Long size) {
        List<Instructor> instructors = instructorService.getAllInstructors(page, size);
        ApiResponse<List<Instructor>> apiResponse = ApiResponse.<List<Instructor>>builder()
                .message("All Instructor have been successfully FETCHED")
                .payload(instructors)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{instructor-id}")
    @Operation(summary = "Get an Instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("A Students ID <" + instructorId + "> has been FOUND")
                .payload(instructor)
                .status(HttpStatus.FOUND)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
    }

    @PutMapping("/{instructor-id}")
    @Operation(summary = "Update an Instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor-id") Long instructorId,
                                                                        @RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.updateInstructorById(instructorId, request);
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("An Instructor ID <" + instructorId + "> has been UPDATED")
                .payload(instructor)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "Add a new Instructor")
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.addInstructor(request);
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("An Instructor has been ADDED successfully")
                .payload(instructor)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{instructor-id}")
    @Operation(summary = "Delete an Instructor by ID")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId) {
        instructorService.deleteInstructorById(instructorId);
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("An Instructor ID <" + instructorId + "> has been DELETED")
                .payload(null)
                .status(HttpStatus.NO_CONTENT)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

}
