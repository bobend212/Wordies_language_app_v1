package gui.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Random;


public class ExcelArea extends MyPanel implements ActionListener {

    public static Object result1;
    public static Object result2;
    public int counter;

    HSSFSheet sheet;
    HSSFWorkbook workbook;
    private int numberOfrow = 0;
    String[] translateToArray = new String[1];
    ResultWindow resultWindow;
    String output2;
    MyFrame mainFrame;
    ExcelArea excelArea;
    int progressValue = 1;
    int attempts = 0;
    int goodAnswer = 0;
    int failAnswer = 0;


    String examplePath = "M:\\Java Projects\\mateuszwordies\\tester.xls";

    public ExcelArea() {

        importWords();

        nextButton.addActionListener(this);
        whatToTranslateTextField.addActionListener(this);


    }

    public void importWords() {
        try {
            //String res1 = result1.toString();
            //String res2 = result2.toString();
            //String tog = res1+"\\"+res2+".xls";
            workbook = new HSSFWorkbook(new FileInputStream(examplePath));
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
                //counter--;
                //System.out.println(counter); // <-- licznik slow

            } else {
                whatToTranslateTextField.setText("");
                negativeResultLabel.setVisible(true);
                positiveResultLabel.setVisible(false);
                //System.out.println(counter);
                failAnswer++;
                pb.setString("Attempts: " + attempts + " - " + "Good: " + goodAnswer + " , " + "Fails: " + failAnswer);
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

    private void generateWord() {
        try {
            int words_amount = sheet.getLastRowNum();
            if (randomYes.isSelected()) {
                Random random = new Random();

                int num = random.nextInt(words_amount + 1);
                HSSFRow randomRow = sheet.getRow(num);
                numberOfrow = num;
                translateItLabel.setText(randomRow.getCell(0).getStringCellValue());
                translateToArray[0] = randomRow.getCell(1).getStringCellValue();
            }
            else if (randomNo.isSelected()) {
                //int words_amount = sheet.getLastRowNum();
                HSSFRow noRandomRow = sheet.getRow(words_amount);

                translateItLabel.setText(noRandomRow.getCell(0).getStringCellValue());
                //translateToArray[0] = noRandomRow.getCell(1).getStringCellValue();
            }
        } catch (NullPointerException e) {

            new ResultWindow();

            System.out.println("Koniec");
        }
    }
}