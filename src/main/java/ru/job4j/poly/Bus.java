package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Bus go.");
    }

    @Override
    public void passengers(int numbers) {
        System.out.println("Количество пассажиров: " + numbers);
    }

    @Override
    public double refuel(int fuelQuantity) {
        return 50.65 * fuelQuantity;
    }
}
