package com.company;

public class Order {
    private static int x = 0;
     Order() { // конструктор заказов с последовательной их нумерацией
        ++x;
        name = "order № " + x;
    }
    public String name;

}
