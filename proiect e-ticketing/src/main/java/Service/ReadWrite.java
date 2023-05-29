package Service;

import Entities.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite
{
    public static void writeAddress(int id, String street, int number, String zipCode, String town, String country) {
        String file = "src\\main\\java\\files\\address.csv";
        try
        {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String addressString = id + "," + street + "," + number + "," + zipCode + "," + town + "," + country;
            pw.println(addressString);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static List<Address> readAddress() {
        List<Address> addresses = new ArrayList<>();
        String file = "src\\main\\java\\files\\address.csv";
        BufferedReader reader;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String street = row[1];
                int number = Integer.parseInt(row[2]);
                String zipcode = row[3];
                String town = row[4];
                String country = row[5];

                addresses.add(new Address(id, street, number, zipcode, town, country));
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return addresses;
    }

    public static void writeCustomer(int id, String firstName, String lastName, String email, String phone, String type, int addressId) {
        String file = "src\\main\\java\\files\\customer.csv";
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String customerString = id + "," + firstName + "," + lastName + "," + email + "," + phone + "," + type + "," + addressId;
            pw.println(customerString);

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Customer> readCustomer() {
        List<Customer> customers = new ArrayList<>();
        String file = "src\\main\\java\\files\\customer.csv";
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String firstName = row[1];
                String lastName = row[2];
                String email = row[3];
                String phone = row[4];
                String type = row[5];
                int addressId = Integer.parseInt(row[6]);

                customers.add(new Customer(id, firstName, lastName, email, phone, type, addressId));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static void writeOrder(int id, String orderDate, int customerId) {
        String file = "src\\main\\java\\files\\order.csv";
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String orderString = id + "," + orderDate + "," + customerId;
            pw.println(orderString);

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Order> readOrder() {
        List<Order> orders = new ArrayList<>();
        String file = "src\\main\\java\\files\\order.csv";
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String orderDate = row[1];
                int customerId = Integer.parseInt(row[2]);

                orders.add(new Order(id, orderDate, customerId));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static void writeTicket(int id, String description, int price, int eventId) {
        String file = "src\\main\\java\\files\\ticket.csv";
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String ticketString = id + "," + description + "," + price + "," + eventId;
            pw.println(ticketString);

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Ticket> readTicket() {
        List<Ticket> tickets = new ArrayList<>();
        String file = "src\\main\\java\\files\\ticket.csv";
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String description = row[1];
                int price = Integer.parseInt(row[2]);
                int eventId = Integer.parseInt(row[3]);

                tickets.add(new Ticket(id, description, price, eventId));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }

    public static void writeEvent(int id, String name, String type, String startDate, String endDate) {
        String file = "src\\main\\java\\files\\event.csv";
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String eventString = id + "," + name + "," + type + "," + startDate + "," + endDate;
            pw.println(eventString);

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Event> readEvent() {
        List<Event> events = new ArrayList<>();
        String file = "src\\main\\java\\files\\event.csv";
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                int id = Integer.parseInt(row[0]);
                String name = row[1];
                String type = row[2];
                String startDate = row[3];
                String endDate = row[4];

                events.add(new Event(id, name, type, startDate, endDate));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }
}