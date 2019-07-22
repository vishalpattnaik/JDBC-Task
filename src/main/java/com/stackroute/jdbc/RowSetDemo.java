package com.stackroute.jdbc;


import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.*;

public class RowSetDemo {

    public void rowSetImplementation() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123"); Statement statement = connection.createStatement();) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            JdbcRowSetImpl jdbcImpl=new JdbcRowSetImpl(connection);

            jdbcImpl.setCommand("Select * from employee");
            jdbcImpl.execute();

            jdbcImpl.addRowSetListener(new RowSetListener() {

                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("Cursor Moved...");
                }

                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("Cursor Changed...");
                }

                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("RowSet changed...");
                }
            });
            while (jdbcImpl.next()) {

                System.out.println("Id: " + jdbcImpl.getString(1));
                System.out.println("Name: " + jdbcImpl.getString(2));
                System.out.println("Salary: " + jdbcImpl.getString(3));
                System.out.println("Gender: " + jdbcImpl.getString(4));

            }
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }



}
