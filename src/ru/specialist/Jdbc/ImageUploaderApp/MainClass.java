package ru.specialist.Jdbc.ImageUploaderApp;

import java.sql.*;
import java.util.Enumeration;

public class MainClass {

    public static final String DRIVER_NAME = "org.postgresql.Driver";
    public static final String CONN_STRING =
            "jdbc:postgresql://localhost:5432/postgreLearning?user=Igor&password=123456&ssl=false";

    public static void main(String[] args) {

        try{
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex){
            System.out.println("PostgreSQL Driver not found!");
        }

        Enumeration<Driver> drvs = DriverManager.getDrivers();
        while(drvs.hasMoreElements()){
            System.out.println(drvs.nextElement());
        }
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING);
        }
        catch (SQLException ex){
            System.out.println("Cant connect to PostgreSQL db!");
        }
        try {
            ResultSet rs = conn.getMetaData().getCatalogs();
            while (rs.next())
                System.out.println(rs.getString("TABLE_CAT"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try{
            Statement st = conn.createStatement();
            //st.executeUpdate("CREATE TABLE persons (name character varying(32), surname character varying (32), age integer)");
            st.executeUpdate("INSERT INTO persons (name, surname, age) VALUES ('Mikhail','Akopov',23)");

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }


    }
}
