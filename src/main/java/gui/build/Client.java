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
07.11 - dodalem dwa okienka w ktoreych trzeba podac sciezke do katalogu z baza slowek i nazwe pliku ze slowkami,
Dodatkowo ogarnalem jak zamykac jedno okno i otwierac inne.



 */

/* FUTURE FEATURES //
DONE- wyswietlenie rezultatu po przetlumaczeniu wszystkich slowek "cos jak nowe okno z gratulacjami i pytaniem czy sprobowac jeszcze raz"        <<---
- wprowadzenie licznika czasu
- dodanie innego tla "obrazkowego" i zmiana kolorystyki aplikacji
- dodanie rezultatu po wpisaniu tlumaczenia
DONE- wprowadzic wybor pliku ze slowkami z menu wyboru! <-- wazne



 */

