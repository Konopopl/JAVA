package com.company;

import main.java.com.company.Car;
import main.java.com.company.Garage;
import main.java.com.company.Mmethods;
import main.java.com.company.Owner;

import java.util.Collection;

public class Main {


    public static void main(String[] args) {
     //   Car my_CAR = new Car(5, "ichi", "HFJF", 10, 6487, 4637);
     //   System.out.println(my_CAR);

     // Owner Peter = new Owner("Petro", "Petrov",28);

      Garage g = new Mmethods();

        //g.addNewCar(my_CAR, Peter);
        g.meanOwnersAgeOfCarBrand("ichi");
        //g.allCarsUniqueOwners();
        //g.allCarsOfOwner(Peter);
        //g.topThreeCarsByMaxVelocity();
    }

    // write your code here
}

