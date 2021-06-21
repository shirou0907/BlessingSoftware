
package demo.dao;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qlkh", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
            Frame f = new Frame();
            JOptionPane.showMessageDialog(f, "Lỗi kết nối khi truy cập CSDL", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cons;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
}