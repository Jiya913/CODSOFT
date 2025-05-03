package dao;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDAO {

    public List<String[]> getAllRegistrations() {
        List<String[]> data = new ArrayList<>();

        String query = "SELECT r.studentID, s.name, r.courseCode, c.title " +
                       "FROM Registrations r " +
                       "JOIN Students s ON r.studentID = s.studentID " +
                       "JOIN Courses c ON r.courseCode = c.courseCode;";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String sid = rs.getString("studentID");
                String sname = rs.getString("name");
                String ccode = rs.getString("courseCode");
                String cname = rs.getString("title");
                data.add(new String[]{sid, sname, ccode, cname});
            }

        } catch (SQLException e) {
            System.out.println("Error loading registrations: " + e.getMessage());
        }

        return data;
    }
}
