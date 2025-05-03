package ui;

import dao.RegistrationDAO;
import model.Registration;
import model.Student;
import model.Course;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.util.List;

public class Main {
    private static RegistrationDAO dao = new RegistrationDAO();
    
    Main(){
    	SwingUtilities.invokeLater(() -> createUI());
    }

    private static void createUI() {
        JFrame frame = new JFrame("Student Course Registration System");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel("/images/bg.jpg"); 
        frame.setContentPane(backgroundPanel);
        
        JLabel titleLabel = new JLabel("Student Course Registration System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); 
        titleLabel.setBounds(0, 20, 700, 150);
        frame.add(titleLabel);
        
        ImageIcon image = new ImageIcon(Main.class.getResource("/images/logo2.png"));
        Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        titleLabel.setIcon(new ImageIcon(scaledImage));


        JButton registerBtn = new JButton("Register Student to Course");
        registerBtn.setBackground(new Color(0x4CAF50)); 
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 16));
        registerBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        registerBtn.setFocusPainted(false);
        registerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerBtn.setBounds(50, 230, 250, 50);


        JButton dropBtn = new JButton("Drop Student from Course");
        dropBtn.setBackground(Color.red); 
        dropBtn.setForeground(Color.WHITE);
        dropBtn.setFont(new Font("Arial", Font.BOLD, 16));
        dropBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        dropBtn.setFocusPainted(false);
        dropBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dropBtn.setBounds(350, 230, 250, 50);

        JButton viewAllBtn = new JButton("View All Registrations");
        viewAllBtn.setBackground(Color.BLUE); 
        viewAllBtn.setForeground(Color.WHITE);
        viewAllBtn.setFont(new Font("Arial", Font.BOLD, 16));
        viewAllBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        viewAllBtn.setFocusPainted(false);
        viewAllBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewAllBtn.setBounds(200, 380, 250, 50);        

        JButton viewStudentsBtn = new JButton("View Students");
        viewStudentsBtn.setBackground(Color.ORANGE); 
        viewStudentsBtn.setForeground(Color.BLACK);
        viewStudentsBtn.setFont(new Font("Arial", Font.BOLD, 16));
        viewStudentsBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        viewStudentsBtn.setFocusPainted(false);
        viewStudentsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewStudentsBtn.setBounds(50, 300, 250, 50);

        JButton viewCoursesBtn = new JButton("View Courses");
        viewCoursesBtn.setBackground(Color.yellow); 
        viewCoursesBtn.setForeground(Color.BLACK);
        viewCoursesBtn.setFont(new Font("Arial", Font.BOLD, 16));
        viewCoursesBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        viewCoursesBtn.setFocusPainted(false);
        viewCoursesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewCoursesBtn.setBounds(350, 300, 250, 50);

        frame.add(registerBtn);
        frame.add(dropBtn);
        frame.add(viewAllBtn);
        frame.add(viewStudentsBtn);
        frame.add(viewCoursesBtn);

        registerBtn.addActionListener(e -> {
        	new RegisterStudentFrame();
        });

        dropBtn.addActionListener(e -> {
        	new DropCourseFrame();
        });

        viewAllBtn.addActionListener(e -> {
            new ViewAllFrame();
        });

        viewStudentsBtn.addActionListener(e -> {
        	new ViewStudentsFrame();
        });

        viewCoursesBtn.addActionListener(e -> {
           new ViewCourseFrame();
        });

        frame.setVisible(true);
    }
}
