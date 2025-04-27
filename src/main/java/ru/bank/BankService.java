package ru.bank;

import java.util.*;

/**
 * Класс реализует методы работы с объектом account и user
 * @author trishin_f
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция ключ-значение. К каждому user привязаны разные аккаунты.
     * User - ключ. Список accounts - значения ключа
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового user в систему.
     * @param user объект User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод реализует удаление user по паспортным данным.
     * Поиск по паспорту реализовано в методе findByPassport
     * @param passport паспортные данные user
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Метод добавляет к user аккаунт.
     * Идёт поиск user по полю passport через метод findByPassport
     * Если user не пустой, реализуется алгоритм добавления.
     * Если в списке accountList отсутствует account, то добавляет новый через объект account.
     * В коллекцию users обновляется значение ключа user
     * @param passport паспортные данные user для нахождения объекта
     * @param account объект добавления в объект user
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
     * Метод возвращает объект user.
     * Если в системе не находит данного user, возвращает null
     * @param passport паспортные данные для нахождения объекта user
     * @return Возвращает user
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
     * Метод возвращает объект account через поиск по requisite
     * Если в системе нет account, возвращает null
     * @param passport  паспортные данные для нахождения объекта user
     * @param requisite реквизиты account для сравнения и нахождения в системе
     * @return Возвращает объект account
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
     * Метод реализует трансфер денежного баланса с одного account на другой.
     * Идёт проверка на наличие accounts в системе и если не находит, возвращает false.
     * При нахождении accounts реализуется обмен. Перед этим проверка на достаточного количества средств в объекте sourceAccount
     * @param sourcePassport паспортные данные объекта account, откуда будут списывать денежные средства
     * @param sourceRequisite реквизиты объекта account, откуда будут списывать денежные средства
     * @param destinationPassport паспортные данные объекта account, куда будут переводить денежные средства
     * @param destinationRequisite реквизиты объекта account, куда будут переводить денежные средства
     * @param amount сумма перевода денежных средств
     * @return Возвращает статус перевода
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
     * Метод возвращает список accounts объекта user
     * @param user объект user с accounts
     * @return возвращает список accounts объекта user
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
