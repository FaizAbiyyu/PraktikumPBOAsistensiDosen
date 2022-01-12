package Model_07293;

import Entity_07293.PembeliEntity_07293;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PembeliModel_07293 extends ModelAbstrack_07293 {

    public ArrayList<PembeliEntity_07293> pembeli = new ArrayList<>();

    public ArrayList<PembeliEntity_07293> getPembeli() {
        return pembeli;
    }

    public void insert (PembeliEntity_07293 pembeli) {
        try {
            sql = "INSERT INTO pembeli (nama,notelp,idGame,namaAkun) VALUES (?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pembeli.getNama());
            stmt.setString(2, pembeli.getNotelp());
            stmt.setString(3, pembeli.getIDGame());
            stmt.setString(4, pembeli.getNamaAkun());

            int rows = stmt.executeUpdate();
            System.out.println(rows + "Down");
        } catch (SQLException e){
            System.out.println("Gagal Tambah Data");
            e.printStackTrace();
        }
    }

    public PembeliModel_07293(){}

    public PembeliEntity_07293 getpembelibyid(int idGame){
        try {
            sql = "SELECT * FROM pembeli where idGame =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idGame);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PembeliEntity_07293 pembeli = new PembeliEntity_07293();
                pembeli.setNama(rs.getString("nama"));
                pembeli.setNotelp(rs.getString("notelp"));
                pembeli.setIDGame(rs.getString("idGame"));
                pembeli.setNamaAkun(rs.getString("namaAkun"));
                return pembeli;
            }
        }catch (SQLException e){
            System.err.println("Gagal Menampilkan Data");
            e.printStackTrace();
        }
        return null;
    }

    //cekdatabynama
    public int cekData(String namaAkun){
        int cek = 0;
        try {
            sql = "SELECT * FROM admin where namaAkun = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,namaAkun);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("namaAkun");
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return cek;
    }
}

