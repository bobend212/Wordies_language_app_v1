package gui.build;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class MyFrame extends JFrame {

    public MyFrame() {

        //showWelcomeDialog();
        loadFile();
        createMainGUI();
    }

    public void createMainGUI() {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Wordies 1.1.0 ©mk");
        setSize(500, 500);
        setLocation(620, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        MyPanel panel = new MyPanel();
        add(panel);

        ExcelArea excelArea = new ExcelArea();
        add(excelArea);
    }

    public void loadFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select your excel file with words");
        jfc.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xls", "xlsx");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            ExcelArea.pathName = selectedFile.getAbsolutePath();
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            System.exit(0);
        }
    }

    public void showWelcomeDialog() {

        JOptionPane.showConfirmDialog(null, "Congratulations! You know \n" + "them all!", "Welcome instructions", JOptionPane.DEFAULT_OPTION);

    }


}
