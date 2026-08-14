package team2.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class BaseDao {
    private String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
    private String user = "root";
    private String password = "1234";

    protected Connection conn;

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("DB연동 실패" + e);
        }
    }

    protected BaseDao() {
        connect();
    }
}