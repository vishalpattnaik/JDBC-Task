package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcBatchDemo {

    public void batchProcessing() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123");
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.addBatch("insert into employee values(98,'Jessica',23,'F')");
            stmt.addBatch("insert into employee values(1115,'Dave',34,'M')");

            stmt.executeBatch();

            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("enter id");
                String s1 = br.readLine();
                int id = Integer.parseInt(s1);

                System.out.println("enter name");
                String name = br.readLine();

                System.out.println("enter age");
                String s3 = br.readLine();
                int age = Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender = br.readLine();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, gender);

                ps.addBatch();
                System.out.println("Want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }
            }

            ps.executeBatch();

            System.out.println("Added one Record...");

            con.commit();

            con.close();
        }

        catch(Exception e) {

            e.printStackTrace();

        }




    }
}
