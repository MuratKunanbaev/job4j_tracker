package ru.job4j.ex;

import com.sun.source.tree.IfTree;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException  {
        User userFound = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                userFound = users[i];
                break;
            }
        }
        if (userFound == null) {
            throw new UserNotFoundException("User Not Found");
        }
        return userFound;
    }

    public static boolean validate(User user) throws UserInvalidException{
        boolean rsl = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            rsl = false;
        }
        if (!rsl) {
            throw new UserInvalidException("User not valid or his name is less than 3 symbols");
        }
        return rsl;
    }

    public static void main(String[] args)  {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Murat Kunanbaev", false),
                new  User("Va", true)
        };
        try {
            User user = findUser(users, "Va");
            validate(user);

        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException ne) {
            ne.printStackTrace();
        }
    }
}
