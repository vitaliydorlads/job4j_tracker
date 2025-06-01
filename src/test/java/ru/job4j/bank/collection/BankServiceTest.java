package ru.job4j.bank.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.BankService;
import ru.job4j.bank.User;

import static org.assertj.core.api.Assertions.*;

class BankServiceTest {

    @Test
    void addUser() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434")).isEqualTo(user);
    }

    @Test
    void deleteUserIsTrue() {
        ru.job4j.bank.User first = new ru.job4j.bank.User("3434", "Petr Arsentev");
        ru.job4j.bank.User second = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.deleteUser("3434");
        assertThat(bank.findByPassport(first.getPassport())).isNull();
    }

    @Test
    void deleteUserIsFalse() {
        ru.job4j.bank.User first = new ru.job4j.bank.User("3434", "Petr Arsentev");
        ru.job4j.bank.User second = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        bank.deleteUser("343434");
        assertThat(bank.findByPassport(first.getPassport())).isEqualTo(first);
    }

    @Test
    void whenEnterInvalidPassport() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546")).isNull();
    }

    @Test
    void addAccount() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void addAccountIsInvalid() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount("4343", new ru.job4j.bank.Account("5546", 150D));
        assertThat(bank.getAccounts(user)).isEmpty();
    }

    @Test
    void addDuplicateAccount() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 500D));
        assertThat(bank.getAccounts(user).size()).isEqualTo(1);
    }

    @Test
    void transferMoneyOk() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "5546",
                user.getPassport(), "113", 150D);
        assertThat(result).isTrue();
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(200D);
    }

    @Test
    void transferMoneyOkCheckSourceAccount() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(0D);
    }

    @Test
    void transferMoneySourceNull() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "554",
                user.getPassport(), "113", 150D);
        assertThat(result).isFalse();
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void transferMoneyDontHaveEnoughMoney() {
        ru.job4j.bank.User user = new ru.job4j.bank.User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 300D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(50D);
    }

    @Test
    void transferMoneyDestinationIsNull() {
        ru.job4j.bank.User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new ru.job4j.bank.Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1131", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }
}