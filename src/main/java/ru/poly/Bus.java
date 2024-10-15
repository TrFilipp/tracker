package ru.poly;

public class Bus implements Transport {

    @Override
    public void move() {

    }

    @Override
    public void passengers(int passenger) {

    }

    @Override
    public float fill(float oil) {
        float cash = 5.56f;
        return cash * oil;
    }
}
