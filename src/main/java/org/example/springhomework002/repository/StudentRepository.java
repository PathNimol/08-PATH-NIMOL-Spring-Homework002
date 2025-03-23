package org.example.springhomework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework002.model.dto.request.StudentRequest;
import org.example.springhomework002.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "org.example.springhomework002.repository.StudentCourseRepository.getAllCoursesByStudentId"))
    })
    @Select("SELECT * FROM students OFFSET #{offset} LIMIT #{limit}")
    List<Student> getAllStudents(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @ResultMap("studentMapper")
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student getStudentById(@Param("studentId") Long studentId);

    @ResultMap("studentMapper")
    @Select("""
            INSERT INTO students (student_name, email, phone_number)
            VALUES (#{request.studentName}, #{request.email}, #{request.phoneNumber})
            RETURNING *;
            """)
    Student addStudent(@Param("request") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
            UPDATE students
            SET student_name = #{request.studentName}, email = #{request.email}, phone_number = #{request.phoneNumber}
            WHERE student_id = #{studentId}
            RETURNING *;
            """)
    Student updateStudentById(@Param("studentId") Long studentId, @Param("request") StudentRequest request);

    @Delete("DELETE FROM students WHERE student_id = #{studentId}")
    void deleteStudentById(@Param("studentId") Long studentId);
}