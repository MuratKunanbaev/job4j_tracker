package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банковского сервиса,
 * по добавлению, поиску пользователей а так же их счетов.
 * @author Murat Kunanbaev
 * @version 1.0
 */
public class BankService {
    /**
     *Хранение пользователей системы с привязанными к ним счетам
     * осуществляется в коллекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему,
     * если такого пользователя еще нет в системе.
     * В качестве списка счетов пользователя метод добавляет пустой список ArrayList
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю, находя пользователя
     * по паспорту с помощью метода findByPassport().
     * В методе осуществляется проверка, что такого счета у пользователя нет.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> usersAccount = users.get(user);
            if (!usersAccount.contains(account)) {
                usersAccount.add(account);
            }
        }
    }

    /**
     * Метод производит поиск пользователя по паспорту.
     * @param passport
     * @return возвращает наиденного пользователя или null, если такой пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Изначально метод производит поиск пользователя по паспорту,
     * затем получает список счетов пользователя.
     * @param passport
     * @param requisite
     * @return возвращает найденный счет пользователя или null если он отсутствует.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перечисление денежных средств
     * с одного счета пользователя на другой.
     * Первоначально метод производит поиск счетов пользователя используя метод findByRequisite().
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return возвращает true если перевод денег был осуществлен
     * и false если счет не найден или не хвает средств на счете.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account userSrcAccount = findByRequisite(srcPassport, srcRequisite);
        Account userDestAccount = findByRequisite(destPassport, destRequisite);
        if (userSrcAccount != null && userDestAccount != null
                && userSrcAccount.getBalance() >= amount) {
            userSrcAccount.setBalance(userSrcAccount.getBalance() - amount);
            userDestAccount.setBalance(userDestAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
