package ru.cast;

public class Airplane implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " двигается по воздуху.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " летит со скоростью 200 км/ч.");
    }
}
