package ui;

import dao.CourseDAO;
import model.Course;

import javax.swing.*;
import java.awt.*;

public class NewCourseFrame extends JFrame {

    public NewCourseFrame() {
        setTitle("Register New Course");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        BackgroundPanel backgroundPanel = new BackgroundPanel("/images/Courses.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        JLabel titleLabel = new JLabel("Register New Course");
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(150, 70, 250, 30);
        backgroundPanel.add(titleLabel);

        JLabel courseCodeLabel = new JLabel("Course Code:");
        courseCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        courseCodeLabel.setForeground(Color.BLACK);
        courseCodeLabel.setBounds(110, 100, 120, 25);
        backgroundPanel.add(courseCodeLabel);
        
        JTextField courseCodeField = new JTextField();
        courseCodeField.setBounds(230, 100, 250, 25);
        backgroundPanel.add(courseCodeField);

        JLabel courseTitleLabel = new JLabel("Course Title:");
        courseTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        courseTitleLabel.setForeground(Color.BLACK);
        courseTitleLabel.setBounds(110, 140, 120, 25);
        backgroundPanel.add(courseTitleLabel);
        
        JTextField courseTitleField = new JTextField();
        courseTitleField.setBounds(230, 140, 250, 25);
        backgroundPanel.add(courseTitleField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setBounds(110, 180, 120, 25);
        backgroundPanel.add(descriptionLabel);
        
        JTextField descriptionField = new JTextField();
        descriptionField.setBounds(230, 180, 250, 25);
        backgroundPanel.add(descriptionField);

        JLabel capacityLabel = new JLabel("Capacity:");
        capacityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        capacityLabel.setForeground(Color.BLACK);
        capacityLabel.setBounds(110, 220, 120, 25);
        backgroundPanel.add(capacityLabel);
        
        JTextField capacityField = new JTextField();
        capacityField.setBounds(230, 220, 250, 25);
        backgroundPanel.add(capacityField);

        JLabel scheduleLabel = new JLabel("Schedule:");
        scheduleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scheduleLabel.setForeground(Color.BLACK);
        scheduleLabel.setBounds(110, 260, 120, 25);
        backgroundPanel.add(scheduleLabel);
        
        JTextField scheduleField = new JTextField();
        scheduleField.setBounds(230, 260, 250, 25);
        backgroundPanel.add(scheduleField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(180, 300, 120, 30);
        saveButton.setBackground(Color.GREEN);
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setFocusable(false);
        backgroundPanel.add(saveButton);

        saveButton.addActionListener(e -> {
            String courseCode = courseCodeField.getText().trim();
            String courseTitle = courseTitleField.getText().trim();
            String description = descriptionField.getText().trim();
            String capacity = capacityField.getText().trim();
            String schedule = scheduleField.getText().trim();

            if (courseCode.isEmpty() || courseTitle.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Course Code and Course Title are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Course course = new Course(courseCode, courseTitle, description, Integer.parseInt(capacity), schedule);

                CourseDAO courseDAO = new CourseDAO();
                boolean isSaved = courseDAO.addCourse(course);

                if (isSaved) {
                    JOptionPane.showMessageDialog(this, "Course registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Error while registering course!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
