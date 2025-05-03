package ui;

import dao.StudentCourseDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewAllFrame extends JFrame {

    public ViewAllFrame() {
        setTitle("All Registrations");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        BackgroundPanel bgPanel = new BackgroundPanel("/images/bg2.jpg");
        bgPanel.setLayout(new BorderLayout());
        setContentPane(bgPanel);

        String[] columns = {"Student ID", "Student Name", "Course Code", "Course Title"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        StudentCourseDAO dao = new StudentCourseDAO();
        List<String[]> data = dao.getAllRegistrations();
        for (String[] row : data) {
            model.addRow(row);
        }

        bgPanel.add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
