package dao;

import model.Course;
import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();

        String query = "SELECT * FROM Courses";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String code = rs.getString("courseCode");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                int cap = rs.getInt("capacity");
                String schedule = rs.getString("schedule");

                Course course = new Course(code, title, desc, cap, schedule);
                courses.add(course);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching courses: " + e.getMessage());
        }

        return courses;
    }
    
    public boolean addCourse(Course course) {
        String query = "INSERT INTO Courses (courseCode, title, description, capacity, schedule) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getTitle());
            stmt.setString(3, course.getDescription());
            stmt.setInt(4, course.getCapacity());
            stmt.setString(5, course.getSchedule());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  // Return true if the course was successfully added

        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
            return false;
        }
    }
}
