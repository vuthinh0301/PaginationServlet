package com.example.DemoFilter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public static List<Emp> getRecords(int start, int total) {
        List<Emp> list = new ArrayList<Emp>();
        try {
            Connection connection = new DBContextMySQL().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from employee limit "+(start-1)+","+total);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = new Emp(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3));
                list.add(e);
            }
        } catch (Exception exception) {
            System.out.println(exception);;
        }

        return list;
    }

        public static void main(String[] args) {
            List<Emp> list = EmpDao.getRecords(1,5);
            for(Emp e : list){
                System.out.println(e.toString());
            }
    }
}
