package Model_07293;

import Entity_07293.AdminEntity_07293;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModel_07293 extends ModelAbstrack_07293 {

    public AdminModel_07293(){}

    public void insertAdmin(AdminEntity_07293 admin){
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
    public ArrayList<AdminEntity_07293> showData(int id){
        ArrayList<AdminEntity_07293> adminEntities = new ArrayList<>();
        try {
            sql = "SELECT * FROM admin where idAdmin = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next())
            {
                AdminEntity_07293 adminEntity07293 = new AdminEntity_07293();
                adminEntity07293.setNama(rs.getString("nama"));
                adminEntity07293.setNotelp(rs.getString("notelp"));
                adminEntity07293.setIdAdmin(rs.getString("idAdmin"));
                adminEntity07293.setPass(rs.getString("pass"));
                adminEntities.add(adminEntity07293);
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

    public void updatepro(String pro, int id){
        try{
            sql ="UPDATE produk SET produk = ? WHERE id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,pro);
            stat.setInt(2,id);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH DATA");
            e.printStackTrace();
        }
    }
    public void updatenom(int nom, int id){
        try{
            sql ="UPDATE produk SET nominal = ? WHERE id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,nom);
            stat.setInt(2,id);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH DATA");
            e.printStackTrace();
        }
    }

    public void updatehar(int har, int id){
        try{
            sql ="UPDATE produk SET harga = ? WHERE id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,har);
            stat.setInt(2,id);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH DATA");
            e.printStackTrace();
        }
    }
}
