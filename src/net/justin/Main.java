package net.justin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Bank> accounts = new ArrayList<>();
        accounts.add(new Bank("Justin", 34));

        ConsoleTxt.printMainMenu();


        mainLoop: while(true) {

            System.out.println(">>> ");
            String mainCommand = scanner.next();

            switch (mainCommand) {
                case "ad" -> {

                    while(true) {
                        System.out.println(">>> ~/ad");
                        System.out.println("[name]: ");
                        String input1 = scanner.next();

                        System.out.println("[balance]: ");
                        double input2 = scanner.nextDouble();

                        accounts.add(new Bank(input1, input2));

                        ConsoleTxt.printAccountsList(accounts);

                        System.out.println("Add another account? [y/n]: ");
                        String addAccount = scanner.next();

                        if (addAccount.equals("y")) continue;
                        else break;
                    }
                }
                case "acs" -> {
                    acsLoop: while (true) {
                        ConsoleTxt.printAccountsAndIndex(accounts);

                        System.out.println(">>> ~/acs [userIndex]");
                        int userIndex = scanner.nextInt();

                        if (userIndex < accounts.size() && userIndex >= 0) {
                            ConsoleTxt.printAccessMenu();


                            while (true) {
                                System.out.println(accounts.get(userIndex).name + " >>> ~/acs");
                                String acsCommand = scanner.next();

                                double balance;

                                switch (acsCommand) {
                                    case "dep" -> {
                                        while(true) {
                                            System.out.println(accounts.get(userIndex).name + " >>> ~/acs/deposit [$]");
                                            double accessInput = scanner.nextDouble();

                                            if(accessInput > 0) {
                                                balance = accounts.get(userIndex).balance + accessInput;
                                                accounts.set(userIndex, new Bank(accounts.get(userIndex).name, balance));

                                                System.out.println("New balance: " + balance);
                                                break;
                                            } else {
                                                System.out.println("Invalid amount. Try again.");
                                            }
                                        }

                                    }
                                    case "wit" -> {
                                        while(true) {
                                            System.out.println(accounts.get(userIndex).name + " >>> ~/acs/withdrawal [$] ");
                                            double accessInput = scanner.nextDouble();

                                            if(accessInput > 0) {
                                                balance = accounts.get(userIndex).balance - accessInput;
                                                accounts.set(userIndex, new Bank(accounts.get(userIndex).name, balance));

                                                System.out.println("New balance: " + balance);
                                                break;
                                            } else {
                                                System.out.println("Invalid amount. Try again.");
                                            }
                                        }


                                    }
                                    case "$" -> System.out.println("Balance: " + accounts.get(userIndex).balance);
                                    case "n" -> System.out.println("Bank: " + accounts.get(userIndex).name);
                                    case "r" -> {
                                        break acsLoop;
                                    }
                                    default -> System.out.println("Command not recognized. Try again.");
                                }

                            }
                        } else {
                            System.out.println("There is no account under index[" + userIndex + "]. Try again.");
                            break;
                        }
                    }
                }
                case "pal" -> ConsoleTxt.printAccountsList(accounts);
                case "END" -> {
                    System.out.println("Are you sure you want to exit the program? All info will be lost. [YES/n]");
                    String inputEnd = scanner.next();
                    if (inputEnd.equals("YES")) break mainLoop;
                }
                default -> {
                    System.out.println("Command not recognized. Try again.");
                    continue;
                }
            }

        }

    }

}