package Controller_07293;

import Entity_07293.AdminEntity_07293;
import Entity_07293.ProdukEntity_07293;
import Entity_07293.TransaksiEntity07293;

public class AdminContorller_07293 {

    public AdminContorller_07293(){}

    public void insertdata(String nama , String notelp, String idAdmin, String pass){
        AdminEntity_07293 adminEntity_07293 = new AdminEntity_07293();
        adminEntity_07293.setNama(nama);
        adminEntity_07293.setNama(notelp);
        adminEntity_07293.setIdAdmin(idAdmin);
        adminEntity_07293.setPass(pass);
        ObjectModelController_07293.adminMo.insertAdmin(adminEntity_07293);
    }

    public int login(String idAdmin, String pass){
        int log = ObjectModelController_07293.adminMo.cekData(idAdmin,pass);
        return log;
    }

    public AdminEntity_07293 adminEntity(){
        return null;
    }

    public void ubahStatus(int id){
        TransaksiEntity07293 transaksi = new TransaksiEntity07293();
        transaksi.setNomortrx(id);
        ObjectModelController_07293.adminMo.ubahstatus(id);
    }

    public void updatenamaPem(String nama, int  id){
        TransaksiEntity07293 transaksiEntity_07293 = new TransaksiEntity07293();
        transaksiEntity_07293.setNama(nama);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController_07293.transaksiMo.updateNamaPembeli(nama,id);
    }

    public void updatenoPem(String nopem, int id ){
        TransaksiEntity07293 transaksiEntity_07293 = new TransaksiEntity07293();
        transaksiEntity_07293.setNotelp(nopem);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController_07293.transaksiMo.updateNoPembeli(nopem,id);
    }

    public void updateidGame(String idgame, int id){
        TransaksiEntity07293 transaksiEntity_07293 = new TransaksiEntity07293();
        transaksiEntity_07293.setIDGame(idgame);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController_07293.transaksiMo.updateidGame(idgame,id);
    }

    public void updatenamaAkun(String akun, int id){
        TransaksiEntity07293 transaksiEntity_07293 = new TransaksiEntity07293();
        transaksiEntity_07293.setNamaAkun(akun);
        transaksiEntity_07293.setNomortrx(id);
        ObjectModelController_07293.transaksiMo.updatenamaAkun(akun,id);
    }

    //PRODUK
    public void updateNominal(int nom, int id){
        ProdukEntity_07293 produkEntity_07293 = new ProdukEntity_07293();
        produkEntity_07293.setNominal(nom);
        produkEntity_07293.setId(id);
        ObjectModelController_07293.transaksiMo.updateNominal(nom,id);
    }

    public void updateHarga(int harga,int id){
        ProdukEntity_07293 produkEntity_07293 = new ProdukEntity_07293();
        produkEntity_07293.setHarga(harga);
        produkEntity_07293.setId(id);
        ObjectModelController_07293.transaksiMo.updateharga(harga,id);
    }

    public void updateProduk(String produk, int id){
        ProdukEntity_07293 produkEntity07293 = new ProdukEntity_07293();
        produkEntity07293.setProduk(produk);
        produkEntity07293.setId(id);
        ObjectModelController_07293.transaksiMo.updateproduk(produk,id);
    }

    public void deletetrx(int nomortrx){
        ObjectModelController_07293.transaksiMo.delete(nomortrx);
    }
    public void updatePass(String pass, int id){
        ObjectModelController_07293.adminMo.updatepass(pass,id);
    }

}
