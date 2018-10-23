package gui.build;

import javax.swing.*;
import java.awt.*;


public class MyPanel extends JPanel {

    public JLabel translateThisLabel, translateItLabel, inputLabel, positiveResultLabel, negativeResultLabel;
    public JTextField whatToTranslateTextField;
    public JButton nextButton;


    public MyPanel() {

        setLayout(null);
        setBackground(Color.DARK_GRAY);
        addLabels();
        addTextFields();
        addButtons();
    }

    //LABELS
    private void addLabels() {
        translateThisLabel = new JLabel("Translate this:");
        translateThisLabel.setFont(new Font("Arial", Font.BOLD, 25));
        translateThisLabel.setForeground(Color.WHITE);
        translateThisLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(translateThisLabel);
        translateThisLabel.setBounds(0, 0, 180, 40);

        translateItLabel = new JLabel("press next");
        translateItLabel.setFont(new Font("Arial", Font.BOLD, 25));
        translateItLabel.setForeground(Color.WHITE);
        translateItLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(translateItLabel);
        translateItLabel.setBounds(185, 0, 250, 40);

        inputLabel = new JLabel("Input:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 25));
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(inputLabel);
        inputLabel.setBounds(0, 45, 180, 40);

        positiveResultLabel = new JLabel("GOOD ANSWER!");
        positiveResultLabel.setFont(new Font("Arial", Font.BOLD, 25));
        positiveResultLabel.setForeground(Color.WHITE);
        positiveResultLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(positiveResultLabel);
        positiveResultLabel.setVisible(false);
        positiveResultLabel.setBounds(20, 200, 250, 40);

        negativeResultLabel = new JLabel("TRY AGAIN or NEXT");
        negativeResultLabel.setFont(new Font("Arial", Font.BOLD, 25));
        negativeResultLabel.setForeground(Color.WHITE);
        negativeResultLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(negativeResultLabel);
        negativeResultLabel.setVisible(false);
        negativeResultLabel.setBounds(20, 200, 300, 40);
    }

    //TEXT FIELD
    private void addTextFields() {
        whatToTranslateTextField = new JTextField();
        whatToTranslateTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(whatToTranslateTextField);
        whatToTranslateTextField.setBounds(185, 45, 250, 40);
        whatToTranslateTextField.setFont(new Font("Arial", Font.BOLD, 25));
    }

    //BUTTONS
    private void addButtons() {
        nextButton = new JButton("Next word");
        nextButton.setFont(new Font("Arial", Font.BOLD, 25));
        nextButton.setForeground(Color.MAGENTA);
        nextButton.setVisible(true);
        add(nextButton);
        nextButton.setBounds(0, 90, 205, 50);
        nextButton.setBackground(Color.YELLOW);
    }

}
