package ru.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (login.equals(user.getUsername())) {
                rsl = users[i];
                break;
            }
        }
        if (!rsl.isValid()) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        String username = user.getUsername();
        if (!user.isValid() && username.length() < 3) {
            throw new UserInvalidException("User not validate");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", false)
        };
        try {
            User user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException i) {
            i.printStackTrace();
        } catch (UserNotFoundException nf) {
            nf.printStackTrace();
        }
    }
}
