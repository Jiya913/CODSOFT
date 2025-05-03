import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM extends JFrame implements ActionListener {

    private BankAccount account;
    private JLabel displayLabel, cardLabel, holderLabel;
    private JTextField inputField;
    private JButton checkBalanceButton, depositButton, withdrawButton, exitButton;
    private JPanel panel;

    public ATM() {
        account = new BankAccount(1000); 
        this.setTitle("ATM Machine Interface");
        this.setSize(400, 600);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        displayLabel = new JLabel("Welcome! Enter amount or choose an action.");
        displayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setOpaque(true);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setBounds(15, 15, 350, 200);
        displayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 8));

        cardLabel = new JLabel("Enter your card here: ");
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cardLabel.setBounds(230, 250, 150, 30);
        cardLabel.setForeground(Color.BLACK);

        holderLabel = new JLabel();
        holderLabel.setBounds(300, 280, 10, 50);
        holderLabel.setOpaque(true);
        holderLabel.setBackground(Color.BLACK);

        inputField = new JTextField(20);
        inputField.setBounds(15, 250, 200, 30);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBackground(Color.LIGHT_GRAY);
        inputField.setForeground(Color.BLACK);
        inputField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        inputField.setToolTipText("Enter amount here");
        inputField.setCaretColor(Color.BLACK);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(230, 350, 150, 30);
        checkBalanceButton.setFocusable(false);
        checkBalanceButton.setBackground(Color.ORANGE);
        checkBalanceButton.setForeground(Color.BLACK);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(230, 400, 150, 30);
        depositButton.setFocusable(false);
        depositButton.setBackground(Color.GREEN);
        depositButton.setForeground(Color.BLACK);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(230, 450, 150, 30);
        withdrawButton.setFocusable(false);
        withdrawButton.setBackground(Color.RED);
        withdrawButton.setForeground(Color.BLACK);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        exitButton.setBounds(230, 500, 150, 30);
        exitButton.setFocusable(false);
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.WHITE);

        panel = new JPanel(); 
        panel.setBounds(15, 300, 200, 200);
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton buttonClear = new JButton("C");
        JButton buttonEnter = new JButton("Enter");

        ActionListener numberButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String currentText = inputField.getText();
            inputField.setText(currentText + e.getActionCommand());
            }
        };

        button1.addActionListener(numberButtonListener);
        button2.addActionListener(numberButtonListener);
        button3.addActionListener(numberButtonListener);
        button4.addActionListener(numberButtonListener);
        button5.addActionListener(numberButtonListener);
        button6.addActionListener(numberButtonListener);
        button7.addActionListener(numberButtonListener);
        button8.addActionListener(numberButtonListener);
        button9.addActionListener(numberButtonListener);
        button0.addActionListener(numberButtonListener);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if (!text.isEmpty()) {
                    inputField.setText(text);
                }
            }
        });

        Dimension buttonSize = new Dimension(60, 40);

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button4.setFocusable(false);
        button5.setFocusable(false);
        button6.setFocusable(false);
        button7.setFocusable(false);
        button8.setFocusable(false);
        button9.setFocusable(false);
        button0.setFocusable(false);
        buttonClear.setFocusable(false);
        buttonEnter.setFocusable(false);

        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
        button5.setPreferredSize(buttonSize);
        button6.setPreferredSize(buttonSize);
        button7.setPreferredSize(buttonSize);
        button8.setPreferredSize(buttonSize);
        button9.setPreferredSize(buttonSize);
        button0.setPreferredSize(buttonSize);
        buttonClear.setPreferredSize(buttonSize);
        buttonEnter.setPreferredSize(buttonSize);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button0);
        panel.add(buttonClear);
        panel.add(buttonEnter);

        this.add(panel);

        this.add(exitButton);
        this.add(cardLabel);
        this.add(displayLabel);
        this.add(inputField);
        this.add(holderLabel);
        this.add(checkBalanceButton);
        this.add(depositButton);
        this.add(withdrawButton);

        checkBalanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        String pinInput = JOptionPane.showInputDialog(this, "Enter your PIN: (eg: 1234)");

        if (pinInput == null || !pinInput.equals("1234")) { 
            displayLabel.setText("Incorrect PIN! Transaction cancelled.");
            return;
        }

        String text = inputField.getText();
        int amount = 0;

        try {
            if (!text.isEmpty()) amount = Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            displayLabel.setText("Invalid input! Enter a number.");
            return;
        }

        switch (command) {
            case "Check Balance":
                displayLabel.setText("Your Balance: ₹" + account.getBalance());
                break;

            case "Deposit":
                account.deposit(amount);
                displayLabel.setText("₹" + amount + " Deposited Successfully!");
                break;

            case "Withdraw":
                if (account.withdraw(amount)) {
                    displayLabel.setText("₹" + amount + " Withdrawn Successfully!");
                } else {
                    displayLabel.setText("Insufficient Balance or Invalid Amount.");
                }
                break;
        }

        inputField.setText(""); 
    }

    public static void main(String[] args) {
        new ATM();
    }
}
