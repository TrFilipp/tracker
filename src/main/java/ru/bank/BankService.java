package ru.bank;

import ru.bank.Account;
import ru.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        users.put(findByPassport(passport), accounts);
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
               rsl = user;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        for (Account account: users.get(findByPassport(passport))) {
            if (account.getRequisite().equals(requisite)) {
                rsl = account;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport,
                                 String destinationRequisite, double amount) {
        boolean result = false;
        Account accountOne = findByRequisite(sourcePassport, sourceRequisite);
        Account accountTwo = findByRequisite(destinationPassport, destinationRequisite);
        double accountBalanceOne = accountOne.getBalance();
        double accountBalanceTwo = accountTwo.getBalance();
        if (accountBalanceOne >= amount) {
            accountBalanceOne -= amount;
            accountBalanceTwo += amount;
            accountOne.setBalance(accountBalanceOne);
            accountTwo.setBalance(accountBalanceTwo);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
