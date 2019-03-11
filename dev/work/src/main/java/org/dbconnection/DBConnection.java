package org.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 1 on 09.03.2019.
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection(){

    }

    private static DBConnection instance(){
        if(dbConnection == null){
            synchronized (DBConnection.class) {
                if(dbConnection == null) {
                    dbConnection = new DBConnection();
                }
            }
        }

        return dbConnection;
    }

    public void openConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);//TODO отключение авто комита, запросы  на изменнение бд проходить не будут !!!
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public void executeQuery(String query){

    }
}
