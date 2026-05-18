package view;

import controller.AccountController;
import model.Account;
import utils.Validation;

import java.util.Scanner;

public class AccountView {

    private Scanner sc = new Scanner(System.in);

    private AccountController controller;

    public AccountView(AccountController controller) {

        this.controller = controller;
    }

    // menu
    public void displayMenu() {

        while (true) {

            System.out.println("1. Add Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addAccount();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // add account
    public void addAccount() {

        Account account = inputAccount();

        if (account == null) {
            return;
        }

        controller.addAccount(account);

        System.out.println("Add success");
    }

    // nhập account
    public Account inputAccount() {

        System.out.print("Username: ");
        String username = sc.nextLine();

        if (controller.isExistUsername(username)) {

            System.out.println("Username existed");

            return null;
        }

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        if (!Validation.isValidPhone(phone)) {

            System.out.println("Invalid phone");

            return null;
        }

        System.out.print("Email: ");
        String email = sc.nextLine();

        if (!Validation.isValidEmail(email)) {

            System.out.println("Invalid email");

            return null;
        }

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("DOB(dd/mm/yyyy): ");
        String dob = sc.nextLine();

        if (!Validation.isValidDate(dob)) {

            System.out.println("Invalid date");

            return null;
        }

        return new Account(
                username,
                password,
                name,
                phone,
                email,
                address,
                dob
        );
    }

    // login
    public void login() {

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        boolean check =
                controller.login(username, password);

        if (check) {

            System.out.println("Login success");

        } else {

            System.out.println("Login fail");
        }
    }
}