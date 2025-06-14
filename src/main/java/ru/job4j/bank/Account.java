package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает учетную запись клиента (счет).
 * Содержит номер счета (requisite) и текущий баланс.
 */
public class Account {
    /**
     * Счет клиента
     */
    private String requisite;
    /**
     * Баланс денежных средств на счете.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнение текущего обьекта к сдругими по номеру счета.
     * @param o обьект для сравнения
     * @return true если обьеты одного класса и номера счетов совпадают, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Вычисляет хэш на основе номера счета
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
