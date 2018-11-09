package gui.build;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class MyPanel extends JPanel {

    public JLabel translateThisLabel, translateItLabel, inputLabel, positiveResultLabel, negativeResultLabel,
        setRemovingLabel, setRandomWordsLabel;
    public JTextField whatToTranslateTextField;
    public JButton nextButton;
    public JProgressBar pb;
    public JRadioButton removeYes, removeNo, randomYes, randomNo;


    public MyPanel() {

        setLayout(null);
        setBackground(Color.gray);
        addLabels();
        addTextFields();
        addButtons();
        addProgressBar();
        addRadioButtons();
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
        positiveResultLabel.setBounds(20, 250, 250, 40);

        negativeResultLabel = new JLabel("TRY AGAIN or NEXT");
        negativeResultLabel.setFont(new Font("Arial", Font.BOLD, 25));
        negativeResultLabel.setForeground(Color.WHITE);
        negativeResultLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(negativeResultLabel);
        negativeResultLabel.setVisible(false);
        negativeResultLabel.setBounds(20, 250, 300, 40);

        setRemovingLabel = new JLabel("Remove words?");
        setRemovingLabel.setFont(new Font("Arial", Font.BOLD, 25));
        setRemovingLabel.setForeground(Color.WHITE);
        setRemovingLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(setRemovingLabel);
        setRemovingLabel.setBounds(0, 300, 200, 40);

        setRandomWordsLabel = new JLabel("Random?");
        setRandomWordsLabel.setFont(new Font("Arial", Font.BOLD, 25));
        setRandomWordsLabel.setForeground(Color.WHITE);
        setRandomWordsLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(setRandomWordsLabel);
        setRandomWordsLabel.setBounds(220, 300, 150, 40);
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

    //PROGRESS BAR
    private void addProgressBar() {
        pb = new JProgressBar();
        pb.setVisible(true);
        add(pb);
        pb.setBounds(0, 150, 450, 80);
        Border border = BorderFactory.createTitledBorder("Progress...");
        pb.setBorder(new TitledBorder(border));
        pb.setBorder(border);
        pb.setStringPainted(true);


    }

    //RADIO BUTTONS
    private void addRadioButtons() {
        removeYes = new JRadioButton("Yes", true);
        removeNo = new JRadioButton("No");
        removeYes.setBounds(30, 340, 50, 50);
        removeNo.setBounds(100, 340, 50, 50);
        ButtonGroup groupRemove = new ButtonGroup();

        groupRemove.add(removeYes);
        groupRemove.add(removeNo);
        add(removeYes);
        add(removeNo);

        randomYes = new JRadioButton("Yes", true);
        randomNo = new JRadioButton("No");
        randomYes.setBounds(230, 340, 50, 50);
        randomNo.setBounds(300, 340, 50, 50);
        ButtonGroup groupRandom = new ButtonGroup();

        groupRandom.add(randomYes);
        groupRandom.add(randomNo);
        add(randomYes);
        add(randomNo);

    }



}
