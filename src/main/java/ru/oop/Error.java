package ru.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printMessageError() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message " + message);
    }

    public static void main(String[] args) {
        Error errorWithData = new Error(true, 1, "Allready");
        errorWithData.printMessageError();
        Error errorDefault = new Error();
        errorDefault.printMessageError();
    }
}
