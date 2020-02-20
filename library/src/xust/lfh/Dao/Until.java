package xust.lfh.Dao;

import java.sql.*;
/*
   创建数据库链接操作；
 */
public class Until {
    static Connection conn = null;
    static Statement st = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    static final String url="jdbc:mysql://localhost:3306/books?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    static final String root="root";
    static final String pass="1234";

    public Connection myConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,root,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
