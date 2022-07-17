package com.mustafahakan;

import com.mustafahakan.Operations.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mustafa Hakan Kara on 17/07/2022
 */
public class TextBasedCalculator extends JFrame {

    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 100;
    private static final int TEXT_FIELD_SIZE = 16;
    private static final String PROJECT_NAME = "Text-Based Calculator";

    // Properties
    private JPanel mainPanel;

    private Map<String, String> turkishVocabulary;


    // Constructor
    public TextBasedCalculator() {
        initVocabularies();
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

        String operand1LabelString = translate("First Number");
        String operand2LabelString = translate("Second Number");
        final JTextField operand1TF = new JTextField(TEXT_FIELD_SIZE);
        final JTextField operand2TF = new JTextField(TEXT_FIELD_SIZE);
        JLabel operand1Label = new JLabel(operand1LabelString + ": ");
        JLabel operand2Label = new JLabel(operand2LabelString + ": ");

        final JLabel resultLabel = new JLabel();
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);

        tfPanel.add(operand1Label);
        tfPanel.add(operand1TF);
        tfPanel.add(operand2Label);
        tfPanel.add(operand2TF);

        Operation[] operations = {new Addition(), new Subtraction(),
                new Multiplication(), new Division()};

        for (final Operation operation : operations) {
            JButton operationButton = new JButton(translate(operation.getName()));
            operationButton.addActionListener(e -> {
                String operand1 = operand1TF.getText();
                String operand2 = operand2TF.getText();
                String result = operation.operate(new String[]{operand1, operand2});
                String resultString = translate("Result") + ": " + result;
                System.out.println(resultString);
                resultLabel.setText(resultString);
            });
            buttonPanel.add(operationButton);
        }

        JButton languageButton = new JButton();
        if (LanguageSettings.selectedLanguage == Language.TURKISH) {
            languageButton.setText("EN");
        } else {
            languageButton.setText("TR");
        }

        languageButton.addActionListener(e -> {
            switch (LanguageSettings.selectedLanguage) {
                case TURKISH:
                    LanguageSettings.setLanguage(Language.ENGLISH);
                    break;
                case ENGLISH:
                    LanguageSettings.setLanguage(Language.TURKISH);
            }
            remove(mainPanel);
            createPanel();
            revalidate();
        });

        buttonPanel.add(languageButton);

        mainPanel.add(tfPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        add(mainPanel);
    }

    private void initVocabularies() {
        turkishVocabulary = new HashMap<>();

        turkishVocabulary.put("First Number", "Birinci Sayı");
        turkishVocabulary.put("Second Number", "İkinci Sayı");
        turkishVocabulary.put("Add", "Topla");
        turkishVocabulary.put("Subtract", "Çıkar");
        turkishVocabulary.put("Multiply", "Çarp");
        turkishVocabulary.put("Divide", "Böl");
        turkishVocabulary.put("Result", "Sonuç");
    }

    private String translate(String word) {
        switch (LanguageSettings.selectedLanguage) {
            case ENGLISH:
                return word;
            default:
                return turkishVocabulary.getOrDefault(word, word);
        }
    }

}
