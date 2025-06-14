package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка, с номером и серией паспорта так же Фамилию и Имя.
 * Используется для идентификации клиента по номеру и серии паспорта.
 */
public class User {
    /**
     * номер серия паспорта.
     */
    private String passport;
    /**
     * Имя и Фамилия клиента.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Строгое сравнение текущего с другими обьектами по сериии и номеру паспорта.
     * @param o Обьект для сравнения
     * @return true, если объекты одного класса и паспорта равны; иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Вычесляет has обьекта (номер и серию паспорта).
     * @return хэш-код обьекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
