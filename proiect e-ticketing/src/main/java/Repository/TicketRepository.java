package Repository;

import Config.DatabaseConfig;
import Entities.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TicketRepository
{
    private static TicketRepository ticketRepository;
    private TicketRepository() { }
    public static TicketRepository getInstance()
    {
        if (ticketRepository == null) ticketRepository = new TicketRepository();

        return ticketRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS TICKET " +
                "(id int PRIMARY KEY, " +
                "description varchar(40), " +
                "price int, " +
                "eventid int) ";

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
        String selectSql = "SELECT * FROM TICKET;";

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

    public void addTicket(int id, String description, int price, int eventid)
    {
        String insertAddressSql = "INSERT INTO TICKET(id, description, price, eventid) VALUES("
                + id + ", \"" + description + "\", " + price + ", " + eventid + ");";

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

    public void displayTickets()
    {
        String selectSql = "SELECT * FROM TICKET;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Ticket ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing Tickets!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}