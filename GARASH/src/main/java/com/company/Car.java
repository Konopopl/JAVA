package main.java.com.company;

import java.util.*;

public class Car {

    public final int carId;
    public final String brand;
    public final String modelName;
    public final int maxVelocity;
    public final int power;
    public final int ownerId;

    public Car() {

        carId = 0;
        brand = null;
        modelName = null;
        maxVelocity = 0;
        power = 0;
        ownerId = 0;


    }

    public Car(int CarId, String Brand, String ModelName, int MaxVelocity, int Power, int OwnerId) {

        carId = CarId;
        brand = Brand;
        modelName = ModelName;
        maxVelocity = MaxVelocity;
        power = Power;
        ownerId = OwnerId;

    }

    // public  void displayInfo() { System.out.printf("\ncarId: %s \t Brand: %s \t  modelName: %s \t  maxVelocity: %s \t   power: %s \t      ownerId: %d \n "  ,
    //        carId, brand,modelName, maxVelocity, power, ownerId);}


    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", maxVelocity=" + maxVelocity +
                ", power=" + power +
                ", ownerId=" + ownerId +
                '}';

    }
}

