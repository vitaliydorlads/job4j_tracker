package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет главный сервис для управления клиентами банка и их счетами.
 * Добавление и удаление пользователей по номеру и серии паспорта.
 * Привязка счетов к пользователю.
 * Поиск пользователя и счета по паспортным данным и реквизитам.
 * Перевод средств между счетами.
 * Получение всех счетов пользователя.
 *
 * @author Vitaliy
 * @version 1.0
 */
public class BankService {
    /**
     * База данных пользователей с использованием HashMap для быстрого поиска по ключу (паспортные данные).
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в список клиентов банка.
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет пользователя из списка по номеру и сериии паспорта.
     *
     * @param passport серия и номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет учетную запись (счёт) пользователю с указанным паспортом.
     *
     * @param passport серия и номер паспорта
     * @param account  счёт
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру и серии паспорта.
     *
     * @param passport паспортные данные для поиска
     * @return User если ключ найден(номер и серия паспрота); иначе null
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Ищет учетную запись (счет) по номеру и серии паспорта пользователя и номеру счета (requisite).
     * * @param passport серия и номер паспорта пользователя
     * * @param requisite номер учетной записи (счета)
     * * @return объект Account, если счет найден; иначе null
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Перевод с одного счета на другой, по номеру и серии паспорта и номеру счетов.
     *
     * @param sourcePassport       номер и серия паспорта
     * @param sourceRequisite      номер счета с которого переводят
     * @param destinationPassport  номер и серия паспорта
     * @param destinationRequisite номер счет на который переводят
     * @param amount               сумма перевода
     * @return true если номер счет с которого переводят найдет и на нём достаточно средств; иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport, String
            destinationRequisite, double amount) {
        boolean result = false;

        Account requisite = findByRequisite(sourcePassport, sourceRequisite);

        Account destRequisite = findByRequisite(destinationPassport, destinationRequisite);
        if (requisite != null && destRequisite != null && requisite.getBalance() >= amount) {
            requisite.setBalance(requisite.getBalance() - amount);
            destRequisite.setBalance(destRequisite.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Ищет пользователя по ключу и возвращает его если такой есть в базе.
     *
     * @param user Объект
     * @return Возврат объекта
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
