package Model;

import Entity.AdminEntity;
import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransaksiModel extends ModelAbstrack{

    public ArrayList<TransaksiModel> TransaksiArray = new ArrayList<>();
    public ArrayList<ProdukEntity> produkArray = new ArrayList<>();


    public TransaksiModel(){}

    public void insertDataPembeli(TransaksiEntity transaksiEntity){
        try{
            sql = "INSERT INTO transaksi (nama, notelp, idGame, namaAkun, produk, nominal, harga) values (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,transaksiEntity.getNama());
            stmt.setString(2,transaksiEntity.getNotelp());
            stmt.setString(3,transaksiEntity.getIDGame());
            stmt.setString(4,transaksiEntity.getNamaAkun());
            stmt.setString(5,transaksiEntity.getProduk());
            stmt.setInt(6,transaksiEntity.getNominal());
            stmt.setInt(7,transaksiEntity.getHarga());

            int rows = stmt.executeUpdate();
            System.out.println(rows + "Rows Update");
        }catch (Exception e){
            System.out.println("GAGAL TAMBAH");
            e.printStackTrace();
        }
    }

    public TransaksiEntity showdata(int id){
        try {
            sql = "SELECT * FROM transaksi where nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next())
            {
                TransaksiEntity transaksi = new TransaksiEntity();
                transaksi.setNomortrx(rs.getInt("nomortrx"));
                transaksi.setStatus(rs.getInt("status"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setNotelp(rs.getString("noelp"));
                transaksi.setIDGame(rs.getString("idGame"));
                transaksi.setNamaAkun(rs.getString("namaAkun"));
                transaksi.setProduk(rs.getString("produk"));
                transaksi.setNominal(rs.getInt("nominal"));
                transaksi.setHarga(rs.getInt("harga"));
                return transaksi;
            }
        }catch(SQLException e){
            System.out.println("Gagal Menampilkan data transaksi");
            e.printStackTrace();
        }return null;
    }

    public ArrayList<TransaksiEntity> gettransaksiall(){
        ArrayList<TransaksiEntity> arrayList = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                TransaksiEntity transaksi = new TransaksiEntity();
                transaksi.setNomortrx(rs.getInt("nomortrx"));
                transaksi.setStatus(rs.getInt("status"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setNotelp(rs.getString("notelp"));
                transaksi.setIDGame(rs.getString("idGame"));
                transaksi.setNamaAkun(rs.getString("namaAkun"));
                transaksi.setProduk(rs.getString("produk"));
                transaksi.setNominal(rs.getInt("nominal"));
                transaksi.setHarga(rs.getInt("harga"));
                arrayList.add(transaksi);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arrayList;
    }

    public ArrayList<TransaksiEntity> getpembeli(){
        ArrayList<TransaksiEntity> t = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                TransaksiEntity pembeliEntity_07293 = new TransaksiEntity();
                pembeliEntity_07293.setNomortrx(rs.getInt("nomortrx"));
                pembeliEntity_07293.setStatus(rs.getInt("status"));
                pembeliEntity_07293.setNama(rs.getString("nama"));
                pembeliEntity_07293.setNotelp(rs.getString("notelp"));
                pembeliEntity_07293.setIDGame(rs.getString("idGame"));
                pembeliEntity_07293.setNamaAkun(rs.getString("namaAkun"));
                t.add(pembeliEntity_07293);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public void insertProduk(ProdukEntity produk){
        try {
            sql = "INSERT INTO produk (produk,nominal,harga) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produk.getProduk());
            stmt.setInt(2,produk.getNominal());
            stmt.setInt(3,produk.getHarga());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("gagal input");
            e.printStackTrace();
        }
    }

    public ArrayList<ProdukEntity> getProduk(){
        ArrayList<ProdukEntity> p = new ArrayList<>();
        sql = "SELECT * FROM produk";
        try {
            Statement stam = conn.createStatement();
            ResultSet rs = stam.executeQuery(sql);
            while (rs.next())
            {
                ProdukEntity produk = new ProdukEntity();
                produk.setId(rs.getInt("id"));
                produk.setProduk(rs.getString("produk"));
                produk.setNominal(rs.getInt("nominal"));
                produk.setHarga(rs.getInt("harga"));
                p.add(produk);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    public ProdukEntity produkbyid(int id){
        sql= "SELECT * FROM produk WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ProdukEntity produkEntity_07293 = new ProdukEntity();
                produkEntity_07293.setId(rs.getInt("id"));
                produkEntity_07293.setProduk(rs.getString("Produk"));
                produkEntity_07293.setNominal(rs.getInt("nominal"));
                produkEntity_07293.setHarga(rs.getInt("harga"));
                return produkEntity_07293;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int nomortrx){
        try {
            sql = "DELETE FROM transaksi WHERE nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, nomortrx);
            stat.executeUpdate();
        }catch (Exception e){
            System.out.println("GAGAL MENGHAPUS DATA!!!");
            System.out.println(e);
        }
    }

    //gettransaksi byid
    public ArrayList<TransaksiEntity> cari(int idGame){
        ArrayList<TransaksiEntity> arrayList = new ArrayList<>();
        try {
            sql = "SELECT * FROM transaksi where idGame =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idGame);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TransaksiEntity transaksi = new TransaksiEntity();
                transaksi.setNomortrx(rs.getInt("nomortrx"));
                transaksi.setNomortrx(rs.getInt("status"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setNotelp(rs.getString("notelp"));
                transaksi.setIDGame(rs.getString("idGame"));
                transaksi.setNamaAkun(rs.getString("namaAkun"));
                transaksi.setProduk(rs.getString("produk"));
                transaksi.setNominal(rs.getInt("nominal"));
                transaksi.setHarga(rs.getInt("harga"));
                arrayList.add(transaksi);
            }
        }catch (SQLException e){
            System.err.println("Gagal Menampilkan Data");
            e.printStackTrace();
        }
        return arrayList;
    }

    public void updateNamaPembeli(String nama, int nomortrx){
        try {
            sql = "update transaksi SET nama =? WHERE nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2,nomortrx);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA");
            e.printStackTrace();
        }
    }

    public void updateNoPembeli(String notlp, int nomortrx){
        try {
            sql = "update transaksi SET notelp=? WHERE nomortrx=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, notlp);
            stat.setInt(2, nomortrx);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH NOTELP");
            e.printStackTrace();
        }
    }

    public void updateidGame(String idgame, int nomortrx){
        try {
            sql = "update transaksi SET idGame =? WHERE nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,idgame);
            stat.setInt(2,nomortrx);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH IDGAME");
            e.printStackTrace();
        }
    }

    public void updatenamaAkun(String akun, int nomortrx){
        try {
            sql = "update transaksi SET namaAkun =? WHERE nomortrx=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,akun);
            stat.setInt(2,nomortrx);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA AKUN");
            e.printStackTrace();
        }
    }

    public void updateNominal(int nominal, int nomortrx){
        try {
            sql = "UPDATE produk SET nominal =? WHERE nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,nominal);
            stat.setInt(2, nomortrx);
            stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateharga(int harga, int nomortrx){
        try {
            sql = "UPDATE produk SET harga =? WHERE nomortrx=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,harga);
            stat.setInt(2,nomortrx);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateproduk(String produk, int nomortrx){
        try {
            sql = "UPDATE produk set produk = ? WHERE nomortrx=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produk);
            stmt.setInt(2,nomortrx);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
