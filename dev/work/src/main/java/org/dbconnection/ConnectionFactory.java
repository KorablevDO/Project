package org.dbconnection;

public class ConnectionFactory {
    public DBConnection oracleDriver(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DBConnection.instance();
    }

    public DBConnection postgresSqlDriver(){
        return null;
    }
}
