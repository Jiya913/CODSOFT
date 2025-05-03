CREATE TABLE Courses (
    courseCode VARCHAR(10) PRIMARY KEY,
    title VARCHAR(50),
    description TEXT,
    capacity INT,
    schedule VARCHAR(20)
);

CREATE TABLE Students (
    studentID VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE Registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentID VARCHAR(10),
    courseCode VARCHAR(10),
    FOREIGN KEY (studentID) REFERENCES Students(studentID),
    FOREIGN KEY (courseCode) REFERENCES Courses(courseCode)
);

INSERT INTO Courses (courseCode, title, description, capacity, schedule)
VALUES ('CS101', 'Intro to CS', 'Basics of Computer Science', 50, 'Mon-Wed 10:00-11:00');

INSERT INTO Students (studentID, name)
VALUES 
('S002', 'Ravi Kumar'),
('S003', 'Ananya Verma'),
('S004', 'Amit Singh');

INSERT INTO Students (studentID, name)
VALUES ('S101', 'Jimmy');

INSERT INTO Courses (courseCode, title, description, capacity, schedule)
VALUES ('CS102', 'Intro to Java', 'Learn the basics of Java programming', 30, 'Mon-Wed 10AM-12PM');

select * from courses;
