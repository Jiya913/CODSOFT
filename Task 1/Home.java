
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Home extends JFrame implements ActionListener {

    ImageIcon icon;
    MyPanel panel;
    JButton startButton, exitButton, LetCompterPlayButton;

    Home() {
        this.setTitle("Number Guessing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        icon = new ImageIcon("src/main_icon.jpg");
        panel = new MyPanel();
        panel.setBounds(0, 0, 700, 600);
        this.add(panel);

        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");
        LetCompterPlayButton = new JButton("Let Computer Guess");

        styleButton(startButton, Color.MAGENTA, Color.WHITE);
        styleButton(exitButton, Color.RED, Color.WHITE);
        styleButton(LetCompterPlayButton, new Color(34, 139, 34), Color.WHITE);  // Forest green

        startButton.setBounds(80, 300, 250, 50);
        LetCompterPlayButton.setBounds(350, 300, 250, 50);
        exitButton.setBounds(215, 420, 250, 50);

        startButton.addActionListener(this);
        exitButton.addActionListener(this);
        LetCompterPlayButton.addActionListener(this);

        panel.setLayout(null);
        panel.add(startButton);
        panel.add(LetCompterPlayButton);
        panel.add(exitButton);

        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }

    private void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFont(new Font("MV Boli", Font.BOLD, 24));
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.BLACK, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            System.out.println("Game Started!");
            GameStart();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == LetCompterPlayButton) {
            WithComputer();
        }
    }

    private void WithComputer() {
        new Computer();
    }

    private void GameStart() {
        NumberGame user = new NumberGame();
        this.add(user);
    }
}
