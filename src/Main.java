import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        float goal = 1000;
        Calculator myCalc = new Calculator(goal);

        JFrame frame = new JFrame("Savings Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 150);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1)); // Two rows, one for total and one for buttons

        // Create a label for displaying totals
        JLabel totalLabel = new JLabel("Goal: $" + String.format("%.2f", myCalc.getGoal()) + " | Total savings: $" + String.format("%.2f", myCalc.getTotal()) + " | " + myCalc.distanceFromGoal());
        totalLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Increase the font size
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text

        panel.add(totalLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Buttons in a row

        JTextField inputField = new JTextField(10);
        JButton addAllowanceButton = new JButton("Add Allowance");
        JButton addExpenseButton = new JButton("Add Expense");

        buttonPanel.add(addAllowanceButton);
        buttonPanel.add(addExpenseButton);
        buttonPanel.add(inputField);

        panel.add(buttonPanel);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(resultArea, BorderLayout.CENTER);

        addAllowanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    float allowance = Float.parseFloat(inputField.getText());
                    myCalc.addAllowance(allowance);
                    inputField.setText("");
                    updateTotalLabel(totalLabel, myCalc);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        addExpenseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    float expense = Float.parseFloat(inputField.getText());
                    myCalc.addExpense(expense);
                    inputField.setText("");
                    updateTotalLabel(totalLabel, myCalc);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static void updateTotalLabel(JLabel label, Calculator myCalc) {
        label.setText("Goal: $" + String.format("%.2f", myCalc.getGoal()) + " | Total savings: $" + String.format("%.2f", myCalc.getTotal()) + " | " + myCalc.distanceFromGoal());
    }
}
