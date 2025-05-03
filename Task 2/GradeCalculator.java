import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class GradeCalculator extends JFrame {

    JTextField inputMaths, inputScience, inputEnglish, inputHistory, inputComputer, inputName;
    JLabel label, maths, science, english, history, computer, nameLabel;
    JButton calculateButton;
    ImageIcon image;
    
    public GradeCalculator() {
        this.setTitle("Student Grade Calculator");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.CYAN);
        this.setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5)); 
        contentPane.setLayout(null); 
        contentPane.setBackground(Color.CYAN);
        this.setContentPane(contentPane); 


        label = new JLabel();
        label.setText("Grade Calculator");
        label.setForeground(Color.black);
        label.setBounds(50, 20, 400, 30);
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        this.add(label);

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 55, 420, 2); 
        this.add(separator);

        nameLabel = new JLabel("Enter Your Name: ");
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(20, 70, 400, 20);
        nameLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        this.add(nameLabel);

        inputName = new JTextField();
        inputName.setBounds(250, 60, 200, 30);
        this.add(inputName);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(20, 100, 420, 2); 
        this.add(separator2);

        maths = new JLabel();
        maths.setText("Maths: ");
        maths.setForeground(Color.black);
        maths.setBounds(30, 110, 150, 30);
        maths.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(maths);

        science = new JLabel();
        science.setText("Science: ");
        science.setForeground(Color.black);
        science.setBounds(30, 150, 150, 30);
        science.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(science);

        english = new JLabel();
        english.setText("English: ");
        english.setForeground(Color.black);
        english.setBounds(30, 200, 150, 30);
        english.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(english);

        history = new JLabel();
        history.setText("History: ");
        history.setForeground(Color.black);
        history.setBounds(30, 250, 150, 30);
        history.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(history);

        computer = new JLabel();
        computer.setText("Computer: ");
        computer.setForeground(Color.black);
        computer.setBounds(30, 300, 150, 30);
        computer.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(computer);

        inputMaths = new JTextField();
        inputMaths.setBounds(250, 110, 200, 30);
        this.add(inputMaths);

        inputScience = new JTextField();
        inputScience.setBounds(250, 150, 200, 30);
        this.add(inputScience);

        inputEnglish = new JTextField();
        inputEnglish.setBounds(250, 200, 200, 30);
        this.add(inputEnglish);

        inputHistory = new JTextField();
        inputHistory.setBounds(250, 250, 200, 30);
        this.add(inputHistory);

        inputComputer = new JTextField();
        inputComputer.setBounds(250, 300, 200, 30);
        this.add(inputComputer);

        calculateButton = new JButton("Generate Report Card");
        calculateButton.setBackground(Color.GREEN);
        calculateButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        calculateButton.setBounds(50, 350, 350, 30 );
        calculateButton.setFocusable(false);
        calculateButton.addActionListener(this::generateReportCard);
        this.add(calculateButton);

        this.setVisible(true);
    }

    private void generateReportCard(ActionEvent e) {
        int total = 0;
        try {
            int mathsMarks = Integer.parseInt(inputMaths.getText());
            int scienceMarks = Integer.parseInt(inputScience.getText());
            int historyMarks = Integer.parseInt(inputHistory.getText());
            int englishMarks = Integer.parseInt(inputEnglish.getText());
            int computerMarks = Integer.parseInt(inputComputer.getText());
            total = mathsMarks + scienceMarks + historyMarks + englishMarks + computerMarks;

            if (mathsMarks < 0 || mathsMarks > 100 || scienceMarks < 0 || scienceMarks > 100 || 
                historyMarks < 0 || historyMarks > 100 || englishMarks < 0 || englishMarks > 100 || 
                computerMarks < 0 || computerMarks > 100) {
                JOptionPane.showMessageDialog(this, "Please enter marks between 0 and 100 for all subjects.", "Invalid Marks", JOptionPane.WARNING_MESSAGE);
                return;
            }        

            double percentage = (double) total / 5;
            String grade;
            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else grade = "F";

            JFrame newFrame = new JFrame();
            newFrame.setSize(500, 600);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setLocationRelativeTo(null); 
            newFrame.setResizable(false);
            newFrame.getContentPane().setBackground(Color.yellow);
            newFrame.setLayout(null);
            newFrame.setTitle("Report Card");

            JPanel contentPane = new JPanel();
            contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10)); 
            contentPane.setLayout(null); 
            contentPane.setBackground(Color.yellow);
            newFrame.setContentPane(contentPane); 

            JLabel heading = new JLabel();
            heading.setText("Report Card :)");
            heading.setForeground(Color.black);
            heading.setBounds(30, 20, 400, 100);
            heading.setFont(new Font("MV Boli", Font.BOLD, 30));
            newFrame.add(heading);

            image = new ImageIcon("src/logo.png");
            Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            heading.setIcon(new ImageIcon(scaledImage));

            JLabel name = new JLabel();
            name.setText("Student Name: " + inputName.getText());
            name.setForeground(Color.black);
            name.setBounds(20, 130, 400, 20); 
            name.setFont(new Font("Times New Roman", Font.BOLD, 20));
            newFrame.add(name);

            JLabel date = new JLabel();
            LocalDate myObj = LocalDate.now(); 
            date.setText("Date: " + myObj);
            date.setForeground(Color.black);
            date.setBounds(320, 130, 400, 20); 
            date.setFont(new Font("Times New Roman", Font.BOLD, 20));
            newFrame.add(date);

            JSeparator separator = new JSeparator();
            separator.setBounds(20, 150, 450, 2); 
            newFrame.add(separator);

            JLabel math = new JLabel(); 
            math.setText("Math");
            math.setForeground(Color.black);
            math.setBounds(50, 170, 200, 30);
            math.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(math);

            JSeparator separator2 = new JSeparator();
            separator2.setOrientation(SwingConstants.VERTICAL);
            separator2.setBounds(300, 160, 4, 210); 
            newFrame.add(separator2);


            JLabel mMark = new JLabel(); 
            mMark.setText(String.valueOf(mathsMarks));
            mMark.setForeground(Color.black);
            mMark.setBounds(350, 170, 200, 30);
            mMark.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(mMark);

            JLabel science = new JLabel();
            science.setText("Science");
            science.setForeground(Color.black);
            science.setBounds(50, 210, 200, 30); 
            science.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(science);

            JLabel sMark = new JLabel(); 
            sMark.setText(String.valueOf(scienceMarks));
            sMark.setForeground(Color.black);
            sMark.setBounds(350, 210, 200, 30);
            sMark.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(sMark);

            JLabel history = new JLabel();
            history.setText("History");
            history.setForeground(Color.black);
            history.setBounds(50, 250, 200, 30); 
            history.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(history);

            JLabel hMarks = new JLabel(); 
            hMarks.setText(String.valueOf(historyMarks));
            hMarks.setForeground(Color.black);
            hMarks.setBounds(350, 250, 200, 30);
            hMarks.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(hMarks);

            JLabel english = new JLabel();
            english.setText("English");
            english.setForeground(Color.black);
            english.setBounds(50, 290, 200, 30); 
            english.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(english);

            JLabel eMarks = new JLabel(); 
            eMarks.setText(String.valueOf(englishMarks));
            eMarks.setForeground(Color.black);
            eMarks.setBounds(350, 290, 200, 30);
            eMarks.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(eMarks);

            JLabel computer = new JLabel();
            computer.setText("Computer");
            computer.setForeground(Color.black);
            computer.setBounds(50, 340, 200, 30); 
            computer.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(computer);

            JLabel cMarks = new JLabel(); 
            cMarks.setText(String.valueOf(computerMarks));
            cMarks.setForeground(Color.black);
            cMarks.setBounds(350, 340, 200, 30);
            cMarks.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(cMarks);

            JSeparator separator3 = new JSeparator();
            separator3.setBounds(20, 380, 420, 2); 
            newFrame.add(separator3);

            JSeparator separator4 = new JSeparator();
            separator4.setOrientation(SwingConstants.VERTICAL);
            separator4.setBounds(300, 390, 4, 140); 
            newFrame.add(separator4);

            JLabel totalMarksLabel = new JLabel();
            totalMarksLabel.setText("Total Marks");
            totalMarksLabel.setForeground(Color.black);
            totalMarksLabel.setBounds(50, 390, 200, 30);
            totalMarksLabel.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(totalMarksLabel);

            JLabel totalMarksValue = new JLabel();
            totalMarksValue.setText(String.valueOf(total));
            totalMarksValue.setForeground(Color.black);
            totalMarksValue.setBounds(350, 390, 200, 30);
            totalMarksValue.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(totalMarksValue);

            JLabel percentageLabel = new JLabel();
            percentageLabel.setText("Percentage");
            percentageLabel.setForeground(Color.black);
            percentageLabel.setBounds(50, 440, 200, 30);
            percentageLabel.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(percentageLabel);

            JLabel percentageValue = new JLabel();
            percentageValue.setText(String.format("%.2f", percentage) + "%");
            percentageValue.setForeground(Color.black);
            percentageValue.setBounds(350, 440, 200, 30);
            percentageValue.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(percentageValue);

            JLabel gradeLabel = new JLabel();
            gradeLabel.setText("Grade");
            gradeLabel.setForeground(Color.black);
            gradeLabel.setBounds(50, 490, 200, 30);
            gradeLabel.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(gradeLabel);

            JLabel gradeValue = new JLabel();
            gradeValue.setText(grade);
            gradeValue.setForeground(Color.black);
            gradeValue.setBounds(350, 490, 200, 30);
            gradeValue.setFont(new Font("Arial", Font.BOLD, 30));
            newFrame.add(gradeValue);


            newFrame.setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

}
