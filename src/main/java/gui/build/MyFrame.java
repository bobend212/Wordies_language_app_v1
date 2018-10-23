package gui.build;

import javax.swing.*;

public class MyFrame extends JFrame {



    public MyFrame() {


        //OKNO DIALOGOWE WYSWIETLANE PRZED URUCHOMIENIEM APLIKACJI
        //JOptionPane.showMessageDialog(null, "Pamietaj o wczytaniu slowek do Excela", "Witaj w Wordies", JOptionPane.INFORMATION_MESSAGE);


        setTitle("Wordies 1.1.0 ©mk");
        setSize(500, 500);
        setLocation(620, 300);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        MyPanel panel = new MyPanel();
        add(panel);

        ExcelArea excelArea = new ExcelArea();
        add(excelArea);
    }

}
