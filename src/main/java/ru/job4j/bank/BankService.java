package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if(user != null) {
            List<Account> usersAccount = users.get(user);
            if (!usersAccount.contains(account)) {
                usersAccount.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (user.passport.equals(passport)){
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account userSrcAccount = findByRequisite(srcPassport, srcRequisite);
        Account userDestAccount = findByRequisite(destPassport, destRequisite);
        if (userSrcAccount != null && userDestAccount != null && userSrcAccount.getBalance() >= amount) {
            userSrcAccount.setBalance(userSrcAccount.getBalance() - amount);
            userDestAccount.setBalance(userDestAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
