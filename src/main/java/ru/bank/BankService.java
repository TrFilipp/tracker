package ru.bank;

import ru.bank.Account;
import ru.bank.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {}

    public void deleteUser(String passport) {}

    public void addAccount(String passport, Account account) {}

    public User findByPassport(String passport) {
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport,
                                 String destinationRequisite, double amount) {
        boolean result = false;
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
