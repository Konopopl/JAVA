package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;

public class Contora {
    public static int amountTaxi = 100; // количество таксистов в конторе
    public static ArrayList<Taxi> taxsists = new ArrayList<>(amountTaxi);// массив таксистов
    public static ArrayBlockingQueue<Taxi> queueTaxi = new ArrayBlockingQueue<>(amountTaxi);// блокирующая очередь таксистов

    public static void creatingFillingInAnArrayOfTaxiDriversAddingThemToTheQueue() {
        for (int i = 0; i < amountTaxi; i++) {
            taxsists.add(new Taxi(i));
        }
        for (Taxi c : taxsists) {
            queueTaxi.add(c);
        }
    } // метод генерирует таксистов и заполняет ими массив и очередь


    public static class Disp extends Thread { // клас Диспетчер , наследник класса Потоков, вложен в Main
        @Override
        public void run() {
            while (true) {

                Order order = new Order();
                Taxi executor = null;

                try {
                    executor = queueTaxi.take(); // так как мы используем блокирующую очередь, диспетчер спит пока очередь пуста
                } catch (InterruptedException ignore) {
                    ignore.printStackTrace();
                }
               // executor.setCondition("placeOrder");
                System.out.println("Taxi:" + executor.number + ", placeOrder" + order.name);
                synchronized (executor) { // захватываем монитор нужного таксиста
                    executor.setCondition("placeOrder"); //меняем поле таксиста
                    executor.notify(); // будим нужного таксист
                }
            }
        }
    }
    public static class Taxi extends Thread { // тоже самое для таксистов
        public String condition; // поле состояния таксиста, по нему он узнает что ему делать
        public int number; // поле номера таксиста в массиве таксистов
        public Taxi() {
        }

        public Taxi(int number) {
            this.number = number;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public static int random() {
            int lowestValue = 0;
            int highestМalue = 10;
            int random_number = lowestValue + (int) (Math.random() * highestМalue);
            return random_number;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) { // каждый таксист синхронизируется по себе
                    while (!(this.condition == null)) { // проверяем поле таксиста , так как он может проснуться раньше срока, без notify
                        try {
                            sleep(random());
                        } catch (InterruptedException ignore) {
                            ignore.printStackTrace();
                        }

                        System.out.println(this.number + " Order completed, sir");
                        this.condition = null;
                        queueTaxi.add(this);
                        try {
                            this.wait(); // таксист ,добавившись в очередь, засыпает
                        } catch (InterruptedException ignore) {
                            ignore.printStackTrace();
                        }

                    }
                }
            }
        }
    }

}