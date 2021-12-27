package Helper;
import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDb_07293 {

    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/khursus";
        String user = "root";
        String pass = "";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Berhasil connect database");
        }catch (Exception e){
            System.err.println("Gagal connect");
            e.printStackTrace();
        }
        return conn;
    }

}
