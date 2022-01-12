package com.example.DemoFilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBContextMySQL {
    public Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/"+ dbname + "?useSSL=false&characterEncoding=utf8";
        return DriverManager.getConnection(url,username,password);
    }

    private final String username = "root";
    private final String password = "123456789";
    private final String dbname = "employee";

    public static void main(String[] args) {

        try{
            Connection con = new DBContextMySQL().getConnection();
            Statement stm = con.createStatement();
            String sql = "select * from employee";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getString(2));
            }
        }catch (Exception e){

        }
    }
}

