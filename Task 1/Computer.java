import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Computer extends JFrame {

    private GuessPanel panel;
    private int lowerBound;
    private int upperBound;
    private int computerGuess = 100;
    private boolean guessedCorrectly;
    private int attemptsLeft;

    public Computer() {
        this.setTitle("Computer Guessing Game");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        panel = new GuessPanel();
        this.add(panel);

        startNewSession();
        this.setVisible(true);
    }

    private void startNewSession() {
        lowerBound = 1;
        upperBound = 100;
        guessedCorrectly = false;
        attemptsLeft = 7;
        panel.updateMessage("Think of a number from 1 to 100 and press 'Next Guess'!");
    }

    private class GuessPanel extends JPanel {

        private JButton higherButton, lowerButton, correctButton, nextGuessButton, restartButton, exitButton, BackButton;
        private JLabel messageLabel;
        private ImageIcon icon;
        private Image bg;

        public GuessPanel() {
            this.setLayout(null);

            messageLabel = new JLabel("", SwingConstants.CENTER);
            messageLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
            messageLabel.setBounds(50, 230, 600, 30);
            add(messageLabel);

            nextGuessButton = createStyledButton("Next Guess", Color.BLUE, Color.WHITE);
            nextGuessButton.setBounds(250, 280, 200, 30);
            nextGuessButton.addActionListener(e -> makeNextGuess());
            add(nextGuessButton);

            higherButton = createStyledButton("Higher", new Color(34, 139, 34), Color.WHITE);
            higherButton.setBounds(150, 340, 120, 30);
            higherButton.addActionListener(e -> feedback("H"));
            add(higherButton);

            lowerButton = createStyledButton("Lower", Color.ORANGE, Color.BLACK);
            lowerButton.setBounds(280, 340, 120, 30);
            lowerButton.addActionListener(e -> feedback("L"));
            add(lowerButton);

            correctButton = createStyledButton("Correct!", Color.RED, Color.WHITE);
            correctButton.setBounds(410, 340, 120, 30);
            correctButton.addActionListener(e -> feedback("C"));
            add(correctButton);

            restartButton = createStyledButton("Restart", Color.MAGENTA, Color.WHITE);
            restartButton.setBounds(200, 400, 120, 30);
            restartButton.addActionListener(e -> {
                startNewSession();
                repaint();
            });
            add(restartButton);

            exitButton = createStyledButton("Exit", Color.RED.darker(), Color.WHITE);
            exitButton.setBounds(380, 400, 120, 30);
            exitButton.addActionListener(e -> System.exit(0));
            add(exitButton);

            BackButton = new JButton("Back To Menu");
            BackButton.setBounds(280, 450, 150, 30);
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

            icon = new ImageIcon("icon.png");
            bg = new ImageIcon("src/bg.png").getImage();
        }

        private JButton createStyledButton(String text, Color bg, Color fg) {
            JButton button = new JButton(text);
            button.setBackground(bg);
            button.setForeground(fg);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setFocusPainted(false);
            button.setBorder(new LineBorder(Color.BLACK, 2));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(bg.darker());
                }

                public void mouseExited(MouseEvent e) {
                    button.setBackground(bg);
                }
            });
            return button;
        }

        public void updateMessage(String msg) {
            messageLabel.setText(msg);
        }

        private void makeNextGuess() {
            if (guessedCorrectly) return;
            
            if (attemptsLeft == 0) {
                panel.updateMessage("Oops! I couldn't guess it :(");
                return;
            }
            
            if (lowerBound > upperBound) {
                panel.updateMessage("Hmm... Are you sure you didn't mislead me? :o");
                return;
            }
            
            // computerGuess = (lowerBound + upperBound) / 2;
            computerGuess = lowerBound + new Random().nextInt(upperBound - lowerBound + 1);
            attemptsLeft--;
            panel.updateMessage("Is it " + computerGuess + "? Attempts left: " + attemptsLeft);

        }

        private void feedback(String response) {
            if (guessedCorrectly) return;

            switch (response) {
                case "H":
                    lowerBound = computerGuess + 1;
                    break;
                case "L":
                    upperBound = computerGuess - 1;
                    break;
                    case "C":
                    guessedCorrectly = true;
                    updateMessage("Yay! I guessed it: " + computerGuess + " :D");
                    return;
                
            }

            makeNextGuess();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bg, 0, 0, null);
            g.drawImage(icon.getImage(), 280, 30, 150, 150, this);
        }
    }
}
