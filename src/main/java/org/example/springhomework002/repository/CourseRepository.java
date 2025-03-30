package org.example.springhomework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework002.model.dto.request.CourseRequest;
import org.example.springhomework002.model.entity.Course;
import org.example.springhomework002.model.entity.Student;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapping", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructors", column = "instructor_id", one = @One(select = "org.example.springhomework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
            SELECT * FROM courses
            ORDER BY course_id
            OFFSET #{offset} LIMIT #{limit}
            """)
    List<Course> getAllCourses(@Param("offset") Integer page, @Param("limit") Integer size);

    @ResultMap("courseMapping")
    @Select("""
            SELECT * FROM courses WHERE course_id = #{courseId};
            """)
    Course getCourseById(Long courseId);

    @ResultMap("courseMapping")
    @Select("""
            UPDATE courses
            SET course_name = #{request.courseName}, description=#{request.description}, instructor_id=#{request.instructorId}
            WHERE course_id = #{courseId}
            RETURNING *;
           """)
    Course updateCourseById(Long courseId, @Param("request") CourseRequest request);

    @ResultMap("courseMapping")
    @Select("""
            INSERT INTO courses VALUES (default, #{req.courseName}, #{req.description}, #{req.instructorId})
            RETURNING *;
            """)
    Course createCourse(@Param("req") CourseRequest request);

    @Delete("""
            DELETE FROM courses WHERE course_id = #{courseId};
            """)
    void deleteCorseById(Long courseId);

}