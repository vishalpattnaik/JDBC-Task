package com.stackroute.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("\n");

        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("\n");

        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("\n");

        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Diana", "F");
        System.out.println("\n");

        ResultSetMetaData rsmd = new ResultSetMetadataDemo();
        System.out.println(rsmd.getColumnCount());
        System.out.println("\n");

        System.out.println(rsmd.getColumnName(2));
        System.out.println("\n");

        System.out.println(rsmd.getColumnTypeName(2));
        System.out.println("\n");

        System.out.println(rsmd.getTableName(2));
        System.out.println("\n");

        DatabaseMetaData dbmd = new DatabaseMetadataDemo();
        System.out.println(dbmd.getDriverName());
        System.out.println("\n");

        /*RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.rowSetImplementation();
        System.out.println("\n");
        */

        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.batchProcessing();

    }

}
