package ru.poly;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Машина двигается");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("Количество пассажиров в транспорте: " + passenger);
    }

    @Override
    public float fill(float oil) {
        float cash = 5.56f;
        return cash * oil;
    }
}
