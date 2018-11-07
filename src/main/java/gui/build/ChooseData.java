package gui.build;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChooseData {

    public ChooseData() {
        JFrame frame = new JFrame();
        ExcelArea.result1 = JOptionPane.showInputDialog(frame, "Enter path to folder with wordies:");
        ExcelArea.result2 = JOptionPane.showInputDialog(frame, "Enter file name:");
    }


}