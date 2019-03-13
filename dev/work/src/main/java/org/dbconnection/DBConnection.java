package org.dbconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 1 on 09.03.2019.
 */
public class DBConnection implements AutoCloseable{
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {

    }

    public synchronized static DBConnection instance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public void openConnection(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    public List<String> executeQuery(String query) throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<String> columnsName = getColumnsName(resultSetMetaData);
        String lineColumnsName = stringClipping(columnsName);
        List<String> result = new LinkedList<>();
        result.add(lineColumnsName);
        int columns = columnsName.size();
        StringBuilder builder = new StringBuilder();
        while (resultSet.next()){
            for(int i = 1; i <= columns; i++){
                builder.append(resultSet.getString(i));
                if(i != columns){
                    builder.append(",");
                }
            }
            result.add(builder.toString());
            builder.setLength(0);
        }
        statement.close();
        return result;
    }

    public void setAutoCommit(boolean autoCommit){
        try {
            this.connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    private List<String> getColumnsName(ResultSetMetaData resultSetMetaData) throws SQLException {
        int size = resultSetMetaData.getColumnCount();
        List<String> result = new ArrayList<>(size);
        for(int i = 1; i <= size; i++){
            result.add(resultSetMetaData.getColumnName(i));
        }
        return result;
    }

    private String stringClipping(List<String> list){
        String str = list.toString();
        int startindex = 1;
        int endindex = str.toCharArray().length - 1;
        String lineColumnsName = str.substring(startindex,endindex);
        return lineColumnsName;
    }
}

//1. добавить зависимость на драйвер
//2. ResultSet