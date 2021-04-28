package main.java.com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    private final Garage garage = new GarageImpl();
    private final Car car1 = new Car(1, "brand5", "modelname:1", 10, 140, 1);
    private final Car car2 = new Car(2, "brand5", "modelname:2", 20, 130, 4);
    private final Car car3 = new Car(3, "brand4", "modelname:3", 30, 120, 5);
    private final Car car4 = new Car(4, "brand3", "modelname:4", 40, 110, 5);
    private final Car car5 = new Car(5, "brand4", "modelname:5", 50, 100, 3);
    private final Car car6 = new Car(6, "brand1", "modelname:6", 60, 90, 1);
    private final Car car7 = new Car(7, "brand3", "modelname:7", 70, 80, 6);
    private final Car car8 = new Car(8, "brand3", "modelname:8", 80, 70, 2);
    private final Car car9 = new Car(9, "brand3", "modelname:9", 90, 60, 4);
    private final Car car10 = new Car(10, "brand4", "modelname:10", 100, 50, 1);
    private final Car car11 = new Car(11, "brand2", "modelname:10", 110, 40, 4);
    private final Car car12 = new Car(12, "brand1", "modelname:10", 120, 30, 1);
    private final Car car13 = new Car(13, "brand1", "modelname:10", 130, 20, 2);
    private final Car car14 = new Car(14, "brand3", "modelname:10", 140, 10, 1);

    private final Owner owner1 = new Owner(1, "Ignaty", "Shotolovich", 23);
    private final Owner owner2 = new Owner(2, "Vladimir", "Putin", 100);
    private final Owner owner3 = new Owner(3, "Issak", "Glina", 15);
    private final Owner owner4 = new Owner(4, "Alexandr", "Puskin", 221);
    private final Owner owner5 = new Owner(5, "Karl", "Marx",202 );
    private final Owner owner6 = new Owner(6, "Nezaleshna", "Ykraina", 29);


    @BeforeEach
    void addNewCarTest() {
        garage.addNewCar(car1, owner1);
        garage.addNewCar(car2, owner4);
        garage.addNewCar(car3, owner5);
        garage.addNewCar(car4, owner5);
        garage.addNewCar(car5, owner3);
        garage.addNewCar(car6, owner1);
        garage.addNewCar(car7, owner6);
        garage.addNewCar(car8, owner2);
        garage.addNewCar(car9, owner4);
        garage.addNewCar(car10, owner1);
        garage.addNewCar(car11, owner4);
        garage.addNewCar(car12, owner1);
        garage.addNewCar(car13, owner2);
        garage.addNewCar(car14, owner1);

    }

    @Test
    void allCarsUniqueOwnersTest() {
        Collection<Owner> allCarDrivers = new TreeSet<>(new Comparator<Owner>() {
            @Override
            public int compare(Owner o1, Owner o2) {
                return Integer.compare(o1.getId(),o2.getId());
            }
        });
        allCarDrivers.add(owner1);
        allCarDrivers.add(owner2);
        allCarDrivers.add(owner3);
        allCarDrivers.add(owner4);
        allCarDrivers.add(owner5);
        allCarDrivers.add(owner6);
        Collection<Owner> allCarsUniqueOwnersTest = garage.allCarsUniqueOwners();
        assertEquals(allCarDrivers, allCarsUniqueOwnersTest);
    }

    @Test
    void topThreeCarsByMaxVelocityTest() {
        Collection<Car> topThreeCarsByMaxVelocity = new LinkedList<Car>();
        topThreeCarsByMaxVelocity.add(car14);
        topThreeCarsByMaxVelocity.add(car13);
        topThreeCarsByMaxVelocity.add(car12);
        System.out.println(topThreeCarsByMaxVelocity);
        Collection<Car> topThreeCarsByMaxVelocityTest = garage.topThreeCarsByMaxVelocity();
        assertEquals(topThreeCarsByMaxVelocity,topThreeCarsByMaxVelocityTest);
    }

    @Test
    void allCarsOfBrandTest() {
        Collection<Car> allCarsOfBrand = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.getCarId(),o2.getCarId());
            }
        });
        allCarsOfBrand.add(car6);
        allCarsOfBrand.add(car12);
        allCarsOfBrand.add(car13);
        Collection<Car> allCarsOfBrandTest = garage.allCarsOfBrand("brand1");
        assertEquals(allCarsOfBrand, allCarsOfBrandTest);
    }

    @Test
    void carsWithPowerMoreThanTest() {
        Collection<Car> carsWithPowerMoreThanTest = new LinkedList<>();
        carsWithPowerMoreThanTest.add(car8);
        carsWithPowerMoreThanTest.add(car7);
        carsWithPowerMoreThanTest.add(car6);
        carsWithPowerMoreThanTest.add(car5);
        carsWithPowerMoreThanTest.add(car4);
        carsWithPowerMoreThanTest.add(car3);
        carsWithPowerMoreThanTest.add(car2);
        carsWithPowerMoreThanTest.add(car1);
        Collection<Car> carsWithPowerMoreThan= garage.carsWithPowerMoreThan(60);
        assertEquals(carsWithPowerMoreThanTest,carsWithPowerMoreThan);
    }

    @Test
    void allCarsOfOwnerTest() {
        Collection<Car> allCarsOfOwnerTest = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.getCarId(),o2.getCarId());
            }
        });
        allCarsOfOwnerTest.add(car1);
        allCarsOfOwnerTest.add(car6);
        allCarsOfOwnerTest.add(car10);
        allCarsOfOwnerTest.add(car12);
        allCarsOfOwnerTest.add(car14);
        Collection<Car> allCarsOfOwner = garage.allCarsOfOwner(owner1);
        assertEquals(allCarsOfOwnerTest, allCarsOfOwner);
    }

    @Test
    void meanOwnersAgeOfCarBrandTest() {
        int meanOwnersAgeOfCarBrandTest = garage.meanOwnersAgeOfCarBrand("brand3");
        int meanOwnersAgeOfCarBrand=115;
        assertEquals(meanOwnersAgeOfCarBrand, meanOwnersAgeOfCarBrandTest);
    }

    @Test
    void meanCarNumberForEachOwnerTest() {
        int meanCarNumberForEachOwnerTest = garage.meanCarNumberForEachOwner();
        int meanCarNumberForEachOwner = 2;
        assertEquals(meanCarNumberForEachOwner, meanCarNumberForEachOwnerTest);
    }

    @Test
    void removeCarTest() {
        Car removedCarTest = garage.removeCar(7);
        Car removedCar = car7;
        assertEquals(removedCar, removedCarTest);
    }

    @Test
    void TestCarRemoveAndPower() {
        Collection<Car> carsWithPowerMoreThan = new LinkedList<Car>();
        carsWithPowerMoreThan.add(car14);
        carsWithPowerMoreThan.add(car13);
        carsWithPowerMoreThan.add(car12);
        carsWithPowerMoreThan.add(car11);
        carsWithPowerMoreThan.add(car10);
        carsWithPowerMoreThan.add(car9);
        carsWithPowerMoreThan.add(car8);
        carsWithPowerMoreThan.add(car6);
        carsWithPowerMoreThan.add(car5);
        carsWithPowerMoreThan.add(car4);
        carsWithPowerMoreThan.add(car3);
        carsWithPowerMoreThan.add(car2);
        carsWithPowerMoreThan.add(car1);
        garage.removeCar(7);
        Collection<Car> carsWithPowerMoreThanTast = garage.carsWithPowerMoreThan(0);
        assertEquals(carsWithPowerMoreThanTast, carsWithPowerMoreThan);
    }

    @Test
    void addingACarToTheGarageWithATriumphantCarTest() {
        Car carToAdd = new Car(1, "brand5", "modelname:1", 10, 140, 1);
        Throwable massage = assertThrows(IllegalArgumentException.class, () -> {
            garage.addNewCar(carToAdd, owner1);
        });
        assertEquals(massage.getMessage(), "ERROR, unfortunately, such a car is already in the garage");
    }

    @Test
    void communicationOwnerCarTest() {
        Car carConnecter = new Car(22, "brand5", "modelname:1", 10, 140, 5);
        Throwable massage = assertThrows(IllegalArgumentException.class, () -> {
            garage.addNewCar(carConnecter, owner1);
        });
        assertEquals(massage.getMessage(), "ERROR, the connection between the machine and the owner is lost");
    }
}