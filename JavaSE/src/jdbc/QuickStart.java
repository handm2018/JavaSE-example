package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc快速入门
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/01 10:19
 */
public class QuickStart {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Drive");
        // 2. 获取连接
        Connection connection = DriverManager.getConnection("", "", "");
        // 3. 获取对象
        Statement statement = connection.createStatement();
        String sql = "";
        // 4. 执行SQL
        statement.execute("");
        // 5. 释放资源
        statement.close();
        connection.close();

    }

}
