package controller;

import model.Account;
import utils.MD5Encryption;

import java.util.ArrayList;

public class AccountController {

    private ArrayList<Account> list =
            new ArrayList<>();

    // add account
    public void addAccount(Account account) {

        account.setPassword(
                MD5Encryption.encrypt(
                        account.getPassword()));

        list.add(account);
    }

    // login
    public boolean login(String username,
                         String password) {

        for (Account acc : list) {

            if (acc.getUsername()
                    .equalsIgnoreCase(username)
                    &&
                acc.getPassword()
                    .equals(
                        MD5Encryption.encrypt(password))) {

                return true;
            }
        }

        return false;
    }

    // check username
    public boolean isExistUsername(String username) {

        for (Account acc : list) {

            if (acc.getUsername()
                    .equalsIgnoreCase(username)) {

                return true;
            }
        }

        return false;
    }

    public ArrayList<Account> getList() {
        return list;
    }
}