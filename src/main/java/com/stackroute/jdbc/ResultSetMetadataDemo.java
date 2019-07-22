package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo implements ResultSetMetaData {

    private int noOfColumns;
    private String columnName;
    private String columnTypeName;
    private String tableName;

    @Override
    public int getColumnCount() throws SQLException {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123"); Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee")) {


                ResultSetMetaData rsmd=resultSet.getMetaData();
                noOfColumns = rsmd.getColumnCount();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return noOfColumns;
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return 0;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        return false;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        return null;
    }

    @Override
    public String getColumnName(int column) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123"); Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee")) {


            ResultSetMetaData rsmd=resultSet.getMetaData();
            columnName = rsmd.getColumnName(2);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return columnName;


    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getTableName(int column) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123"); Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee")) {


            ResultSetMetaData rsmd=resultSet.getMetaData();
            tableName = rsmd.getTableName(2);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return tableName;

    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Root@123"); Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee")) {


            ResultSetMetaData rsmd=resultSet.getMetaData();
            columnTypeName = rsmd.getColumnTypeName(2);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return columnTypeName;


    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
