package Model_07293;
import Entity_07293.KelasEntity_07293;
import Entity_07293.MahasiswaEntity_07293;
import Helper_07293.KoneksiDb_07293;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MahasiswaModel_07293 {
    public Connection conn = KoneksiDb_07293.getConnection();
    String sql;
    Scanner input = new Scanner(System.in);
    public KelasEntity_07293 kelas= new KelasEntity_07293();
    ArrayList<MahasiswaEntity_07293> mahasiswa = new ArrayList<MahasiswaEntity_07293>();
    MahasiswaEntity_07293 biodataEntity = new MahasiswaEntity_07293();
    public MahasiswaModel_07293(){}

    public void insertBiodata(String nama, String no_telp, String alamat, int pil){
        try {
            String kelas = pilihKelas(pil);
            if(kelas != null){
                sql = "INSERT INTO tblmahasiswa (nama,no_telp,alamat,kelas) VALUE ('%s','%s','%s','%s')";
                sql = String.format(sql,nama,no_telp,alamat,kelas);;
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute(sql);
                System.out.println("Berhasil Ditambahkan");
            }else {
                System.out.println("Kelas Tidak boleh kosong");
            }

        }catch (Exception e){
            System.err.println("Gagal Menambahkan data");
            e.printStackTrace();
        }
    }

    public void showData(){
        try{
            Statement stmt = conn.createStatement();
            sql = "SELECT * FROM tblmahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
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

    public void getData(){
        try{
            Statement stmt = conn.createStatement();
            sql = "SELECT * FROM tblmahasiswa";
            int i = 0;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                mahasiswa.add(new MahasiswaEntity_07293(rs.getString("nama"), rs.getString("no_telp"),
                        rs.getString("alamat")));
                mahasiswa.get(i).setId(rs.getInt("id"));
                mahasiswa.get(i).setKelas(rs.getString("kelas"));
                i++;
            }
        }catch (Exception e){
            System.err.println("Gagal menampilkan data");
            e.printStackTrace();;
        }
    }

    public String pilihKelas(int pil){
        ArrayList<String>temp = kelas.daftarKelas();
        String kelas = null;
        if(pil > temp.size()){
            System.out.println("Input diluar batas");
        }else {
            kelas = temp.get(pil);
        }
        return kelas;
    }

    public void updateData(int id){
        String nama,noTelp,alamat,Kelas;
        Scanner input = new Scanner(System.in);
        int count = 0;
        getData();
        int pil,temp;

        for(int i = 0; i<mahasiswa.size(); i++){
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
                            try{
                                kelas.lihatKelas();
                                System.out.print("Pilih kelas baru: ");
                                temp = input.nextInt();
                                Kelas = pilihKelas(temp);
                                sql = "UPDATE tblmahasiswa SET kelas = ? WHERE id = ?";
                                PreparedStatement stat = conn.prepareStatement(sql);
                                stat.setString(1,Kelas);
                                stat.setInt(2,id);
                                stat.executeUpdate();
                                System.out.println("Kelas Berhasil di update");
                            }catch (SQLException e){
                                System.err.println("Gagal Update Kelas");
                                e.printStackTrace();
                            }
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
}

