package gui.build;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener {

    JMenuBar menu;
    JMenu file;
    JMenuItem loadFile;
    public String path;
    public File plik;

    public MyFrame() {


        //OKNO DIALOGOWE WYSWIETLANE PRZED URUCHOMIENIEM APLIKACJI
        //JOptionPane.showMessageDialog(null, "Pamietaj o wczytaniu slowek do Excela", "Witaj w Wordies", JOptionPane.INFORMATION_MESSAGE);


        setTitle("Wordies 1.1.0 ©mk");
        setSize(500, 500);
        setLocation(620, 300);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setLayout(null);



        MyPanel panel = new MyPanel();
        add(panel);

        ExcelArea excelArea = new ExcelArea();
        add(excelArea);


        //menu
        menu = new JMenuBar();
        setJMenuBar(menu);

        file = new JMenu("File");
        menu.add(file);

        loadFile = new JMenuItem("Load file");
        file.add(loadFile);
        loadFile.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == loadFile) {

            JFileChooser fc = new JFileChooser();

            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                plik = fc.getSelectedFile();
                savePath(plik);
                //path = plik.getAbsolutePath();
                //System.out.println(path);
            }
        }
    }

    public void savePath(File plik) {
        path = plik.getAbsolutePath();
        System.out.println(path);
    }


}
