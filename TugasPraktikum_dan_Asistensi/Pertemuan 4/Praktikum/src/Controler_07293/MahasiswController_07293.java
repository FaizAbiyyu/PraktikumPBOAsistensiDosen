package Controler_07293;

import Entity_07293.MahasiswaEntity_07293;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MahasiswController_07293 {
    public void insertData(MahasiswaEntity_07293 mahasiswa){
        AllObjectModel_07293.mahasiswaModel_07293.insertBiodata(mahasiswa);
    }
    public ArrayList<MahasiswaEntity_07293> getMahasiswa(){
        return AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293();
    }
    public void showData(){
        AllObjectModel_07293.mahasiswaModel_07293.showData();
    }
    public void updateData(int id){
        AllObjectModel_07293.mahasiswaModel_07293.updateData(id);
    }

    public void update(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel_07293.mahasiswaModel_07293.updateNama(data, id);
                break;
            case 2:
                AllObjectModel_07293.mahasiswaModel_07293.updatenotlp(data, id);
                break;
            case 3:
                AllObjectModel_07293.mahasiswaModel_07293.updatealamat(data, id);
                break;
            case 4:
                AllObjectModel_07293.mahasiswaModel_07293.updatekelas(data, id);
                break;
        }
    }

    public void deleteData(int id){
        AllObjectModel_07293.mahasiswaModel_07293.deleteData(id);
    }

    public void insertmahasiswa(String nama , String notelp, String alamat, String kelas){
        MahasiswaEntity_07293 mahasiswaEntity_07293 = new MahasiswaEntity_07293();
        mahasiswaEntity_07293.setNama(nama);
        mahasiswaEntity_07293.setNo_telp(notelp);
        mahasiswaEntity_07293.setAlamat(alamat);
        mahasiswaEntity_07293.setKelas(kelas);
        AllObjectModel_07293.mahasiswaModel_07293.insertBiodata(mahasiswaEntity_07293);
    }

    public ArrayList<MahasiswaEntity_07293> getbyid(int cek) {
        return AllObjectModel_07293.mahasiswaModel_07293.getData();
    }

    public ArrayList<MahasiswaEntity_07293> ambilbyid(int id){
        return AllObjectModel_07293.mahasiswaModel_07293.cari(id);
    }

    public ArrayList<MahasiswaEntity_07293> getdataMAHASISWA(){
        return AllObjectModel_07293.mahasiswaModel_07293.getData();
    }


    public DefaultTableModel daftarMahasiswa(){
        DefaultTableModel dataDaftarMahasiswa = new DefaultTableModel();
        Object[] kolom = {"ID", "NAMA", "NOTELP", "ALAMAT", "KELAS"};
        dataDaftarMahasiswa.setColumnIdentifiers(kolom);
        int size = getMahasiswa().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293().get(i).getId();
            data[1] = AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293().get(i).getNama();
            data[2] = AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293().get(i).getNo_telp();
            data[3] = AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293().get(i).getAlamat();
            data[4] = AllObjectModel_07293.mahasiswaModel_07293.getMahasiswa_07293().get(i).getKelas();
            dataDaftarMahasiswa.addRow(data);
        }
        return dataDaftarMahasiswa;
    }
}
