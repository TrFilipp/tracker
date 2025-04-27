package ru.bank;

import java.util.Objects;

/**
 * Класс описывает работу юзера с пасспортными данными и ФИО юзера
 * @author trishin_f
 * @version 1.0
 */
public class User {
    /**
     * Строки юзера, хранящие данные паспорта и ФИО юзера
     */
    private String passport;
    private String username;

    /**
     * Конструктор. Определяет параметры объекта User
     * @param passport паспортные данные юзера
     * @param username ФИО изера
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает паспортные данные юзера
     * @return Возвращает паспортные данные user
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод записывает паспортные данные в user
     * @param passport строка паспортных данных
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает ФИО user
     * @return возвращает ФИО user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод записывает ФИО user
     * @param username ФИО user
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода
     * @return возвращает хэш объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
