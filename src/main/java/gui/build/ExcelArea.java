package gui.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Random;

public class ExcelArea extends MainPanel implements ActionListener {

    public int counter;
    public static String pathName;
    HSSFSheet sheet;
    HSSFWorkbook workbook;
    private int numberOfrow = 0;
    String[] translateToArray = new String[1];
    int progressValue = 1;
    int attempts = 0;
    int goodAnswer = 0;
    int failAnswer = 0;

    public ExcelArea() {

        importWords();
        nextButton.addActionListener(this);
        whatToTranslateTextField.addActionListener(this);
    }

    public void importWords() {
        try {
            workbook = new HSSFWorkbook(new FileInputStream(pathName));
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int wordsQty = sheet.getLastRowNum() + 1;
        counter = wordsQty;

        pb.setMaximum(counter);
        pb.setMinimum(0);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == nextButton) {

            generateWord();

            positiveResultLabel.setVisible(false);
            negativeResultLabel.setVisible(false);

        } else if (source == whatToTranslateTextField) {

            String output = whatToTranslateTextField.getText();
            attempts++;

            if (output.equals(translateToArray[0])) {
                positiveResultLabel.setVisible(true);
                negativeResultLabel.setVisible(false);
                whatToTranslateTextField.setText("");
                goodAnswer++;
                if (removeYes.isSelected()) {
                    removeRow(sheet, numberOfrow);
                    pb.setValue(progressValue++);
                } else if (removeNo.isSelected()) {
                    pb.setString("Attempts: " + attempts + " - " + "Good: " + goodAnswer + " , " + "Fails: " + failAnswer);
                }
                generateWord();

            } else {
                whatToTranslateTextField.setText("");
                negativeResultLabel.setVisible(true);
                positiveResultLabel.setVisible(false);
                failAnswer++;
                if (removeNo.isSelected()) {
                    pb.setString("Attempts: " + attempts + " - " + "Good: " + goodAnswer + " , " + "Fails: " + failAnswer);
                }
            }
        }

    }

    private void removeRow(HSSFSheet sheet, int rowIndex) {
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }
        if (rowIndex == lastRowNum) {
            HSSFRow removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
    }

    public void generateWord() {
        try {
            if (randomYes.isSelected()) {
                Random random = new Random();
                int words_amount = sheet.getLastRowNum();
                int num = random.nextInt(words_amount + 1);
                HSSFRow randomRow = sheet.getRow(num);
                numberOfrow = num;
                translateItLabel.setText(randomRow.getCell(0).getStringCellValue());
                translateToArray[0] = randomRow.getCell(1).getStringCellValue();
                pb.setStringPainted(true);

            } else if (randomNo.isSelected()) {
                pb.setStringPainted(true);
                removeYes.setSelected(true);
                HSSFRow row = sheet.getRow(0);
                translateItLabel.setText(row.getCell(0).getStringCellValue());
                translateToArray[0] = row.getCell(1).getStringCellValue();
                String output2 = whatToTranslateTextField.getText();
                if (output2.equals(translateToArray[0])) {
                    removeRow(sheet, numberOfrow);
                }
            }
        } catch (NullPointerException e) {
            String exitButton = "QUIT";
            UIManager.put("OptionPane.okButtonText", exitButton);
            int result = JOptionPane.showConfirmDialog(null, "Congratulations! You know them all!", "Confirm Quit", JOptionPane.DEFAULT_OPTION);
            if (result == 0) {
                System.exit(0);
            }
        }
    }
}