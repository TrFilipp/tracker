package ru.cast;

public class AllVenicles {
    public static void main(String[] args) {
        Venicle airplane = new Airplane();
        Venicle booing = new Airplane();
        Venicle train = new Train();
        Venicle speedTrain = new Train();
        Venicle bus = new Bus();
        Venicle car = new Bus();

        Venicle[] venicles = new Venicle[]{airplane, speedTrain, train, car, bus, booing};
        for (Venicle v: venicles) {
            v.move();
            v.speed();
        }
    }
}
