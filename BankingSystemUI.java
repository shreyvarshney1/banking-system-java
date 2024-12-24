import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance > 0 ? initialBalance : 0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Get account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankingSystemUI {
    private BankAccount account;

    public BankingSystemUI() {
        // Create UI components
        JFrame frame = new JFrame("Banking System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Account Holder Name:");
        JTextField nameField = new JTextField(20);

        JLabel initialDepositLabel = new JLabel("Initial Deposit:");
        JTextField initialDepositField = new JTextField(10);

        JButton createAccountButton = new JButton("Create Account");

        JLabel balanceLabel = new JLabel("Balance: $0.00");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton checkBalanceButton = new JButton("Check Balance");

        JTextField amountField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(initialDepositLabel);
        panel.add(initialDepositField);
        panel.add(createAccountButton);
        panel.add(new JLabel()); // Placeholder for layout
        panel.add(new JLabel("Transaction Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);
        panel.add(checkBalanceButton);

        // Disable buttons initially
        depositButton.setEnabled(false);
        withdrawButton.setEnabled(false);
        checkBalanceButton.setEnabled(false);

        // Add functionality to buttons
        createAccountButton.addActionListener(e -> {
            String name = nameField.getText();
            double initialDeposit;
            try {
                initialDeposit = Double.parseDouble(initialDepositField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Account holder name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            account = new BankAccount(name, initialDeposit);
            balanceLabel.setText("Balance: $" + account.getBalance());
            JOptionPane.showMessageDialog(frame, "Account created successfully for " + name, "Success", JOptionPane.INFORMATION_MESSAGE);

            // Enable transaction buttons
            depositButton.setEnabled(true);
            withdrawButton.setEnabled(true);
            checkBalanceButton.setEnabled(true);
        });

        depositButton.addActionListener(e -> {
            double amount;
            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            account.deposit(amount);
            balanceLabel.setText("Balance: $" + account.getBalance());
            JOptionPane.showMessageDialog(frame, "Deposited: $" + amount, "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        withdrawButton.addActionListener(e -> {
            double amount;
            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid withdrawal amount", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (account.withdraw(amount)) {
                balanceLabel.setText("Balance: $" + account.getBalance());
                JOptionPane.showMessageDialog(frame, "Withdrawn: $" + amount, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient balance or invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        checkBalanceButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Account Holder: " + account.getAccountHolderName() + "\nCurrent Balance: $" + account.getBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankingSystemUI::new);
    }
}
