package gui.build;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class MainFrame extends JFrame {

    public MainFrame() {

        showWelcomeDialog();
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
        setSize(600, 350);
        setLocation(620, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        MainPanel panel = new MainPanel();
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

        JOptionPane.showConfirmDialog(null, "1. Create excel file, \n" +
                "2. Add your own words which you want learn, \n" +
                "3. In 'A' column enter word and in the 'B' column enter your translation, \n" +
                "4. Select your file and..." +
                "\n Enjoy!",
                "Welcome information's", JOptionPane.DEFAULT_OPTION);
    }


}
