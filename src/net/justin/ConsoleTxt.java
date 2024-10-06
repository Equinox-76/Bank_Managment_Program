package net.justin;

import java.util.ArrayList;

public class ConsoleTxt {

    public static void printMainMenu() {
        System.out.println("=========================================");
        System.out.println("|            BANK MANAGEMENT             |");
        System.out.println("=========================================");
        System.out.println("|    Welcome to The Bank System!         |");
        System.out.println("|                                        |");
        System.out.println("|  Type one of the following commands:   |");
        System.out.println("|                                        |");
        System.out.println("|  'ad'  - Add Account                   |");
        System.out.println("|  'acs' - Access Account                |");
        System.out.println("|  'pal' - Print Accounts List           |");
        System.out.println("|  'END' - Exit System                   |");
        System.out.println("=========================================");
    }

    public static void printAccessMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=========================================");
        System.out.println("|             ACCESS MENU                |");
        System.out.println("=========================================");
        System.out.println("|  Type one of the following commands:   |");
        System.out.println("|                                        |");
        System.out.println("|  'dep'  - Deposit                      |");
        System.out.println("|  'wit' - Withdrawal                    |");
        System.out.println("|  '$' - Get Account Balance             |");
        System.out.println("|  'n' - Get Account Name                |");
        System.out.println("|  'h' - Get Account transaction History |");
        System.out.println("|  'r' - Return to Main Menu             |");
        System.out.println("=========================================");
    }

    public static void printAccountsAndIndex(ArrayList<Bank> accounts) {
        System.out.println();
        System.out.println("=========================================");
        System.out.println("|            ACCOUNTS LIST               |");
        System.out.println("=========================================");

        for (int i = 0; i < accounts.size(); i++) {
            Bank account = accounts.get(i);
            System.out.println("[" + i + "] " + account.name + " -> $ " + account.balance);

        }
        System.out.println("=========================================");

    }

    public static void printAccountsList(ArrayList<Bank> accounts) {
        System.out.println("=========================================");
        System.out.println("|            ACCOUNTS LIST               |");
        System.out.println("=========================================");

        for (int i = 0; i < accounts.size(); i++) {
            Bank account = accounts.get(i);
            System.out.println("- " + account.name + " -> $ " + account.balance);

        }
        System.out.println("=========================================");
        System.out.println();
    }
}
