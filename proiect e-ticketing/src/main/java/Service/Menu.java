package Service;

import java.util.Scanner;

public class Menu
{
    // singleton class for an interactive menu

    private static Menu menu = null;
    private static final Service serviciu = new Service();

    // private constructor
    private Menu()
    {
        serviciu.configureTables();
    }

    private void showMenu()
    {
        System.out.println("-----------------------------------");
        System.out.println("Choose an action.");
        System.out.println("1: Add new address");
        System.out.println("2: Print all addresses");
        System.out.println("3: Add new event");
        System.out.println("4: Print all events");
        System.out.println("5: Add new customer");
        System.out.println("6: Print all customers");
        System.out.println("7: Print customer by id");
        System.out.println("8: Delete customer by id");
        System.out.println("9: Add new ticket");
        System.out.println("10: Print all tickets");
        System.out.println("11: Add new venue");
        System.out.println("12: Print all venues");
        System.out.println("13: Add new order");
        System.out.println("14: Print all orders");
        System.out.println("0: Exit");
        System.out.println("-----------------------------------");
    }

    public void runMenu()
    {
        showMenu();

        Scanner reader = new Scanner(System.in);
        int option;
        String check;

        do
        {
            option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 0 -> {
                    serviciu.closeConnection();
                    System.out.println("Exiting program..");
                }
                case 1 -> {
                    serviciu.addAddress();
                    System.out.println("-----------------------------------");
                }
                case 2 -> {
                    serviciu.printAddresses();
                    System.out.println("-----------------------------------");
                }
                case 3 -> {
                    serviciu.addEvent();
                    System.out.println("-----------------------------------");
                }
                case 4 -> {
                    serviciu.printEvents();
                    System.out.println("-----------------------------------");
                }
                case 5 -> {
                    serviciu.addCustomer();
                    System.out.println("-----------------------------------");
                }
                case 6 -> {
                    serviciu.printCustomers();
                    System.out.println("-----------------------------------");
                }
                case 7 -> {
                    serviciu.printCustomerById();
                    System.out.println("-----------------------------------");
                }
                case 8 -> {
                    serviciu.deleteCustomerById();
                    System.out.println("-----------------------------------");
                }
                case 9 -> {
                    serviciu.addTicket();
                    System.out.println("-----------------------------------");
                }
                case 10 -> {
                    serviciu.printTickets();
                    System.out.println("-----------------------------------");
                }
                case 11 -> {
                    serviciu.addVenue();
                    System.out.println("-----------------------------------");
                }
                case 12 -> {
                    serviciu.printVenues();
                    System.out.println("-----------------------------------");
                }
                case 13 -> {
                    serviciu.addOrder();
                    System.out.println("-----------------------------------");
                }
                case 14 -> {
                    serviciu.printOrders();
                    System.out.println("-----------------------------------");
                }
                default -> System.out.println("Invalid option. Try again.");
            }

            if (option != 0)
            {
                System.out.println("Do you want another action? y/n");
                check = reader.nextLine();
                check = check.toLowerCase();

                if (check.equals("y")) showMenu();
                else {
                    option = 0;
                    serviciu.closeConnection();
                    System.out.println("Exiting program..");
                }
            }

        } while (option != 0);

        reader.close();
    }

    public static Menu getInstance()
    {
        if (menu == null) menu = new Menu();

        return menu;
    }
}