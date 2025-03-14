package ru.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
            users.put(user, accountList);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
               rsl = user;
               break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user == null) {
            return rsl;
        }
        for (Account account: users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                rsl = account;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport,
                                 String destinationRequisite, double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source == null || destination == null) {
            return result;
        }
        double sorceBalance = source.getBalance();
        double destinationBalance = destination.getBalance();
        if (sorceBalance >= amount) {
            source.setBalance(sorceBalance -= amount);
            destination.setBalance(destinationBalance += amount);
            result = true;
        } else {
            return result;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
