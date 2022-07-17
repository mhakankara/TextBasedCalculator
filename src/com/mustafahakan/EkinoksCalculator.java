package com.mustafahakan;

import com.mustafahakan.Operations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mustafa Hakan Kara on 17/07/2022
 */
public class EkinoksCalculator extends JFrame {

    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 100;
    private static final String PROJECT_NAME = "Ekinoks Calculator";

    // Properties
    private JPanel mainPanel;
    private final Operation[] operations = {new Addition(), new Subtraction(),
            new Multiplication(), new Division()};

    // Constructor
    public EkinoksCalculator() {
        setTitle(PROJECT_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        pack();
        setVisible(true);
    }

    // Methods
    public void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        // Create sub panels
        JPanel tfPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        String operand1LabelString = "First Number";
        String operand2LabelString = "Second Number";
        final JTextField operand1TF = new JTextField(10);
        final JTextField operand2TF = new JTextField(10);
        JLabel operand1Label = new JLabel(operand1LabelString + ": ");
        JLabel operand2Label = new JLabel(operand2LabelString + ": ");
        final JLabel resultLabel = new JLabel();

        tfPanel.add(operand1Label);
        tfPanel.add(operand1TF);
        tfPanel.add(operand2Label);
        tfPanel.add(operand2TF);

        for (final Operation operation : operations) {
            JButton operationButton = new JButton(operation.getName());
            operationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String operand1 = operand1TF.getText();
                    String operand2 = operand2TF.getText();
                    String result = operation.operate(new String[]{operand1, operand2});
                    String resultString = "Result: " + result;
                    System.out.println(resultString);
                    resultLabel.setText(resultString);

                }
            });
            buttonPanel.add(operationButton);
        }


        mainPanel.add(tfPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultLabel);

        add(mainPanel);
    }

}
