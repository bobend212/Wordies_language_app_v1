package gui.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Random;


public class ExcelArea extends MyPanel implements ActionListener {


    public static String path;
    public static Object result1;
    public static Object result2;

    HSSFSheet sheet;
    HSSFWorkbook workbook;
    private int numberOfrow = 0;
    String[] translateToArray = new String[1];
    private int counter = 0;
    ResultWindow resultWindow;
    String output2;
    MyFrame mainFrame;
    ExcelArea excelArea;

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

    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == nextButton) {

            generateWord();

            positiveResultLabel.setVisible(false);
            negativeResultLabel.setVisible(false);

        } else if (source == whatToTranslateTextField) {

            String output = whatToTranslateTextField.getText();

            if (output.equals(translateToArray[0])) {
                System.out.println(path);
                System.out.println("dobrze");
                positiveResultLabel.setVisible(true);
                negativeResultLabel.setVisible(false);
                whatToTranslateTextField.setText("");
                removeRow(sheet, numberOfrow);
                generateWord();
                counter--;
                System.out.println(counter); // <-- licznik slow
            } else {
                System.out.println("zle");
                whatToTranslateTextField.setText("");
                negativeResultLabel.setVisible(true);
                positiveResultLabel.setVisible(false);
                //System.out.println(counter);
            }
        } else if (source == MyFrame.testButton) {

            this.setVisible(false);

            new ResultWindow();
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
            Random random = new Random();
            int words_amount = sheet.getLastRowNum();
            int num = random.nextInt(words_amount + 1);
            HSSFRow randomRow = sheet.getRow(num);
            numberOfrow = num;
            translateItLabel.setText(randomRow.getCell(0).getStringCellValue());
            translateToArray[0] = randomRow.getCell(1).getStringCellValue();
        } catch (NullPointerException e) {
           // resultWindow = new ResultWindow();


            System.out.println("Koniec");
        }
    }
}


