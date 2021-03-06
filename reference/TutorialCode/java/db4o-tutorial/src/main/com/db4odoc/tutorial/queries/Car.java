package com.db4odoc.tutorial.queries;

// #example: Domain model for cars
public class Car {
    private String carName;
    private int horsePower;

    public Car(String carName, int horsePower) {
        this.carName = carName;
        this.horsePower = horsePower;
    }

    public String getCarName() {
        return carName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}
// #end example

