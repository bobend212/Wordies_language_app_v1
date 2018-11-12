package gui.build;

import java.awt.*;

public class Client {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}