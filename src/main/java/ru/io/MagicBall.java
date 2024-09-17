package ru.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 1: {
                System.out.println("Нет");
                break;
            }
            case 0: {
                System.out.println("Да");
                break;
            }
            default: {
                System.out.println("Может быть");
            }
        }
    }
}
