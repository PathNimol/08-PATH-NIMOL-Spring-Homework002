-- For create table
CREATE TABLE IF NOT EXISTS students
(
    student_id   serial primary key,
    student_name varchar(50)  not null,
    email        varchar(100) not null,
    phone_number varchar(20)
)

CREATE TABLE IF NOT EXISTS instructors
(
    instructor_id   SERIAL PRIMARY KEY,
    instructor_name VARCHAR(100) NOT NULL,
    email           VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses
(
    course_id     SERIAL PRIMARY KEY,
    course_name   VARCHAR(100) NOT NULL,
    description   TEXT,
    instructor_id INT,
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES instructors (instructor_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS student_course
(
    id         SERIAL PRIMARY KEY,
    student_id INT,
    course_id  INT,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students (student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses (course_id) ON DELETE CASCADE ON UPDATE CASCADE
);