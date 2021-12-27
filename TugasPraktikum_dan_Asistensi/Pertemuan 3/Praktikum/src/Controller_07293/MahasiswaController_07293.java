package Controller_07293;

public class MahasiswaController_07293 {
    public void insertData(String nama, String no_telp, String alamat, int pil){
        AllObjectModel_07293.mahasiswaModel_07293.insertBiodata(nama, no_telp, alamat, pil);
    }
    public void showData(){
        AllObjectModel_07293.mahasiswaModel_07293.showData();
    }
    public void updateData(int id){
        AllObjectModel_07293.mahasiswaModel_07293.updateData(id);
    }
    public void deleteData(int id){
        AllObjectModel_07293.mahasiswaModel_07293.deleteData(id);
    }

}
