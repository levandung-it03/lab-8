-- ----------------------------------------------------------------- --
-- Our RDBMS is "MySQL" or "MariaDB"                                 --
-- This is the initialization of "Student_Management" Database       --
-- Please follow these one step by step before starting the project  --
-- ----------------------------------------------------------------- --

-- 1. Install "XAMPP" and "mysql-connector-j-8.2.0" Dependencies to run MySQL or MariaDB

-- 2. Start "MySQL" and "Apache" Servers

-- 3. Go to "Admin" of "MySQL":

-- 4. Open new SQL Query:
CREATE DATABASE Student_Management

-- 5. Open new SQL Query:
USE Student_Management;
CREATE TABLE Student (
    student_id VARCHAR(20) UNIQUE NOT NULL,
    last_name VARCHAR(100) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	grade_code VARCHAR(20) NOT NULL,
	grade_name VARCHAR(100) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	email VARCHAR(30) UNIQUE NOT NULL,
    CONSTRAINT PK_Student PRIMARY KEY (student_id),
    CONSTRAINT UK_student_id_grade_code UNIQUE (student_id, grade_code)
);
INSERT INTO Student (student_id, last_name, first_name, grade_code, grade_name, phone, email)
VALUES
	('N21DCCN021', 'Le Van', 'Dung', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863928', 'levandung.it03@gmail.com'),
	('N21DCCN001', 'Nguyen Van', 'A', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863930', 'nguyenvana.2003@gmail.com'),
	('N21DCCN002', 'Le Van', 'B', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863950', 'levanb.2003@gmail.com');