package Repository;

import Config.DatabaseConfig;
import Entities.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderTicketRepository
{
    private static OrderTicketRepository orderticketRepository;
    private OrderTicketRepository() { }
    public static OrderTicketRepository getInstance()
    {
        if (orderticketRepository == null) orderticketRepository = new OrderTicketRepository();

        return orderticketRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS ORDERTICKET " +
                "(id int PRIMARY KEY, " +
                "quantity int, " +
                "orderid int, " +
                "ticketid int) ";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            stmt.execute(createTableSql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addData()
    {
        String selectSql = "SELECT * FROM ORDERTICKET;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            ResultSet resultSet = stmt.executeQuery(selectSql);

//            // daca tabelul este gol se vor adauga date din CSV
//            if (!resultSet.next())
//            {
//                List<Address> addresses = ReadWrite.readAddress();
//
//                for (Address a : addresses)
//                {
//                    //addSubject(a.getNumber(), a.getSubjectName(), s.getMark());
//                }
//            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addOrderTicket(int id, int quantity, int orderid, int ticketid)
    {
        String insertAddressSql = "INSERT INTO ORDERTICKET(id, quantity, orderid, ticketid) VALUES("
                + id + ", \"" + quantity + "\", \"" + orderid + "\", " + ticketid + ");";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            stmt.executeUpdate(insertAddressSql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void displayOrderTickets()
    {
        String selectSql = "SELECT * FROM ORDERTICKET;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("ORDERTICKET ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing ORDERTICKETS!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}