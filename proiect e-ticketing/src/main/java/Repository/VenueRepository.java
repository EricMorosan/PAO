package Repository;

import Config.DatabaseConfig;
import Entities.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VenueRepository
{
    private static VenueRepository venueRepository;
    private VenueRepository() { }
    public static VenueRepository getInstance()
    {
        if (venueRepository == null) venueRepository = new VenueRepository();

        return venueRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS VENUE " +
                "(id int PRIMARY KEY, " +
                "name varchar(40), " +
                "type varchar(40), " +
                "capacity int, " +
                "addressid varchar(40)) ";

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
        String selectSql = "SELECT * FROM VENUE;";

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

    public void addVenue(int id, String name, String type, int capacity, int addressid)
    {
        String insertAddressSql = "INSERT INTO VENUE(id, name, type, capacity, addressid) VALUES("
                + id + ", \"" + name + "\", \"" + type + "\", " + capacity + ", " + addressid + ");";

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

    public void displayVenues()
    {
        String selectSql = "SELECT * FROM VENUE;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("VENUE ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing Venues!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}