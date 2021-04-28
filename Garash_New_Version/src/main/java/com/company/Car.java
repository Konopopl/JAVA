package main.java.com.company;

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

    public Car(int carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {
        this.carId = carId;
        this.brand = brand;
        this.modelName= modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }
    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public int getPower() {
        return power;
    }

    public int getOwnerId() {
        return ownerId;
    }

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

