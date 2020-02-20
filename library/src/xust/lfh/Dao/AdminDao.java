package xust.lfh.Dao;

import xust.lfh.Bean.Admin;
import xust.lfh.Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends Until{
    public List<Admin> select(String name) throws SQLException {

        Admin admin = new Admin();
        List<Admin> list =new ArrayList<>();
        conn = myConnection();
        String sql = "select * from admin where admin =? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        rs = pstmt.executeQuery();
        while(rs.next()){
            String adminName = rs.getString("admin");
            String adminPassword = rs.getString("adminPassword");
            admin.setAdminName(adminName);
            admin.setAdminPassword(adminPassword);
            list.add(admin);
        }
        return  list;
    }
}
