package com.mustafahakan;

import com.mustafahakan.Operations.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.mustafahakan.Language.ENGLISH;
import static com.mustafahakan.Language.TURKISH;

/**
 * Created by Mustafa Hakan Kara on 17/07/2022
 */
public class TextBasedCalculator extends JFrame {

    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 100;
    private static final int TEXT_FIELD_SIZE = 16;
    private static final String PROJECT_NAME = "Text-Based Calculator (MHK)";

    // Properties
    private JPanel mainPanel;
    private Map<String, String> turkishVocabulary;
    private JTextField operand1TF, operand2TF;
    private JLabel resultLabel;

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
        operand1TF = new JTextField(TEXT_FIELD_SIZE);
        operand2TF = new JTextField(TEXT_FIELD_SIZE);
        JLabel operand1Label = new JLabel(operand1LabelString + ": ");
        JLabel operand2Label = new JLabel(operand2LabelString + ": ");

        final JLabel resultTextLabel = new JLabel(translate("Result") + ":");
        resultLabel = new JLabel();

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultTextLabel);
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
                resultLabel.setText(result);
                System.out.println(resultTextLabel.getText() + resultLabel.getText());
            });
            buttonPanel.add(operationButton);
        }

        buttonPanel.add(createLanguageButton());

        mainPanel.add(tfPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        add(mainPanel);
    }

    private JButton createLanguageButton() {
        JButton languageButton = new JButton();

        if (LanguageSettings.selectedLanguage == TURKISH) {
            languageButton.setText("EN");
        } else {
            languageButton.setText("TR");
        }

        languageButton.addActionListener(e -> {
            Language src = LanguageSettings.selectedLanguage;
            Language dest;

            switch (src) {
                case ENGLISH:
                    dest = TURKISH;
                    break;
                default:
                    dest = ENGLISH;
            }

            LanguageSettings.setLanguage(dest);
            String newOperand1 = translateTextBasedNumber(operand1TF.getText(), src, dest);
            String newOperand2 = translateTextBasedNumber(operand2TF.getText(), src, dest);
            String newResult = translateTextBasedNumber(resultLabel.getText(), src, dest);

            remove(mainPanel);
            createPanel();
            operand1TF.setText(newOperand1);
            operand2TF.setText(newOperand2);
            resultLabel.setText(newResult);

            revalidate();
        });

        return languageButton;
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

    private String translateTextBasedNumber(String word, Language src, Language dest) {
        if(word == null || word.isEmpty()) {
            return "";
        }

        return new Identity(src, dest).operate(new String[] {word});
    }

}
