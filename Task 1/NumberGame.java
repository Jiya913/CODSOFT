import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGame extends JFrame {

    private GamePanel panel;
    private int targetNumber;
    private int attemptsLeft;
    private boolean gameWon;

    public NumberGame() {
        this.setTitle("Number Guessing Game");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);

        panel = new GamePanel();
        this.add(panel);

        this.startNewGame();

        this.setVisible(true);
    }

    private void startNewGame() {
        targetNumber = new Random().nextInt(100) + 1;  
        attemptsLeft = 7; 
        gameWon = false;
        panel.reset();
    }

    private class GamePanel extends JPanel implements ActionListener {

        private JTextField inputField;
        private JButton guessButton, restartButton, exitButton, BackButton;
        private String message = "Guess a number between 1 and 100!";
        private ImageIcon icon;

        Image bg; 
        
        public GamePanel() {
            this.setLayout(null); 
            
            inputField = new JTextField();
            inputField.setBounds(250, 260, 200, 50);
            add(inputField);
            
            guessButton = new JButton("Guess");
            guessButton.setBounds(500, 280, 80, 30);
            guessButton.setBackground(Color.BLUE);
            guessButton.setForeground(Color.WHITE);
            guessButton.setFont(new Font("Arial", Font.BOLD, 14));
            guessButton.setFocusPainted(false);
            guessButton.setBorder(new LineBorder(Color.BLACK, 2));
            guessButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            guessButton.addActionListener(this);
            add(guessButton);
            
            restartButton = new JButton("Restart");
            restartButton.setBounds(200, 340, 100, 30);
            restartButton.setBackground(Color.ORANGE);
            restartButton.setForeground(Color.BLACK);
            restartButton.setFont(new Font("Arial", Font.BOLD, 14));
            restartButton.setFocusPainted(false);
            restartButton.setBorder(new LineBorder(Color.RED, 2));
            restartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            restartButton.addActionListener(e -> {
                startNewGame();
                repaint();
            });
            add(restartButton);

            exitButton = new JButton("Exit");
            exitButton.setBounds(400, 340, 80, 30);
            exitButton.setBackground(Color.RED);
            exitButton.setForeground(Color.WHITE);
            exitButton.setFont(new Font("Arial", Font.BOLD, 14));
            exitButton.setFocusPainted(false);
            exitButton.setBorder(new LineBorder(Color.BLACK, 2));
            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            exitButton.addActionListener(e -> System.exit(0));
            add(exitButton);

            BackButton = new JButton("Back To Menu");
            BackButton.setBounds(300, 450, 150, 30);
            BackButton.setBackground(Color.YELLOW);
            BackButton.setForeground(Color.BLACK);
            BackButton.setFont(new Font("Arial", Font.BOLD, 14));
            BackButton.setFocusPainted(false);
            BackButton.setBorder(new LineBorder(Color.BLACK, 2));
            BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            BackButton.addActionListener(e -> {
                dispose();
            });
            add(BackButton);
            
            icon = new ImageIcon("src/icon.png");

            bg = new ImageIcon("src/bg.png").getImage();
        }

        public void reset() {
            message = "Guess a number between 1 and 100!";
            inputField.setText("");
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(bg, 0, 0, null); 

            g.drawImage(icon.getImage(), 280, 30, 150, 150, this);

            g.setColor(Color.BLACK);
            g.setFont(new Font("MV Boli", Font.BOLD, 30));
            g.drawString(message, 70, 230);

            // Draw Attempts Left
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Attempts Left: " + attemptsLeft, 300, 430);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(inputField.getText());

                if (guess == targetNumber) {
                    message = "Correct! You guessed it!";
                    gameWon = true;
                } else if (guess > targetNumber) {
                    attemptsLeft--;
                    message = "Too High! Try Again.";
                } else {
                    attemptsLeft--;
                    message = "Too Low! Try Again.";
                }

                if (attemptsLeft == 0 && !gameWon) {
                    message = "Game Over! Number was: " + targetNumber;
                }

                repaint();

            } catch (NumberFormatException ex) {
                message = "Please enter a valid number!";
                repaint();
            }
        }
    }

}
