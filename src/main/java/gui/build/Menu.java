
//nie uzywana klasa

//package gui.build;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileInputStream;
//
//public class Menu extends JMenuBar implements ActionListener {
//
//    JMenu file;
//    JMenuItem loadFile;
//
//    public File plik;
//
//
//    public Menu() {
//        createMenu();
//    }
//
//
//    public void createMenu() {
//
//        file = new JMenu("File");
//        this.add(file);
//
//        loadFile = new JMenuItem("Load file");
//        file.add(loadFile);
//
//        loadFile.addActionListener(this);
//
//    }
//
//
//    public void actionPerformed(ActionEvent e) {
//        Object obj = e.getSource();
//
//        if (obj == loadFile) {
//
//            JFileChooser fc = new JFileChooser();
//
//            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//                plik = fc.getSelectedFile();
//                ExcelArea.path = plik.getAbsolutePath();
//                System.out.println(ExcelArea.path);
//            }
//        }
//    }
//
//}
