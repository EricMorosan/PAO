package Repository;

import Config.DatabaseConfig;
import Entities.Address;
import Entities.Customer;

import java.sql.*;
import java.util.List;

public class CustomerRepository
{
    private static CustomerRepository customerRepository;
    private CustomerRepository() { }
    public static CustomerRepository getInstance()
    {
        if (customerRepository == null) customerRepository = new CustomerRepository();

        return customerRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS CUSTOMER " +
                "(id int PRIMARY KEY, " +
                "firstName varchar(40), " +
                "lastName varchar(40), " +
                "email varchar(40), " +
                "phone varchar(40), " +
                "type varchar(40), " +
                "addressid int) ";

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
        String selectSql = "SELECT * FROM CUSTOMER;";

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

    public void addCustomer(int id, String firstName, String lastName, String email, String phone, String type, int addressid)
    {
        String insertAddressSql = "INSERT INTO CUSTOMER(id, firstName, lastName, email, phone, type, addressid) VALUES("
                + id + ", \"" + firstName + "\", \"" + lastName + "\", \"" + email + "\", \"" + phone + "\", \"" + type + "\", " + addressid + ");";

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

    public void displayCustomers()
    {
        String selectSql = "SELECT * FROM CUSTOMER;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("Customer ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing Customers!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public Customer getCustomerById(int id)
    {
        String selectSql = "SELECT * FROM CUSTOMER WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql))
        {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
        }
        catch (SQLException e)
        {
            return null;
        }

    }
    public void deleteCustomerById(int id)
    {
        String deleteCustomerSql = "DELETE FROM CUSTOMER WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteCustomerSql))
        {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}