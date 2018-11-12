package gui.build;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    public JLabel translateThisLabel, translateItLabel, inputLabel, positiveResultLabel, negativeResultLabel,
            setRemovingLabel, setRandomWordsLabel, progressLabel;
    public JTextField whatToTranslateTextField;
    public JButton nextButton;
    public JProgressBar pb;
    public JRadioButton removeYes, removeNo, randomYes, randomNo;

    public MainPanel() {

        setLayout(null);
        setBackground(Color.lightGray);
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
        translateThisLabel.setForeground(Color.BLUE);
        add(translateThisLabel);
        translateThisLabel.setBounds(0, 0, 180, 40);

        translateItLabel = new JLabel("click Next word...");
        translateItLabel.setFont(new Font("Arial", Font.BOLD, 25));
        translateItLabel.setForeground(Color.BLACK);
        add(translateItLabel);
        translateItLabel.setBounds(185, 0, 397, 40);

        inputLabel = new JLabel("Answer:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 25));
        inputLabel.setForeground(Color.YELLOW);
        add(inputLabel);
        inputLabel.setBounds(0, 45, 180, 40);

        positiveResultLabel = new JLabel("GOOD");
        positiveResultLabel.setFont(new Font("Arial", Font.BOLD, 30));
        positiveResultLabel.setForeground(Color.GREEN);
        add(positiveResultLabel);
        positiveResultLabel.setVisible(false);
        positiveResultLabel.setBounds(30, 82, 112, 115);

        negativeResultLabel = new JLabel("WRONG");
        negativeResultLabel.setFont(new Font("Arial", Font.BOLD, 30));
        negativeResultLabel.setForeground(Color.RED);
        add(negativeResultLabel);
        negativeResultLabel.setVisible(false);
        negativeResultLabel.setBounds(420, 82, 125, 115);

        setRemovingLabel = new JLabel("Remove words?");
        setRemovingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        setRemovingLabel.setForeground(Color.BLACK);
        add(setRemovingLabel);
        setRemovingLabel.setBounds(20, 263, 180, 30);
        setRemovingLabel.setToolTipText("Do you want remove each word after good answer?");

        setRandomWordsLabel = new JLabel("Random words?");
        setRandomWordsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        setRandomWordsLabel.setForeground(Color.BLACK);
        add(setRandomWordsLabel);
        setRandomWordsLabel.setBounds(330, 263, 165, 30);
        setRandomWordsLabel.setToolTipText("HARD LEVEL - you must answer correctly to skip to the next word. Removing is on when random is off.");

        progressLabel = new JLabel("Progress...");
        progressLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        progressLabel.setForeground(Color.CYAN);
        add(progressLabel);
        progressLabel.setBounds(250, 179, 150, 17);
    }

    //TEXT FIELD
    private void addTextFields() {
        whatToTranslateTextField = new JTextField();
        add(whatToTranslateTextField);
        whatToTranslateTextField.setBackground(Color.lightGray);
        whatToTranslateTextField.setBounds(185, 41, 397, 40);
        whatToTranslateTextField.setFont(new Font("Arial", Font.BOLD, 25));
        whatToTranslateTextField.setForeground(Color.GREEN);
    }

    //BUTTONS
    private void addButtons() {
        nextButton = new JButton("Next word");
        nextButton.setFont(new Font("Arial", Font.ITALIC, 20));
        nextButton.setForeground(Color.black);
        nextButton.setVisible(true);
        add(nextButton);
        nextButton.setBounds(182, 90, 200, 75);
        nextButton.setBackground(Color.pink);
    }

    //PROGRESS BAR
    private void addProgressBar() {
        pb = new JProgressBar();
        pb.setVisible(true);
        add(pb);
        pb.setBounds(16, 200, 550, 50);
        Border border = BorderFactory.createLineBorder(Color.PINK, 5);
        //pb.setBorder(new TitledBorder(border));
        pb.setBorder(border);
        pb.setBackground(Color.yellow);
        pb.setStringPainted(false);
    }

    //RADIO BUTTONS
    private void addRadioButtons() {
        removeYes = new JRadioButton("On", true);
        removeNo = new JRadioButton("Off");
        removeYes.setBounds(190, 242, 50, 50);
        removeNo.setBounds(190, 268, 50, 50);
        ButtonGroup groupRemove = new ButtonGroup();

        groupRemove.add(removeYes);
        groupRemove.add(removeNo);
        add(removeYes);
        add(removeNo);

        randomYes = new JRadioButton("On", true);
        randomNo = new JRadioButton("Off");
        randomYes.setBounds(500, 242, 50, 50);
        randomNo.setBounds(500, 268, 50, 50);
        ButtonGroup groupRandom = new ButtonGroup();

        groupRandom.add(randomYes);
        groupRandom.add(randomNo);
        add(randomYes);
        add(randomNo);
    }
}