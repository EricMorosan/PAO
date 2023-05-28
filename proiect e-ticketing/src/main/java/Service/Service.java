package Service;


import Config.DatabaseConfig;
import Entities.Address;
import Entities.*;
import Repository.*;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Service
{
    public static List<Address> addresses = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static  List<Event> events = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<OrderTicket> ordertickets = new ArrayList<>();
    public static List<Ticket> tickets = new ArrayList<>();
    public static List<Venue> venues = new ArrayList<>();

    AddressRepository addressRepository = AddressRepository.getInstance();
    CustomerRepository customerRepository = CustomerRepository.getInstance();
    EventRepository eventRepository = EventRepository.getInstance();
    OrderRepository orderRepository = OrderRepository.getInstance();
    OrderTicketRepository orderticketRepository = OrderTicketRepository.getInstance();
    TicketRepository ticketRepository = TicketRepository.getInstance();
    VenueRepository venueRepository = VenueRepository.getInstance();
    AuditService auditService = AuditService.getInstance();


    public void configureTables()
    {
        addressRepository.createTable();
        customerRepository.createTable();
        eventRepository.createTable();
        orderRepository.createTable();
        orderticketRepository.createTable();
        ticketRepository.createTable();
        venueRepository.createTable();

        try
        {
            auditService.logAction("configure tables");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addAddress()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Address ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Address ID: ");
            }
        }

        System.out.print("Street: ");
        String street = reader.nextLine().toUpperCase();

        int number;

        System.out.print("Number: ");
        while(true)
        {
            try
            {
                number = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Number: ");
            }
        }

        System.out.print("zipCode: ");
        String zipCode = reader.nextLine().toUpperCase();

        System.out.print("Town: ");
        String town = reader.nextLine().toUpperCase();

        System.out.print("Country: ");
        String country = reader.nextLine().toUpperCase();

        addresses.add(new Address(id, street, number, zipCode, town, country));
        addressRepository.addAddress(id, street, number, zipCode, town, country);

        try
        {
            auditService.logAction("add address");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printAddresses()
    {
        addressRepository.displayAddresses();

        try
        {
            auditService.logAction("print addresses");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addEvent()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Address ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Address ID: ");
            }
        }

        System.out.print("Name of the event: ");
        String name = reader.nextLine().toUpperCase();

        System.out.print("Type of the event: ");
        String type = reader.nextLine().toUpperCase();

        System.out.print("StartDate: ");
        String startDate = reader.nextLine();
        ;
        System.out.print("EndDate: ");
        String endDate = reader.nextLine();

        events.add(new Event(id, name, type, startDate, endDate));
        eventRepository.addEvent(id, name, type, startDate, endDate);

        try
        {
            auditService.logAction("add event");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printEvents()
    {
        eventRepository.displayEvents();

        try
        {
            auditService.logAction("print events");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addCustomer() {
        Scanner reader = new Scanner(System.in);

        System.out.print("Customer ID: ");
        int id;

        while (true) {
            try {
                id = Integer.parseInt(reader.nextLine());

                boolean check = true;
                for (Customer c : customers) {
                    if (c.getId() == id) {
                        check = false;
                        break;
                    }
                }

                if (!check) throw new Exception();
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("ID Customer: ");
            } catch (Exception e) {
                System.out.println("Customer with given id already exists. Try again!");
                System.out.print("ID Customer: ");
            }
        }

        System.out.print("First name: ");
        String firstName = reader.nextLine().toUpperCase();

        System.out.print("Last name: ");
        String lastName = reader.nextLine().toUpperCase();

        String email;
        while (true) {
            System.out.print("Email: ");
            email = reader.nextLine().toLowerCase();

            if (!email.contains("@")) System.out.println("Not a valid email address! Try again!");
            else break;
        }
        String phone;
        while (true) {
            System.out.print("Phone number: ");
            phone = reader.nextLine();

            if (!phone.matches("[0-9]+")) System.out.println("Not a valid phone number! Try again!");
            else break;
        }

        System.out.print("Type: ");
        String type = reader.nextLine().toUpperCase();


        boolean check = true;
        int addressid = 0;
        while (check) {
            System.out.print("Address id: ");

            while (true) {
                try {
                    addressid = Integer.parseInt(reader.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Expecting an integer value. Try again!");
                    System.out.print("Address id: ");
                }
            }

            for (Address ad : addresses) {
                if (ad.getId() == addressid) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Address doesn't exist. Try again!");
            }
        }
        customers.add(new Customer(id, firstName, lastName, email, phone, type, addressid));
        customerRepository.addCustomer(id, firstName, lastName, email, phone, type, addressid);
    }

    public void printCustomers()
    {
        customerRepository.displayCustomers();

        try
        {
            auditService.logAction("prints customers");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printCustomerById()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Customer ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("ID Customer: ");
            }
        }

        if (customerRepository.getCustomerById(id) != null)
        {
            System.out.println(customerRepository.getCustomerById(id).toString());
        }
        else
        {
            System.out.println("No existing customer with this id!");
        }

        try
        {
            auditService.logAction("print customer by id");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteCustomerById()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Customer ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Customer ID: ");
            }
        }

        boolean check = false;
        for (Customer c : customers)
        {
            if (id == c.getId())
            {
                check = true;
                break;
            }
        }

        if (check)
        {
            customerRepository.deleteCustomerById(id);
            System.out.println("Student deleted succesfully!");
        }
        else
        {
            System.out.println("No existing customer with this id!");
        }

        try
        {
            auditService.logAction("delete customer");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addTicket()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Ticket ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Ticket ID: ");
            }
        }

        System.out.print("Description: ");
        String description = reader.nextLine().toUpperCase();

        int price;

        System.out.print("Price: ");
        while(true)
        {
            try
            {
                price = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Price: ");
            }
        }
        boolean check = true;
        int eventid = 0;
        while (check) {
            System.out.print("Event id: ");

            while (true) {
                try {
                    eventid = Integer.parseInt(reader.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Expecting an integer value. Try again!");
                    System.out.print("Event id: ");
                }
            }

            for (Event ev : events) {
                if (ev.getId() == eventid) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Event doesn't exist. Try again!");
            }
        }

        tickets.add(new Ticket(id, description, price, eventid));
        ticketRepository.addTicket(id, description, price, eventid);

        try
        {
            auditService.logAction("add ticket");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printTickets()
    {
        ticketRepository.displayTickets();

        try
        {
            auditService.logAction("prints tickets");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addVenue()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Venue ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Venue ID: ");
            }
        }

        System.out.print("Name: ");
        String name = reader.nextLine().toUpperCase();

        System.out.print("Type: ");
        String type = reader.nextLine().toUpperCase();

        int capacity;

        System.out.print("Capacity: ");
        while(true)
        {
            try
            {
                capacity = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Capacity: ");
            }
        }
        boolean check = true;
        int addressid = 0;
        while (check) {
            System.out.print("Address id: ");

            while (true) {
                try {
                    addressid = Integer.parseInt(reader.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Expecting an integer value. Try again!");
                    System.out.print("Address id: ");
                }
            }

            for (Address ad : addresses) {
                if (ad.getId() == addressid) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Address doesn't exist. Try again!");
            }
        }


        venues.add(new Venue(id, name, type, capacity, addressid));
        venueRepository.addVenue(id, name, type, capacity, addressid);

        try
        {
            auditService.logAction("add venue");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printVenues()
    {
        venueRepository.displayVenues();

        try
        {
            auditService.logAction("prints venues");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addOrder()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Order ID: ");
        int id;

        while(true)
        {
            try
            {
                id = Integer.parseInt(reader.nextLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Expecting an integer value. Try again!");
                System.out.print("Order ID: ");
            }
        }
        System.out.print("Order Date: ");
        String orderDate = reader.nextLine().toUpperCase();

        boolean check = true;
        int customerid = 0;
        while (check) {
            System.out.print("Customer id: ");

            while (true) {
                try {
                    customerid = Integer.parseInt(reader.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Expecting an integer value. Try again!");
                    System.out.print("Customer id: ");
                }
            }

            for (Customer cs : customers) {
                if (cs.getId() == customerid) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Customer doesn't exist. Try again!");
            }
        }


        orders.add(new Order(id, orderDate, customerid));
        orderRepository.addOrder(id, orderDate, customerid);

        try
        {
            auditService.logAction("add order");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printOrders()
    {
        orderRepository.displayOrders();

        try
        {
            auditService.logAction("prints orders");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


//    public LocalDate readDate()
//    {
//        Scanner reader = new Scanner(System.in);
//
//        System.out.print("Day: ");
//        int day;
//
//        while(true)
//        {
//            try
//            {
//                day = Integer.parseInt(reader.nextLine());
//                break;
//            }
//            catch (NumberFormatException e)
//            {
//                System.out.println("Expecting an integer value. Try again!");
//                System.out.print("Day: ");
//            }
//        }
//
//        System.out.print("Month: ");
//        int month;
//
//        while(true)
//        {
//            try
//            {
//                month = Integer.parseInt(reader.nextLine());
//                break;
//            }
//            catch (NumberFormatException e)
//            {
//                System.out.println("Expecting an integer value. Try again!");
//                System.out.print("Month: ");
//            }
//        }
//
//        System.out.print("Year: ");
//        int year;
//
//        while(true)
//        {
//            try
//            {
//                year = Integer.parseInt(reader.nextLine());
//                break;
//            }
//            catch (NumberFormatException e)
//            {
//                System.out.println("Expecting an integer value. Try again!");
//                System.out.print("Year: ");
//            }
//        }
//
//        return LocalDate.of(year, month, day);
//    }
//
    public void closeConnection()
    {
        DatabaseConfig.closeDatabaseConnection();

        try
        {
            auditService.logAction("close connection with database");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}