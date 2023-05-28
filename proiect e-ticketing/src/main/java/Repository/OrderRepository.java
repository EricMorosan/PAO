package Repository;

import Config.DatabaseConfig;
import Entities.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class OrderRepository
{
    private static OrderRepository orderRepository;
    private OrderRepository() { }
    public static OrderRepository getInstance()
    {
        if (orderRepository == null) orderRepository = new OrderRepository();

        return orderRepository;
    }

    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS `ORDER` " +
                "(id int PRIMARY KEY, " +
                "orderDate varchar(40), " +
                "customerid int) ";

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
        String selectSql = "SELECT * FROM ORDER;";

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

    public void addOrder(int id, String orderDate, int customerid)
    {
        String insertAddressSql = "INSERT INTO `ORDER`(id, orderDate, customerid) VALUES("
                + id + ", \""  + orderDate + "\", " + customerid + ");";

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

    public void displayOrders()
    {
        String selectSql = "SELECT * FROM ORDER;";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement())
        {
            boolean empty = true;
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next())
            {
                empty = false;
                System.out.println("ORDER ID: " + resultSet.getInt(1));
                System.out.println();
            }

            if (empty)
            {
                System.out.println("No existing Orders!");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}