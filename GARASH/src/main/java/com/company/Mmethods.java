package main.java.com.company;

import java.util.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.LinkedList;

public class Mmethods implements Garage {

    // HashMap<Integer, Car> car;
    // HashMap<Integer, Owner> owners;
    //HashMap<Car, Owner> property; // словарь объект машина- объект владелец
    HashMap<String, ArrayList<Car>> marca = new HashMap<>(); // словарь  марка- машины
    ArrayList<Car> Speed = new ArrayList<>() ; // массив машин, остсортированный по скорости
    // ArrayList<Car> power; // массив машин, отсортированный по мощности
    HashMap<Owner, ArrayList<Car>> carsOfOwners= new HashMap<>(); // словарь Владелец-массив его машин
    HashMap<Integer, Car> CARID= new HashMap<>();

    public Collection<Owner> allCarsUniqueOwners() {    // все владельци машин
        System.out.println("\n"+"allCarsUniqueOwners");
       for(Owner c:carsOfOwners.keySet()){
          System.out.println("\n"+c.name);
      }
          return carsOfOwners.keySet(); // возвращаем все ключи словаря владельцев

    } // все владельци машин O(1)

    public Collection<Car> topThreeCarsByMaxVelocity() { //  возвращает массив 3 самых быстрых машин
        ArrayList<Car> TopThreeCars = new ArrayList<>();

        TopThreeCars.add(Speed.get(0));
        TopThreeCars.add(Speed.get(1));
        TopThreeCars.add(Speed.get(2));
        System.out.println("\n"+"topThreeCarsByMaxVelocity");
        for(Car c:TopThreeCars){
            System.out.println("\n"+c);
        }
        return TopThreeCars;
    } // возвращает массив 3 самых быстрых машин O(n)

    public Collection<Car> allCarsOfBrand(String brand) {
        System.out.println("\n"+"allCarsOfBrand");
       for(Car c: marca.get(brand)){
           System.out.print("\n"+c);}
        return marca.get(brand); // получение массива машин данной марки по ключу
    } // массив машин данной марки O(1)

    public Collection<Car> allCarsOfOwner(Owner owner) {
        System.out.println("\n"+"allCarsOfOwner");
        for(Car element:carsOfOwners.get(owner)){
            System.out.print("\n"+element);}
        return carsOfOwners.get(owner);


    } // массив машин данного владельца O(1)

    public Collection<Car> carsWithPowerMoreThan(int Power) {
        ArrayList<Car> CarsWithPowerMoreThan = new ArrayList<>();
        ArrayList<Car> CAR = new ArrayList<>();
        for (Car elem : Speed) {
            CAR.add(elem);
        }
        for (Car elemCAR : CAR) {
            if (elemCAR.power > Power) {
                CarsWithPowerMoreThan.add(elemCAR);
            }
        }
        System.out.println("\n"+"carsWithPowerMoreThan");
        for(Car c:CarsWithPowerMoreThan){
            System.out.print("\n"+c);
        }
        return CarsWithPowerMoreThan;


    } // возврящает массив машин с мощностью больше Power O(n)

    public int meanOwnersAgeOfCarBrand(String Brand) { // средний возраст владельцев марки


        ArrayList<Owner> OwnersMean = new ArrayList<>(carsOfOwners.keySet());
        int sumYears = 0;
        int quantityOwnersMarca = 0;
        for (Owner pearson : OwnersMean) {
            int koofmean = 1;
            quantityOwnersMarca += 1;
            for (Car carsPearson : carsOfOwners.get(pearson)) {
                if (carsPearson.brand.equals(Brand)) {
                    sumYears += pearson.age * koofmean;
                    koofmean = 0;
                }
            }


        }
        int MeanOwnersAgeOfCarBrand = sumYears / quantityOwnersMarca;
        System.out.print("\n"+"MeanOwnersAgeOfCarBrand"+MeanOwnersAgeOfCarBrand);
        return MeanOwnersAgeOfCarBrand;
    } //средний возраст владельцев марки O(n)

    @Override
    public int meanCarNumberForEachOwner() {
        return 0;
    }

    public Car removeCar(int carId) {
        Car car = CARID.get(carId); // получение машины по ее Id

        Speed.remove(car); // удаление ее из массива скоростей
        String CarInBrandRemove = car.brand; // получение ее марки
        marca.get(CarInBrandRemove).remove(car); // удаление из словаря марок

        for (Owner ownerCarRemove : carsOfOwners.keySet()) {
            carsOfOwners.get(ownerCarRemove).remove(car);
        }  // удаление машины из словаря Владельцев
        CARID.remove(carId); // удаление машины из словаря айди
        System.out.print("\n"+"removeCar"+car);
        return car;
    } // удаление машины из гаража O(n)

    public void addNewCar(Car car, Owner owner) {

        if (!(carsOfOwners.keySet().contains(owner))) { //проверка существования владельца машины в базе данных гаража

            ArrayList<Car> CarAddcarsOfOwners = new ArrayList<>();
            CarAddcarsOfOwners.add(car);

            carsOfOwners.put(owner, CarAddcarsOfOwners); // добавление ключа и его значения в словарь Владелец-Машины

        } else{ carsOfOwners.get(owner).add(car);    }

     //   if (carsOfOwners.keySet().contains(owner)) {
      //      carsOfOwners.get(owner).add(car);
       // } // если у машины есть владелец добавляем ее в базу данных машин владельца


        if (marca.keySet().contains(car.brand)) { // работа со словарем марок
            marca.get(car.brand).add(car);
        } else{       ArrayList<Car> marcaAddCar = new ArrayList<>();
            marcaAddCar.add(car);
            marca.put(car.brand, marcaAddCar);                                                            }

        //if (!((carsOfOwners.keySet().contains(owner)))) {
        //    ArrayList<Car> marcaAddCar = new ArrayList<>();
        //    marcaAddCar.add(car);
         //   marca.put(car.brand, marcaAddCar);
      //  }

        CARID.put(car.carId, car);

        int speedAddCar = car.maxVelocity;
        var iter = 0;
        while (iter < Speed.size() && Speed.get(iter).maxVelocity> speedAddCar) {
            iter += 1;
        }
        Speed.add(iter,car);

    }// добавление машины в гараж O(n)


}
   /* public Collection<Owner> allCarsUniqueOwners() {
        ArrayList<Owner> UniqueOwners = new ArrayList<>();
        for (Car CAR : car.values()) {
            Owner ow = owners.get(CAR.ownerId);
            if (!(UniqueOwners.contains(ow))) {
                UniqueOwners.add(ow);
            }
        }
        return UniqueOwners;
    }

    public Collection<Car> allCarsOfBrand(String brand) {
        ArrayList<Car> BrendMassive = new ArrayList<>();
        for (Car CAR : car.values()) {
            if (CAR.brand.equals(brand)) {
                BrendMassive.add(CAR);
            }

        }
        return BrendMassive;

    }

    public int meanOwnersAgeOfCarBrand(String brand){

            ArrayList<Owner> UniqueOwners = new ArrayList<>();
        int sumyears=0; int kYears=0;
            for (Car CAR : car.values()) {
                Owner ow = owners.get(CAR.ownerId);
                if (!(UniqueOwners.contains(ow))) {
                    kYears+=1;
                    sumyears+=owners.get(ow).age;

                }

            }
            return sumyears/kYears;
        }


    */



















