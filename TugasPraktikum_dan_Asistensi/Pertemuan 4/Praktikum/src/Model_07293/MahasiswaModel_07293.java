package Model_07293;

import Entity_07293.MahasiswaEntity_07293;
import Helper.KoneksiDb_07293;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MahasiswaModel_07293 extends ModelAbstrack{
    private String sql;
    //public KelasEntitiy_07293 kelas = new KelasEntitiy_07293();
//    ArrayList<MahasiswaEntity_07293> mahasiswa = new ArrayList<>();
//    MahasiswaEntity_07293 biodataEntity = new MahasiswaEntity_07293();
//    public MahasiswaModel_07293(){}

    public void insertBiodata(MahasiswaEntity_07293 mahasiswa){
        try {
            sql = "INSERT INTO tblmahasiswa(nama,no_telp,alamat,kelas) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mahasiswa.getNama());
            stmt.setString(2, mahasiswa.getNo_telp());
            stmt.setString(3, mahasiswa.getAlamat());
            stmt.setString(4, mahasiswa.getKelas());

            int rows = stmt.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (Exception e){
            System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }

    }

//    public void insertdata()

    public void showData(){
        try{
            Statement stmt = conn.createStatement();
            sql = "SELECT * FROM tblmahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                MahasiswaEntity_07293 biodataEntity = new MahasiswaEntity_07293();
                biodataEntity.setId(rs.getInt("id"));
                biodataEntity.setNama(rs.getString("nama"));
                biodataEntity.setNo_telp(rs.getString("no_telp"));
                biodataEntity.setAlamat(rs.getString("alamat"));
                biodataEntity.setKelas(rs.getString("kelas"));
                System.out.println("==================================");
                System.out.println("Id      : "+biodataEntity.getId());
                System.out.println("Nama    : "+biodataEntity.getNama());
                System.out.println("No Telp : "+biodataEntity.getNo_telp());
                System.out.println("Alamat  : "+biodataEntity.getAlamat());

                if(biodataEntity.getKelas() == null){
                    System.out.println("Kelas   : "+ "Belum Memilih Kelas");
                }else {
                    System.out.println("Kelas   : "+ biodataEntity.getKelas());
                }
                System.out.println("==================================");
                System.out.println();
            }

        }catch (Exception e){
            System.err.println("Gagal menampilkan data");
            e.printStackTrace();;
        }
    }

    public ArrayList<MahasiswaEntity_07293> getData(){
        ArrayList<MahasiswaEntity_07293> arrayList = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();
            sql = "SELECT * FROM tblmahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                MahasiswaEntity_07293 mahasiswaEntity_07293 = new MahasiswaEntity_07293();
                mahasiswaEntity_07293.setId(rs.getInt("id"));
                mahasiswaEntity_07293.setNama(rs.getString("nama"));
                mahasiswaEntity_07293.setNo_telp(rs.getString("no_telp"));
                mahasiswaEntity_07293.setAlamat(rs.getString("alamat"));
                mahasiswaEntity_07293.setKelas(rs.getString("kelas"));
                arrayList.add(mahasiswaEntity_07293);

            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<MahasiswaEntity_07293> cari(int id){
        ArrayList<MahasiswaEntity_07293> arrayList = new ArrayList<>();
        try {
            sql = "SELECT * FROM tblmahasiswa where id =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                MahasiswaEntity_07293 transaksi = new MahasiswaEntity_07293();
                transaksi.setNama(rs.getString("nama"));
                transaksi.setNo_telp(rs.getString("no_telp"));
                transaksi.setAlamat(rs.getString("alamat"));
                transaksi.setKelas(rs.getString("kelas"));
                arrayList.add(transaksi);
            }
        }catch (SQLException e){
            System.err.println("Gagal Menampilkan Data");
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<MahasiswaEntity_07293> getMahasiswa_07293(){ //getMhs->mengambil dta mhs dri database
        ArrayList<MahasiswaEntity_07293> arraylistMahasiswa_07293 = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM tblmahasiswa";
            ResultSet rs_07293 = stat.executeQuery(sql);
            while(rs_07293.next()) {
                MahasiswaEntity_07293 mahasiswaEntity_07293 = new MahasiswaEntity_07293();
                mahasiswaEntity_07293.setId(rs_07293.getInt("id"));
                mahasiswaEntity_07293.setNama(rs_07293.getString("nama"));
                mahasiswaEntity_07293.setNo_telp(rs_07293.getString("no_telp"));
                mahasiswaEntity_07293.setAlamat(rs_07293.getString("alamat"));
                mahasiswaEntity_07293.setKelas(rs_07293.getString("kelas"));
                arraylistMahasiswa_07293.add(mahasiswaEntity_07293);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistMahasiswa_07293; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }

//    public String pilihKelas (int pil){
//        ArrayList<String> temp = kelas.daftarKelas();
//        String kelas = null;
//        if(pil > temp.size()){
//            System.out.println("Input diluar batas");
//        }else {
//            kelas = temp.get(pil);
//        }
//        return kelas;
//    }

    public void updateData(int id){
        Scanner input = new Scanner(System.in);
        String nama,noTelp,alamat,Kelas;
        int count = 0;
        getData();
        int pil,temp;
        ArrayList<MahasiswaEntity_07293> mahasiswa = new ArrayList<>();
        for(int i = 0; i < mahasiswa.size(); i++){
            if(mahasiswa.get(i).getId() == id){
                do{
                    System.out.println("1. Ubah Nama");
                    System.out.println("2. Ubah No Telp");
                    System.out.println("3. Ubah Alamat");
                    System.out.println("4. Ubah Kelas");
                    System.out.println("5. Keluar");
                    System.out.print("Masukkan pilihan: ");
                    pil = input.nextInt();
                    input.nextLine();

                    switch (pil){
                        case 1 -> {
                            try{
                                System.out.print("Masukkan nama baru: ");
                                nama = input.nextLine();
                                sql = "UPDATE tblmahasiswa SET nama = '%s' WHERE id=%d";
                                sql = String.format(sql,nama,id);
                                PreparedStatement stat = conn.prepareStatement(sql);
                                stat.executeUpdate();
                                System.out.println("Nama Berhasil di update");

                            }catch (Exception e){
                                System.err.println("GAGAL UPDATE");
                                e.printStackTrace();;
                            }
                        }
                        case 2 -> {
                            try{
                                System.out.print("Masukkan no Telp baru: ");
                                noTelp = input.nextLine();
                                sql = "UPDATE tblmahasiswa SET no_telp = '%s' WHERE id=%d";
                                sql = String.format(sql,noTelp,id);
                                PreparedStatement stat = conn.prepareStatement(sql);
                                stat.executeUpdate();
                                System.out.println("NoTelp Berhasil di update");

                            }catch (Exception e){
                                System.err.println("GAGAL UPDATE");
                                e.printStackTrace();
                            }
                        }
                        case 3 -> {
                            try{
                                System.out.print("Masukkan Alamat baru: ");
                                alamat = input.nextLine();
                                sql = "UPDATE tblmahasiswa SET alamat = '%s' WHERE id=%d";
                                sql = String.format(sql,alamat,id);
                                PreparedStatement stat = conn.prepareStatement(sql);
                                stat.executeUpdate();
                                System.out.println("Alamat Berhasil di update");

                            }catch (Exception e){
                                System.err.println("GAGAL UPDATE");
                                e.printStackTrace();
                            }
                        }

                        case 4 ->{
                            System.out.println("HIlang...");
                        }

                    }

                }while (pil != 5);
            }else {
                count +=1;
                if(count == mahasiswa.size()){
                    System.out.println("Data tidak ditemukan");
                }
            }
        }
    }

    public void deleteData(int id){
        getData();
        ArrayList<MahasiswaEntity_07293> mahasiswa = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<mahasiswa.size(); i++){
            if(mahasiswa.get(i).getId() == id){
                try{
                    sql = "DELETE FROM tblmahasiswa WHERE id = ?";
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1,id);
                    stat.executeUpdate();
                    System.out.println("Id : "+id + " Berhasil Dihapus");
                }catch (SQLException e){
                    e.printStackTrace();;
                }
            }else {
                count +=1;
                if(count == mahasiswa.size()){
                    System.out.println("Data tidak ditemukan");
                }
            }
        }
    }

    public void updateNama(String nama, int id){
        try{
            sql = "update tblmahasiswa SET nama =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }

    public void updatenotlp(String notlp, int id){
        try{
            sql = "update tblmahasiswa SET no_telp = ? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, notlp);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH !!!");
            e.printStackTrace();
        }
    }

    public void updatealamat(String alamt, int id){
        try{
            sql = "update tblmahasiswa SET alamat =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, alamt);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }

    public void updatekelas(String kls, int id){
        try{
            sql = "update tblmahasiswa SET kelas =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kls);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }

//    public ArrayList<MahasiswaEntity_07293> getMahasiswa(int cek) {
//        ArrayList<MahasiswaEntity_07293> arrmahasiswa = new ArrayList<>();
//        try {
//            sql
//        }

}