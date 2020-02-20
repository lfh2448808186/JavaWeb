package xust.lfh.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
JDBC工具类，使用Durid连接池
 */

public class JDBCUtils {

    private static DataSource ds;

    static{
        Properties pro = new Properties();
        //使用ClassLoader加载配置文件，获取字节输入流；
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 获取连接池对象
     */
    public static DataSource getDataSource(){

        return ds;
    }


    /*
    获取Connection 对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
