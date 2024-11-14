package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String host = "jdbc:mariadb://localhost:3306/project_monney";
    private static final String user = "root";
    private static final String password = "";

    // Method สำหรับเชื่อมต่อฐานข้อมูล
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("เชื่อมต่อฐานข้อมูล MariaDB สำเร็จ");
        } catch (SQLException e) {
            System.out.println("ไม่สามารถเชื่อมต่อฐานข้อมูล MariaDB ได้ : " + e);
            e.printStackTrace();
        }
        return conn;
    }

    // Method สำหรับปิดการเชื่อมต่อ
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("ปิดการเชื่อมต่อฐานข้อมูลสำเร็จ");
            } catch (SQLException e) {
                System.out.println("ไม่สามารถปิดการเชื่อมต่อได้ : " + e);
                e.printStackTrace();
            }
        }
    }
}
