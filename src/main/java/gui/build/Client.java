package gui.build;

import java.awt.*;

public class Client {

    public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MyFrame();
                }
            });
    }
}


// THIS PROJECT I NEED TO FINISH BEFORE 2019 !!!

/*
23.10 - generuje losowe liczby i usuwa wiersz po prawidlowym tlumaczeniu
27.10 - dodalem wyjatek obslugujacy metode generateWord, dzieki temu program sie nie wysypuje



 */

/* FUTURE FEATURES
- dodanie "wielookienkowosci"
- wyswietlenie rezultatu po przetlumaczeniu wszystkich slowek "cos jak nowe okno z gratulacjami i pytaniem czy sprobowac jeszcze raz"        <<---
- wprowadzenie licznika czasu
- dodanie innego tla "obrazkowego" i zmiana kolorystyki aplikacji
- dodanie rezultatu po wpisaniu tlumaczenia

main misja: zrobic zamykanie jednego okna a otwieranie innego w tej samej aplikacji


 */

