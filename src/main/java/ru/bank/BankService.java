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
        if (findByRequisite(sourcePassport, sourceRequisite) == null || findByRequisite(destinationPassport, destinationRequisite) == null) {
            return result;
        }
        double balanceOne = findByRequisite(sourcePassport, sourceRequisite).getBalance();
        double balanceTwo = findByRequisite(destinationPassport, destinationRequisite).getBalance();
        if (balanceOne >= amount) {
            balanceOne -= amount;
            balanceTwo += amount;
            findByRequisite(sourcePassport, sourceRequisite).setBalance(balanceOne);
            findByRequisite(destinationPassport, destinationRequisite).setBalance(balanceTwo);
            result = true;
        } else {
            return result;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

    public static void main(String[] args) {
        User user = new User("321", "Ivan");
        BankService bank = new BankService();
        bank.addUser(user);
        Account account = new Account("123", 15D);
        bank.addAccount(user.getPassport(), account);
        Account find = bank.findByRequisite(user.getPassport(), account.getRequisite());
        System.out.println(find.getRequisite() + " + " + find.getBalance());
    }
}
