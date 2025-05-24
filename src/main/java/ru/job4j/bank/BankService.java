package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts != null) {
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts != null) {
                for (Account account : accounts) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport, String
            destinationRequisite, double amount) {
        boolean result = false;
        User user = findByPassport(sourcePassport);
        Account requisite = findByRequisite(sourcePassport, sourceRequisite);
        User destUser = findByPassport(destinationPassport);
        Account destRequisite = findByRequisite(destinationPassport, destinationRequisite);
        if (user != null && requisite != null && destUser != null && destRequisite != null) {
            if (user.getPassport().equals(sourcePassport) && requisite.getRequisite().equals(sourceRequisite) && requisite.getBalance() >= amount) {
                requisite.setBalance(requisite.getBalance() - amount);
                destRequisite.setBalance(destRequisite.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
