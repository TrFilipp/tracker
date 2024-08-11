package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book romane = new Book("Ромео и Джульета", 400);
        Book horror = new Book("Оно", 350);
        Book comedy = new Book("Недоросль", 231);
        Book cleanCode = new Book("Clean code", 111);
        Book[] library = new Book[4];
        library[0] = romane;
        library[1] = horror;
        library[2] = comedy;
        library[3] = cleanCode;
        for (int i = 0; i < library.length; i++) {
            Book book = library[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Replace book romance and Clean code");
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (int i = 0; i < library.length; i++) {
            Book book = library[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Show only book with name Clean code");
        for (int i = 0; i < library.length; i++) {
            Book book = library[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
