package Repository;

import Config.DatabaseConfig;
import Entities.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AddressRepository
{
    private static AddressRepository addressRepository;
    private AddressRepository() { }
    public static AddressRepository getInstance()
    {
        if (addressRepository == null) addressRepository = new AddressRepository();

        return addressRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS ADDRESS " +
                "(id int PRIMARY KEY, " +
                "street varchar(40), " +
                "number int, " +
                "zipcode varchar(40), " +
                "town varchar(40), " +
                "country varchar(40)) ";

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
        String selectSql = "SELECT * FROM ADDRESS;";

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

    public void addAddress(int id, String street, int number, String zipCode, String town, String country)
    {
        String insertAddressSql = "INSERT INTO ADDRESS(id, street, number, zipcode, town, country)VALUES("
                + id + ",\"" + street + "\", \"" + number + "\", \"" + zipCode + "\", \"" + town + "\", \"" + country + "\"" + ");";

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

    public void displayAddresses()
    {
        String selectSql = "SELECT * FROM ADDRESS;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Address ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing Address!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}