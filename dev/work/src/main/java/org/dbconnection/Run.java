package org.dbconnection;


import java.sql.*;

/*
https://www.baeldung.com/java-jdbc
https://www.javatpoint.com/example-to-connect-to-the-oracle-database
https://docs.oracle.com/cd/E11882_01/appdev.112/e12137/getconn.htm#TDPJD139
 */
public class Run {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection connection = DriverManager.getConnection("");
//        connection.setAutoCommit(false);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("");
//        statement.close();
//        PreparedStatement preparedStatement = connection.prepareStatement("");
//        preparedStatement.close();
//        DatabaseMetaData databaseMetaData = connection.getMetaData();

//        connection.close();

        String str = "[asdgfhsfghdfhart,dfgsdfhsfhsadf]";
        int startindex = 1;
        int endindex = str.toCharArray().length - 1;
        String lineColumnsName = str.substring(startindex,endindex);
        System.out.println(lineColumnsName);
    }

}
