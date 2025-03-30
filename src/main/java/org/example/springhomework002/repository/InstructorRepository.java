package org.example.springhomework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework002.model.dto.request.InstructorRequest;
import org.example.springhomework002.model.entity.Instructor;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
    })
    @Select("""
            SELECT * FROM instructors
            OFFSET #{offset} LIMIT #{limit}
            """)
    List<Instructor> getAllInstructors(@Param("offset") Long offset, @Param("limit") Long limit);

    @ResultMap("instructorMapper")
    @Select("""
            SELECT * FROM instructors WHERE instructor_id = #{instructorId}
            """)
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Insert("""
            INSERT INTO instructors
            VALUES (#{request.instructorName}, #{request.email})
            RETURNING *;
            """)
    Instructor addInstructor(@Param("request") InstructorRequest request);

    @ResultMap("instructorMapper") // Fixed: Changed "instructorMapping" to "instructorMapper"
    @Update("""
            UPDATE instructors
            SET instructor_name = #{req.instructorName}, email = #{req.email}
            WHERE instructor_id = #{instructorId}
            RETURNING *;
            """)
    Instructor updateInstructorById(Long instructorId, @Param("req") InstructorRequest request);

    @Delete("DELETE FROM instructors WHERE instructor_id = #{instructorId}")
    void deleteInstructorById(Long instructorId);
}