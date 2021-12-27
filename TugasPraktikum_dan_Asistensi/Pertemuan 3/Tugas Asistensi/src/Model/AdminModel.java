package Model;

import Entity.AdminEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModel extends ModelAbstrack{

    public AdminModel(){}

    public void insertAdmin(AdminEntity admin){
        try {
            sql = "insert into admin (nama, notelp, idAdmin, pass) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,admin.getNama());
            stmt.setString(2,admin.getNotelp());
            stmt.setString(3,admin.getIdAdmin());
            stmt.setString(4, admin.getPass());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL MENAMBAHKAN DATA");
            e.printStackTrace();
        }
    }

    //untuk ceklogin admin
    public int cekData(String id, String pass){
        int cek = 0;
        try {
            sql = "SELECT * FROM admin where idAdmin = ? and pass = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,id);
            stat.setString(2,pass);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("idAdmin");
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return cek;
    }

    //menampilkan data admin dengan menampilkan indek ke id
    public ArrayList<AdminEntity> showData(int id){
        ArrayList<AdminEntity> adminEntities = new ArrayList<>();
        try {
            sql = "SELECT * FROM admin where idAdmin = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next())
            {
                AdminEntity adminEntity = new AdminEntity();
                adminEntity.setNama(rs.getString("nama"));
                adminEntity.setNotelp(rs.getString("notelp"));
                adminEntity.setIdAdmin(rs.getString("idAdmin"));
                adminEntity.setPass(rs.getString("pass"));
                adminEntities.add(adminEntity);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return adminEntities;
    }

    public void ubahstatus( int id){
        try {
            sql = "UPDATE transaksi SET status = 1 WHERE nomortrx =?  ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updatepass(String pass, int id){
        try {
            sql = "UPDATE admin SET pass = ? WHERE idAdmin = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,pass);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH DATA");
            e.printStackTrace();
        }
    }
}
