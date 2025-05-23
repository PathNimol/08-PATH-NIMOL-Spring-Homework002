--For insert data select update ...
--Students
INSERT INTO students (student_name, email, phone_number)
VALUES ('John Smith', 'john.smith@email.com', '555-123-4567'),
       ('Emma Johnson', 'emma.johnson@email.com', '555-234-5678'),
       ('Michael Brown', 'michael.brown@email.com', '555-345-6789'),
       ('Sophia Davis', 'sophia.davis@email.com', '555-456-7890'),
       ('James Wilson', 'james.wilson@email.com', '555-567-8901'),
       ('Olivia Taylor', 'olivia.taylor@email.com', '555-678-9012'),
       ('William Anderson', 'william.anderson@email.com', '555-789-0123'),
       ('Isabella Martinez', 'isabella.martinez@email.com', '555-890-1234'),
       ('Ethan Thomas', 'ethan.thomas@email.com', '555-901-2345'),
       ('Ava Garcia', 'ava.garcia@email.com', '555-012-3456'),
       ('Alexander Lee', 'alexander.lee@email.com', '555-123-5678'),
       ('Mia Rodriguez', 'mia.rodriguez@email.com', '555-234-6789'),
       ('Daniel Clark', 'daniel.clark@email.com', '555-345-7890'),
       ('Charlotte White', 'charlotte.white@email.com', '555-456-8901'),
       ('Liam Harris', 'liam.harris@email.com', '555-567-9012'),
       ('Amelia Lewis', 'amelia.lewis@email.com', '555-678-0123'),
       ('Noah Walker', 'noah.walker@email.com', '555-789-1234'),
       ('Harper Hall', 'harper.hall@email.com', '555-890-2345'),
       ('Lucas Allen', 'lucas.allen@email.com', '555-901-3456'),
       ('Evelyn Young', 'evelyn.young@email.com', '555-012-4567'),
       ('Mason King', 'mason.king@email.com', '555-123-6789'),
       ('Logan Scott', 'logan.scott@email.com', '555-234-7890'),
       ('Ella Adams', 'ella.adams@email.com', '555-345-8901'),
       ('Jackson Baker', 'jackson.baker@email.com', '555-456-9012'),
       ('Lily Nelson', 'lily.nelson@email.com', '555-567-0123');

--Instructors
INSERT INTO instructors (instructor_name, email)
VALUES ('Tann Dara', 'tandara@hrdcenter.edu'),
       ('Kheng Sovannak', 'sovannak@hrdcenter.edu'),
       ('Chhun Ratanakkosal', 'ratanakkosal@hrdcenter.edu'),
       ('Penh Seyha', 'seyha@hrdcenter.edu'),
       ('Vong Yuoyi', 'yuoyi@hrdcenter.edu'),
       ('Srey Sitharo', 'sitharo@hrdcenter.edu'),
       ('Chea Menglim', 'david.t@hrdcenter.edu'),
       ('Kouern Doch', 'lisa.a@hrdcenter.edu'),
       ('Doeun Kongden', 'james.m@hrdcenter.edu'),
       ('Polen Sok', 'jennifer.t@hrdcenter.edu'),
       ('Seab Lundy', 'william.c@hrdcenter.edu'),
       ('Vorn Naro', 'patricia.l@hrdcenter.edu'),
       ('Lay Rinda', 'thomas.w@hrdcenter.edu'),
       ('Meng Chantha', 'elizabeth.g@hrdcenter.edu'),
       ('Chan Sokheang', 'charles.r@hrdcenter.edu'),
       ('Leng Hongmeng', 'susan.m@hrdcenter.edu'),
       ('Vey Seavlang', 'joseph.a@hrdcenter.edu'),
       ('Lim Houyhyong', 'margaret.t@hrdcenter.edu'),
       ('Sovann Lina', 'richard.m@hrdcenter.edu'),
       ('Chea Phanith', 'nancy.b@hrdcenter.edu'),
       ('Daniel Jackson', 'daniel.j@hrdcenter.edu'),
       ('Linda Davis', 'linda.d@hrdcenter.edu'),
       ('Christopher Wilson', 'chris.w@hrdcenter.edu'),
       ('Barbara Martinez', 'barbara.m@hrdcenter.edu'),
       ('Paul Thompson', 'paul.t@hrdcenter.edu');

--Courses
INSERT INTO courses(course_name, description, instructor_id)
VALUES ('Java Programming', 'Basic programming concepts', 1),
       ('Database Systems', 'Relational database fundamentals', 2),
       ('Web Development', 'HTML, CSS, and JavaScript', 3),
       ('Data Structures', 'Algorithms and data organization', 4),
       ('Operating Systems', 'System architecture basics', 5),
       ('Computer Networks', 'Networking fundamentals', 6),
       ('Software Engineering', 'Development methodologies', 7),
       ('Artificial Intelligence', 'AI concepts and applications', 8),
       ('Machine Learning', 'ML algorithms and techniques', 9),
       ('Cybersecurity Basics', 'Security fundamentals', 10),
       ('Cloud Computing', 'Cloud infrastructure', 11),
       ('Mobile Development', 'iOS and Android apps', 12),
       ('Computer Graphics', '3D rendering basics', 13),
       ('Distributed Systems', 'System architecture', 14),
       ('Big Data Analytics', 'Data processing techniques', 15),
       ('Blockchain Technology', 'Crypto fundamentals', 16),
       ('Game Development', 'Game design principles', 17),
       ('DevOps Practices', 'CI/CD methodologies', 18),
       ('Internet of Things', 'IoT applications', 19),
       ('Quantum Computing', 'Quantum basics', 19),
       ('Computer Vision', 'Image processing', 21),
       ('Natural Language Processing', 'NLP techniques', 22),
       ('Parallel Computing', 'Multi-core processing', 23),
       ('Embedded Systems', 'Hardware programming', 24),
       ('Ethical Hacking', 'Penetration testing', 24);

--insert into student_course
INSERT INTO student_course (student_id, course_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 6),
    (6, 1),
    (7, 2),
    (8, 3),
    (9, 4),
    (10, 5),
    (11, 6),
    (12, 7),
    (13, 8),
    (14, 9),
    (16, 1),
    (17, 2),
    (18, 3),
    (19, 4),
    (21, 6),
    (22, 7),
    (23, 8),
    (24, 9),
    (1, 10),
    (5, 1),
    (10, 2),
    (15, 3),
    (7, 4);