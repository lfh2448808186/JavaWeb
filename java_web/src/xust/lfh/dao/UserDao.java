package xust.lfh.dao;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xust.lfh.domain.User;
import xust.lfh.util.JDBCUtils;

public class UserDao {

    //声明JDBCTemplate

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /*
        return 返回user对象，
                user对象无内容，返回null
     */
    public User login(User loginUser){

        try {
            String sql = "select * from user where username=? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user){
        String sql = "insert into user(username,password)  values(?,?)";
        template.update(sql,user.getUsername(),user.getPassword());
        return true;
    }
}
