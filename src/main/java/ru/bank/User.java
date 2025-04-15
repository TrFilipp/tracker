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
     * @param passport пасспортные данные юзера
     * @param username ФИО изера
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает паспортные данные юзера
     * @return
     */
    public String getPassport() {
        return passport;
    }

    /**
     *
     * @param passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает ФИО юзеру
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод записывает ФИО юзеру
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
