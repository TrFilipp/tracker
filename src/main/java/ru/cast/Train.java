package ru.cast;

public class Train implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " двигается по рельсам.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " двигается со скоростью 150 км/ч.");
    }
}
