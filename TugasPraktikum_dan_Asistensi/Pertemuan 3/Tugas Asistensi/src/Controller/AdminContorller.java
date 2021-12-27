package Controller;

import Entity.AdminEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;

public class AdminContorller {

    public AdminContorller(){}

    public void insertdata(String nama , String notelp, String idAdmin, String pass){
        AdminEntity adminEntity_07293 = new AdminEntity();
        adminEntity_07293.setNama(nama);
        adminEntity_07293.setNama(notelp);
        adminEntity_07293.setIdAdmin(idAdmin);
        adminEntity_07293.setPass(pass);
        ObjectModelController.adminMo.insertAdmin(adminEntity_07293);
    }

    public int login(String idAdmin, String pass){
        int log = ObjectModelController.adminMo.cekData(idAdmin,pass);
        return log;
    }

    public AdminEntity adminEntity(){
        return null;
    }

    public void ubahStatus(int id){
        TransaksiEntity transaksi = new TransaksiEntity();
        transaksi.setNomortrx(id);
        ObjectModelController.adminMo.ubahstatus(id);
    }

    public void updatenamaPem(String nama, int  id){
        TransaksiEntity transaksiEntity_07293 = new TransaksiEntity();
        transaksiEntity_07293.setNama(nama);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController.transaksiMo.updateNamaPembeli(nama,id);
    }

    public void updatenoPem(String nopem, int id ){
        TransaksiEntity transaksiEntity_07293 = new TransaksiEntity();
        transaksiEntity_07293.setNotelp(nopem);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController.transaksiMo.updateNoPembeli(nopem,id);
    }

    public void updateidGame(String idgame, int id){
        TransaksiEntity transaksiEntity_07293 = new TransaksiEntity();
        transaksiEntity_07293.setIDGame(idgame);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController.transaksiMo.updateidGame(idgame,id);
    }

    public void updatenamaAkun(String akun, int id){
        TransaksiEntity transaksiEntity_07293 = new TransaksiEntity();
        transaksiEntity_07293.setNamaAkun(akun);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController.transaksiMo.updatenamaAkun(akun,id);
    }

    //PRODUK
    public void updateNominal(int nom, int id){
        ProdukEntity produkEntity_07293 = new ProdukEntity();
        produkEntity_07293.setNominal(nom);
        produkEntity_07293.setId(id);
        ObjectModelController.transaksiMo.updateNominal(nom,id);
    }

    public void updateHarga(int harga,int id){
        ProdukEntity produkEntity_07293 = new ProdukEntity();
        produkEntity_07293.setHarga(harga);
        produkEntity_07293.setId(id);
        ObjectModelController.transaksiMo.updateharga(harga,id);
    }

    public void updateProduk(String produk, int id){
        ProdukEntity produkEntity = new ProdukEntity();
        produkEntity.setProduk(produk);
        produkEntity.setId(id);
        ObjectModelController.transaksiMo.updateproduk(produk,id);
    }

    public void deletetrx(int nomortrx){
        ObjectModelController.transaksiMo.delete(nomortrx);
    }
    public void updatePass(String pass, int id){
        ObjectModelController.adminMo.updatepass(pass,id);
    }

}
