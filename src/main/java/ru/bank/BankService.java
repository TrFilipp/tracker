package ru.bank;

import java.util.*;

/**
 *
 */
public class BankService {
    /**
     *
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     *
     * @param passport
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     *
     * @param passport
     * @param account
     */
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

    /**
     *
     * @param passport
     * @return
     */
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

    /**
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     *
     * @param sourcePassport
     * @param sourceRequisite
     * @param destinationPassport
     * @param destinationRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport,
                                 String destinationRequisite, double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null) {
            return result;
        } else {
            double sourceBalance = sourceAccount.getBalance();
            double destinationBalance = destinationAccount.getBalance();
            if (sourceBalance >= amount) {
                sourceAccount.setBalance(sourceBalance -= amount);
                destinationAccount.setBalance(destinationBalance += amount);
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @param user
     * @return
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
