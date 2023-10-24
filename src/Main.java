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
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton addAllowanceButton = new JButton("Add Allowance");
        JButton addExpenseButton = new JButton("Add Expense");
        JButton viewTotalsButton = new JButton("View Totals");


        panel.add(addAllowanceButton);
        panel.add(addExpenseButton);
        panel.add(viewTotalsButton);
        panel.add(inputField);

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
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        viewTotalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String totals = "Goal: $" + myCalc.getGoal() + "\nTotal savings: $" + myCalc.getTotal() + "\n" + myCalc.distanceFromGoal();
                resultArea.setText(totals);
            }
        });

        frame.setVisible(true);
    }
}
