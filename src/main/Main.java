package main;

import controller.AccountController;
import view.AccountView;

public class Main {

    public static void main(String[] args) {

        AccountController controller =
                new AccountController();

        AccountView view =
                new AccountView(controller);

        view.displayMenu();
    }
}