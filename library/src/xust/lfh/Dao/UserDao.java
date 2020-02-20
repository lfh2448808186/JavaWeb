package xust.lfh.Dao;

import xust.lfh.Bean.User;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Until {

    public List<User> select(String name) throws SQLException {

        User user = new User();
        List<User> list =new ArrayList<>();
        conn = myConnection();
        String sql = "select * from user where userName = ? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        rs = pstmt.executeQuery();
        while(rs.next()){
            String userName = rs.getString("userName");
            String userPassword = rs.getString("userPassword");
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            list.add(user);
        }
        return  list;
    }


    public boolean addUser(User user) throws SQLException{

        conn = myConnection();
        String sql = "insert into user(userName,userPassword)  values(?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUserName());
        pstmt.setString(2,user.getUserPassword());
        pstmt.execute();
        return true;
    }

}
