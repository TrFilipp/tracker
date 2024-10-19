package ru.cast;

public class Bus implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " двигается по скоростным трассам.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " двигается со скоростью 100 км/ч.");
    }
}
