package org.example.springhomework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework002.model.entity.Course;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "courseMapper", value = {
        @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructors", column = "instructor_id", one = @One(select = "org.example.springhomework002.repository.InstructorRepository.getInstructorById"))

    })
    @Select("""
            SELECT *
            FROM student_course sc
            INNER JOIN courses c ON sc.course_id = c.course_id
            WHERE student_id = #{studentId};
            """)
    List<Course> getAllCoursesByStudentId(Long studentId);

    @Insert("""
        INSERT INTO student_course
        VALUES (#{studentId}, #{courseId});
    """)
    void saveStudentIdAndCourseId(Long studentId, Long courseId);

}