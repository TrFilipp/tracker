package ru.bank;

import java.util.Objects;

/**
 * Класс описывает будущие объекты в виде аккаунтов
 * @author trishin_f
 * @version 1.0
 */
public class Account {
    /**
     * Строка реквизиты и числовое значание баланса аккаунта
     */
    private String requisite;
    private double balance;

    /**
     * Определение принимаемых параметров аккаунта
     * @param requisite строка реквизита аккаунта
     * @param balance числовое значение баланса аккаунта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты из аккаунта
     * @return возвращает строку аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод записывает строку в поле requisite аккаунту
     * @param requisite строка реквизита аккаунта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает числовое значения аккаунта
     * @return Получение числового значения аккаунта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод записывает баланс в аккаунт
     * @param balance числовое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода для сравнения объектов
     * @param o объект сравнения
     * @return возвращает истину или ложь при сравнении объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода
     * @return возвращает хэш объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
