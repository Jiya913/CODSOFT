import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class QuizGame implements ActionListener {

    String[] questions = {
        "Which company developed Java?",
        "Which year was Java developed?",
        "What is the size of an int variable in Java?",
        "Which of the following is not a Java keyword?",
        "Which of the following is a valid declaration of a char?",
        "Which of the following is not a valid variable name in Java?",
        "Which method is the starting point for all Java applications?",
        "What is the default value of a boolean variable in Java?",
        "What will the expression 5 + 2 + \"7\" evaluate to in Java?",
        "Which of the following is not a valid way to declare an array in Java?",
        "Which collection class allows you to store unique elements only?",
        "Which of the following is not a Java IDE?",
        "Which of the following is not a Java framework?",
        "What was Java originally called?",
        "Who is the father of Java?"
    };

    String[][] options = {
        {"Oracle", "Microsoft", "Sun Microsystems", "IBM"},
        {"1995", "1996", "1991", "1998"},
        {"16 bits", "32 bits", "64 bits", "128 bits"},
        {"class", "interface", "extends", "sizeof"},
        {"char c = 'a';", "char c = \"a\";", "char c = 'ab';", "char c = \"ab\";"},
        {"1st_name", "_name", "$name", "name"},
        {"main()", "start()", "Main()", "init()"},
        {"true", "false", "null", "undefined"},
        {"527", "77", "14", "\"77\""},
        {"int[] arr;", "int arr[];", "int arr[5];", "int[] arr = new int[5];"},
        {"HashSet", "ArrayList", "LinkedList", "TreeSet"},
        {"Eclipse", "NetBeans", "IntelliJ IDEA", ".NET"},
        {"Spring", "Hibernate", ".NET Framework", "Struts"},
        {"Oak", "Maple", "Pine", "Cedar"},
        {"James Gosling", "Bjarne Stroustrup", "Guido van Rossum", "Dennis Ritchie"}
    };

    char[] answers = {'C', 'A', 'B', 'D', 'A', 'A', 'A', 'B', 'D', 'C', 'A', 'D', 'C', 'A', 'A'};

    String[] reason = {
        "Java was originally developed by Sun Microsystems in 1995. Oracle only acquired Sun in 2010. Microsoft, IBM, Oracle weren't the creators",
        "Java was officially launched by Sun Microsystems in 1995. Development started around 1991 but 1995 is the public release.",
        "In Java, int is always 32 bits (4 bytes), regardless of platform. short is 16 bits, long is 64 bits.",
        "Java doesn’t have sizeof (it’s from C/C++). The rest — class, interface, extends — are core Java keywords.",
        "Single quotes ('a') are used for char. Double quotes (\"a\") create a String, so the other options are invalid.",
        "Variable names can’t start with numbers. Can only start with UnderScore, Dollar or alphabet.",
        "Execution starts at public static void main(String[] args). start(), init() are used in applets or JavaFX. Main() with a capital M doesn't match Java's case-sensitive rules.",
        "In Java, uninitialized instance variables of type boolean default to false.",
        " Java evaluates left to right. 5 + 2 = 7, then 7 + \"7\" → string concatenation happens, so result is \"77\"",
        "In Java you cannot specify size during declaration like that. You either write: int[] arr = new int[5]; but int arr[5]; is C/C++ syntax",
        "HashSet, TreeSet store unique elements only. ArrayList and LinkedList allow duplicates.",
        ".NET is not an IDE — it’s a Microsoft development framework.",
        ".NET Framework is for C#/VB.NET, not Java.",
        "The developer first called it \"Oak\" after the tree outside his office, but later renamed it \"Java\" because \"Oak\" was already trademarked.",
        "Known as the \"father of Java\" — he led the development at Sun Microsystems. The others are creators of C++, Python, and C."
    }; 

    int answer;
    int index;
    int score = 0;  
    int totalQuestions = questions.length;
    int seconds = 10;
    int result;

    JFrame frame = new JFrame("Quiz Game"); 

    JTextField textField = new JTextField();
    JTextField percentage = new JTextField();
    JTextField numberRight = new JTextField();

    JTextArea textArea = new JTextArea();
    JTextArea explainArea = new JTextArea("Explanation");


    JPanel panel = new JPanel();

    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();

    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");

    ImageIcon icon;

    Image bg;

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));

            if ( seconds <= 0 ) {
                displayAnswer();
            }
            
        }
    });

    public QuizGame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textField.setBounds(2, 0, 780, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(255, 255, 255));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Quiz Game");

        textArea.setBounds(2, 50, 780, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setFont(new Font("Arial", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createEmptyBorder());
        textArea.setEditable(false);

        buttonA.setBounds(50, 150, 100, 50);
        buttonA.setFont(new Font("Times new roman", Font.BOLD, 20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setBackground(Color.decode("#007BFF"));
        buttonA.setForeground(Color.WHITE);

        buttonB.setBounds(50, 210, 100, 50);
        buttonB.setFont(new Font("Times new roman", Font.BOLD, 20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setBackground(Color.decode("#007BFF"));
        buttonB.setForeground(Color.WHITE);

        buttonC.setBounds(50, 270, 100, 50);
        buttonC.setFont(new Font("Times new roman", Font.BOLD, 20));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setBackground(Color.decode("#007BFF"));
        buttonC.setForeground(Color.WHITE);

        buttonD.setBounds(50, 330, 100, 50);
        buttonD.setFont(new Font("Times new roman", Font.BOLD, 20));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setBackground(Color.decode("#007BFF"));
        buttonD.setForeground(Color.WHITE);

        explainArea.setBounds(2, 400, 480, 150);
        explainArea.setLineWrap(true);
        explainArea.setWrapStyleWord(true);
        explainArea.setOpaque(false);
        explainArea.setForeground(Color.YELLOW);
        explainArea.setFont(new Font("Arial", Font.BOLD, 25));
        explainArea.setBorder(BorderFactory.createEmptyBorder());
        explainArea.setEditable(false);
        explainArea.setVisible(false);

        answerLabelA.setBounds(200, 150, 500, 50);
        answerLabelA.setBackground(new Color(25, 25, 25));
        answerLabelA.setForeground(new Color(255, 255, 255));
        answerLabelA.setFont(new Font("Arial", Font.BOLD, 25));

        answerLabelB.setBounds(200, 210, 500, 50);
        answerLabelB.setBackground(new Color(25, 25, 25));
        answerLabelB.setForeground(new Color(255, 255, 255));
        answerLabelB.setFont(new Font("Arial", Font.BOLD, 25));

        answerLabelC.setBounds(200, 270, 500, 50);
        answerLabelC.setBackground(new Color(25, 25, 25));
        answerLabelC.setForeground(new Color(255, 255, 255));
        answerLabelC.setFont(new Font("Arial", Font.BOLD, 25));

        answerLabelD.setBounds(200, 330, 500, 50);
        answerLabelD.setBackground(new Color(25, 25, 25));
        answerLabelD.setForeground(new Color(255, 255, 255));
        answerLabelD.setFont(new Font("Arial", Font.BOLD, 25));

        secondsLeft.setBounds(650, 500, 100, 50);
        secondsLeft.setBackground(new Color(25, 25, 25));
        secondsLeft.setForeground(Color.decode("#FF9800"));
        secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 45));
        secondsLeft.setBorder(BorderFactory.createEmptyBorder());
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(650, 450, 100, 50);
        timeLabel.setBackground(new Color(25, 25, 25));
        timeLabel.setForeground(Color.red);
        timeLabel.setFont(new Font("MV boli", Font.BOLD, 16));
        timeLabel.setBorder(BorderFactory.createEmptyBorder());
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Time left");

        numberRight.setBounds(400, 250, 200, 50);
        numberRight.setBackground(new Color(25, 25, 25));
        numberRight.setForeground(new Color(255, 255, 255));
        numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setOpaque(true);

        percentage.setBounds(400, 330, 200, 50);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setEditable(false);
        percentage.setOpaque(true);

        icon = new ImageIcon("src/logo.png");
        bg = new ImageIcon("src/blur2.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(bg);
        backgroundPanel.setLayout(null);  
        frame.setContentPane(backgroundPanel);

        frame.setIconImage(icon.getImage());
        frame.add(textField);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(explainArea);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(secondsLeft);
        frame.add(timeLabel);
        frame.add(textArea);


        frame.setVisible(true);

        nextQuestion();

    }

    public void nextQuestion() {

        explainArea.setVisible(false);

        if (index >= totalQuestions) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }

        explainArea.setText(" ");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if ( e.getSource() == buttonA ) {
            answer = 'A';
            if( answer == answers[index]) {
                answerLabelA.setForeground(Color.decode("#00C853"));
                score++;
            }
        }

        if ( e.getSource() == buttonB ) {
            answer = 'B';
            if( answer == answers[index]) {
                answerLabelB.setForeground(Color.decode("#00C853"));
                score++;
            }
        }

        if ( e.getSource() == buttonC ) {
            answer = 'C';
            if( answer == answers[index]) {
                answerLabelC.setForeground(Color.decode("#00C853"));
                score++;
            }
        }

        if ( e.getSource() == buttonD ) {
            answer = 'D';
            if( answer == answers[index]) {
                answerLabelD.setForeground(Color.decode("#00C853"));
                score++;
            }
        }
        displayAnswer();

    }

    public void displayAnswer() {

        explainArea.setText(reason[index]);
        explainArea.setVisible(true);
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if ( answers[index] != 'A' ) {
            answerLabelA.setForeground(new Color(255, 0, 0));
        }
        if ( answers[index] != 'B' ) {
            answerLabelB.setForeground(new Color(255, 0, 0));
        }
        if ( answers[index] != 'C' ) {
            answerLabelC.setForeground(new Color(255, 0, 0));
        }
        if ( answers[index] != 'D' ) {
            answerLabelD.setForeground(new Color(255, 0, 0));
        }

        if ( answers[index] == 'A' ) {
            answerLabelA.setForeground(Color.decode("#00C853"));
        }
        if ( answers[index] == 'B' ) {
            answerLabelB.setForeground(Color.decode("#00C853"));
        }
        if ( answers[index] == 'C' ) {
            answerLabelC.setForeground(Color.decode("#00C853"));
        }
        if ( answers[index] == 'D' ) {
            answerLabelD.setForeground(Color.decode("#00C853"));
        }

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                answerLabelA.setForeground(new Color(255, 255, 255));
                answerLabelB.setForeground(new Color(255, 255, 255));
                answerLabelC.setForeground(new Color(255, 255, 255));
                answerLabelD.setForeground(new Color(255, 255, 255));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();

    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        double percentageValue = ((double)score / totalQuestions) * 100;
        result = (int) percentageValue;

        System.out.println(result);

        textField.setText("RESULTS!! :D");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");
        explainArea.setText("");

        numberRight.setText( "(" + score + "/" + totalQuestions + ")");
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(numberRight);

    }

}
