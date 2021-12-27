package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    public static Connection getconnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String pass = "";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("BERHASIL KONEKSI DATABASE");
        }catch (Exception e){
            System.out.println("Gagal koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }
}
