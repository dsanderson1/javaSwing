package com.javaswing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class guiTestPage {
    private JPanel nameChecker;
    private JTextField txtNumberOne;
    private JTextField txtNumberTwo;
    private JButton btnProcess;
    private JLabel lblEquals;
    private JButton button1;
    String equals;
    int numberOne;
    int numberTwo;
    String query;

    public guiTestPage() {
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberOne = Integer.parseInt(txtNumberOne.getText());
                numberTwo = Integer.parseInt(txtNumberTwo.getText());
                equals = Integer.toString(numberOne + numberTwo);

                query = "INSERT INTO addition (firstNumber, secondNumber, equals) VALUES (" + numberOne + "," + numberTwo + "," + equals+")";
                lblEquals.setText(query);

                databaseConnection db;
                db = new databaseConnection(query);

                try {
                    db.runQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Name Checker");
        frame.setContentPane(new guiTestPage().nameChecker);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
