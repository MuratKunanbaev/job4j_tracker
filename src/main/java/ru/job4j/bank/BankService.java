package ru.job4j.bank;

import java.util.*;

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
    private final Map<User, List<Account>> users = new HashMap<>();

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> usersAccount = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
         return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Изначально метод производит
     * пользователя по паспорту,
     * затем получает список счетов пользователя.
     * @param passport
     * @param requisite
     * @return возвращает найденный счет пользователя или null если он отсутствует.
     */
   public Optional<Account> findByRequisite(String passport, String requisite) {
       Optional<Account> rsl = Optional.empty();
       Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
             rsl = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> userSrcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> userDestAccount = findByRequisite(destPassport, destRequisite);
        if (userSrcAccount != null && userDestAccount != null
                && userSrcAccount.get().getBalance() >= amount) {
            userSrcAccount.get().setBalance(userSrcAccount.get().getBalance() - amount);
            userDestAccount.get().setBalance(userDestAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
   Map<User, List<Account>> users = new HashMap<>();
        Optional<User> user = Optional.of(new User("3434", "Petr Arsentev"));
        BankService bank = new BankService();
        bank.addUser(user.get());
        System.out.println(users);
        bank.addAccount(user.get().getPassport(), new Account("5546", 150D));
        Optional<Account> opt = bank.findByRequisite("34", "5546");
    }
}
