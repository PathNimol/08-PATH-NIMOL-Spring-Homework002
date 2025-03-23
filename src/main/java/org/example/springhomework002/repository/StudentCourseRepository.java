package org.example.springhomework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework002.model.entity.Course;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Insert("""
        INSERT INTO student_course (student_id, course_id)
        VALUES (#{student_id}, #{course_id});
    """)
    void saveStudentIdAndCourseId(@Param("student_id") Long studentId, @Param("course_id") Long courseId);

    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.example.springhomework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
            SELECT c.course_id, c.course_name, c.description, c.instructor_id
            FROM student_course sc
            INNER JOIN courses c ON c.course_id = sc.course_id
            WHERE sc.student_id = #{student_id};
            """)
    List<Course> getAllCoursesByStudentId(@Param("student_id") Long studentId);

    @Delete("DELETE FROM student_course WHERE student_id = #{student_id}")
    void deleteCoursesByStudentId(@Param("student_id") Long studentId);
}