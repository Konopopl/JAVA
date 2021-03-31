package com.company;

public class Main {
    public static void main(String[] args) {
        Contora.creatingFillingInAnArrayOfTaxiDriversAddingThemToTheQueue();
        Contora.Disp dispetcher = new Contora.Disp();
        dispetcher.start();
        for (Contora.Taxi c : Contora.taxsists) {
            c.start();
        }
    }
}
