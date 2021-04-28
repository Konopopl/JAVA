package main.java.com.company;

import java.util.*;

public class GarageImpl implements Garage {
    private final NavigableSet<Car> powerCar = new TreeSet<>(new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.getPower(), o2.getPower());
        }
    });
    private final NavigableSet<Car> velocityMaxCars = new TreeSet<>(new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.getMaxVelocity(), o2.getMaxVelocity());
        }
    });
    private final Map<Integer, Car> IdOfCar = new HashMap<>();
    private final Map<Integer, Owner> IdOfOwner = new HashMap<>();
    private final Map<Owner, Set<Car>> ownerOfSetCar = new HashMap<>();
    private final Map<String, Set<Car>> brandOfSetCar = new HashMap<>();

    @Override
    public Collection<Owner> allCarsUniqueOwners() { // все владельци машин O(1)
        return ownerOfSetCar.keySet();
    }

    @Override
    public Collection<Car> topThreeCarsByMaxVelocity() {//возвращает массив 3 самых быстрых машин O(1)
        Collection<Car> threeCarsByMaxVelocity = new LinkedList<Car>();
        if (velocityMaxCars.size() <= 3) {
            for (Car c : velocityMaxCars) {
                threeCarsByMaxVelocity.add(c);
            }
        }
        Iterator iterator = velocityMaxCars.descendingIterator();//сначала самые быстрые O(n)
        for (int i = 0; i < 3; i++) {
            threeCarsByMaxVelocity.add((Car) iterator.next());
        }
        System.out.println("topThreeCarsByMaxVelocity  ");
        for (Car c : threeCarsByMaxVelocity) {
            System.out.print(c);
        }
        return threeCarsByMaxVelocity;
    }

    @Override
    public Collection<Car> allCarsOfBrand(String brand) {//все машины заданого бренда O(1)
        System.out.println("allCarsOfBrand  ");
        for (Car c : brandOfSetCar.get(brand)) {
            System.out.println(c);
        }
        return brandOfSetCar.get(brand);
    }

    @Override
    public Collection<Car> carsWithPowerMoreThan(int power) {//массив машин мощность больше power O(n)
        System.out.println("carsWithPowerMoreThan  ");
        Collection<Car> allCarWithPowerGreaterThanThePower = new LinkedList<Car>();
        for (Car c : powerCar) {
            if (c.getPower() > power) {
                allCarWithPowerGreaterThanThePower.add(c);
            }
        }
        return allCarWithPowerGreaterThanThePower;
    }

    @Override
    public Collection<Car> allCarsOfOwner(Owner owner) {// массив машин владельца (1)
        System.out.print(ownerOfSetCar.get(owner));
        return ownerOfSetCar.get(owner);
    }

    @Override
    public int meanOwnersAgeOfCarBrand(String Brand) { // средний возраст владельцев марки
        ArrayList<Owner> OwnersMean = new ArrayList<>(ownerOfSetCar.keySet());
        int sumYears = 0;
        int quantityOwnersMarca = 0;
        for (Owner pearson : OwnersMean) {
            int koofmean = 1;
            for (Car carsPearson : ownerOfSetCar.get(pearson)) {
                if (carsPearson.brand.equals(Brand)) {
                    sumYears += pearson.age * koofmean;
                    quantityOwnersMarca += 1 * koofmean;
                    koofmean = 0;
                }
            }
        }
        int MeanOwnersAgeOfCarBrand = sumYears / quantityOwnersMarca;
        System.out.print("\n" + "MeanOwnersAgeOfCarBrand:  " + MeanOwnersAgeOfCarBrand+"   ");
        return MeanOwnersAgeOfCarBrand;
    } //средний возраст владельцев марки O(n)

    @Override
    public int meanCarNumberForEachOwner() {// средний номер автомобиля для владельца O(1)
        System.out.println("meanCarNumberForEachOwner: " + IdOfCar.size() / IdOfOwner.size());
        return IdOfCar.size() / IdOfOwner.size();
    }

    @Override
    public Car removeCar(int carId) {//удаление машины из гаража O(log(n))
        if (!IdOfCar.containsKey(carId)) {
            throw new IllegalArgumentException("ERROR,there is no such car in the garage ");
        }
        Car car = IdOfCar.get(carId);
        IdOfCar.remove(carId);
        powerCar.remove(car);
        velocityMaxCars.remove(car);
        ownerOfSetCar.get(IdOfOwner.get(car.getOwnerId())).remove(car);
        brandOfSetCar.get(car.getBrand()).remove(car);
        return car;
    }

    @Override
    public void addNewCar(Car car, Owner owner) {// добавление машины в гараж O(log(n))
        if (IdOfCar.containsKey(car.getCarId())) {
            throw new IllegalArgumentException("ERROR, unfortunately, such a car is already in the garage");
        }
        if (car.getOwnerId() != owner.getId()) {
            throw new IllegalArgumentException("ERROR, the connection between the machine and the owner is lost");
        }
        powerCar.add(car);
        velocityMaxCars.add(car);
        IdOfCar.put(car.getCarId(), car);
        IdOfOwner.put(owner.getId(), owner);
        ownerOfSetCar.putIfAbsent(owner, new TreeSet<>(Comparator.comparing(Car::getCarId)));
        ownerOfSetCar.get(owner).add(car);
        brandOfSetCar.putIfAbsent(car.getBrand(), new TreeSet<>(Comparator.comparing(Car::getCarId)));
        brandOfSetCar.get(car.getBrand()).add(car);
    }
}
