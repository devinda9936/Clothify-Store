package edu.icet.db;

import edu.icet.dto.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private final List<Customer> customerList;

    private DBConnection() throws SQLException {
        this.customerList = new ArrayList<>();
        customerList.add(new Customer("001","Mr. ","Nimal","Panadura", LocalDate.parse("2024-08-10")));
        customerList.add(new Customer("002","Miss. ","Kamal","Panadura", LocalDate.parse("2024-08-10")));
        customerList.add(new Customer("003","Mr. ","Sanoj","Panadura", LocalDate.parse("2024-07-15")));
        customerList.add(new Customer("004","Miss. ","Sandun","Panadura", LocalDate.parse("2024-08-10")));
        customerList.add(new Customer("005","Miss. ","Sandun","Panadura", LocalDate.parse("2024-08-10")));
        System.out.println(Integer.toHexString(System.identityHashCode(customerList))+" --> DB connected successfully");

        //connect with sql
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
    }

    //singleton
    public static DBConnection getInstance() throws SQLException {
        return instance==null ? new DBConnection():instance;
    }
    public Connection getDBConnection(){
        System.out.println("Connection -> " + connection);
        return connection;
    }

    //get connection
    public List<Customer> getConnection(){
        return customerList;
    }

}
