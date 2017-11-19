package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length()<3 || password.length()<8) {
            return true;
        }
        
        Pattern regex = Pattern.compile("(?=.*[0-9])(?=.*[@#$%^&+=])");
        Matcher regexMatcher = regex.matcher(password);
        if (!regexMatcher.matches()) {
            return true;
        }
        System.out.println("moi");
//        if (if (password.contains(password)))
        
        // validity check of username and password

        return false;
    }
}