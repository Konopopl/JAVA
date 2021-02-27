package main.java.com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

        @Test
        public void Test() {

            System.out.println("HelloWorld");
            Garage g = new Mmethods();
            Car my_CAR = new Car(5, "Shihul", "Shihul", 10, 6487, 4635);
            Car my_CAR1 = new Car(6, "secas", "secas", 10, 6487, 4636);
            Car my_CAR2 = new Car(7, "Shihul", "Shihul", 10, 6487, 4637);
            Car my_CAR3 = new Car(8, "secas", "secas", 80, 1000, 4638);

           // System.out.println(my_CAR);

            Owner Peter = new Owner("Petro", "Petrov",28);
            Owner Peter1 = new Owner("Petro1", "Petrov1",29);
            Owner Peter2 = new Owner("Petro2", "Petrov2",30);
            Owner Peter3 = new Owner("Petro3", "Petrov3",32);

            g.addNewCar(my_CAR1, Peter1);
            g.addNewCar(my_CAR2, Peter2);
            //g.addNewCar(my_CAR3, Peter1); добавление +
            g.addNewCar(my_CAR, Peter);
            g.addNewCar(my_CAR3, Peter3);
            //g.carsWithPowerMoreThan(0);мощность +

            //g.allCarsOfOwner(Peter3); машины владельца +
            //g.allCarsOfBrand("secas");
            g.topThreeCarsByMaxVelocity();
            //g.allCarsUniqueOwners();  +
            //g.allCarsOfBrand("secas"); марка +
             //g.allCarsOfOwner(Peter1); +
            //g.meanOwnersAgeOfCarBrand("secas");

            //Assert.assertEquals(g.meanOwnersAgeOfCarBrand("secas"),30);средний возраст +
            //g.allCarsUniqueOwners();
            //g.allCarsOfOwner(Peter);
            //g.topThreeCarsByMaxVelocity();
            //g.allCarsOfBrand("ichi");
           // g.removeCar(5);удаление+
            //g.allCarsOfOwner(Peter);



        }


    }
