package Controller_07293;

import Entity_07293.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TransaksiController_07293 {

    public TransaksiController_07293(){}

    public void insertDataPembeli(String nama,String notelp, String idGame,String akun, String namaProduk, int nominal,  int harga ){
        TransaksiEntity07293 transaksiEntity_07293 = new TransaksiEntity07293();
        transaksiEntity_07293.setNama(nama);
        transaksiEntity_07293.setNotelp(notelp);
        transaksiEntity_07293.setIDGame(idGame);
        transaksiEntity_07293.setNamaAkun(akun);
        transaksiEntity_07293.setProduk(namaProduk);
        transaksiEntity_07293.setNominal(nominal);
        transaksiEntity_07293.setHarga(harga);
        ObjectModelController_07293.transaksiMo.insertDataPembeli(transaksiEntity_07293);
    }

    public ArrayList<ProdukEntity_07293> showproduk(){
        return ObjectModelController_07293.transaksiMo.getProduk();
    }

    public ProdukEntity_07293 showprodukbyid(int nomortrx){
        return ObjectModelController_07293.transaksiMo.produkbyid(nomortrx);
    }

    public ArrayList<TransaksiEntity07293> transaksibyidgame(int idgame){
        return ObjectModelController_07293.transaksiMo.cari(idgame);
    }

    public void insertProduk( String namaProduk,int nominal, int harga){
        ProdukEntity_07293 produkEntity_07293 = new ProdukEntity_07293();
        produkEntity_07293.setProduk(namaProduk);
        produkEntity_07293.setNominal(nominal);
        produkEntity_07293.setHarga(harga);
        ObjectModelController_07293.transaksiMo.insertProduk(produkEntity_07293);
    }

    public ArrayList<TransaksiEntity07293> getPembeliEn(){
        return ObjectModelController_07293.transaksiMo.getpembeli();
    }

    public ArrayList<TransaksiEntity07293> getdatatransaksi(){
        return ObjectModelController_07293.transaksiMo.gettransaksiall();
    }

    public DefaultTableModel daftartransaksi(){
        DefaultTableModel daftartransaksi = new DefaultTableModel();
        Object[] kolom = {"NO", "STATUS", "NAMA", "NO.TELP", "ID GAME", "PRODUK", "NOMINAL", "HARGA"};
        daftartransaksi.setColumnIdentifiers(kolom);
        int size = getdatatransaksi().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[8];
            data[0] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getNomortrx();
            data[1] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getStatus();
            data[2] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getNama();
            data[3] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getNotelp();
            data[4] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getIDGame();
            data[5] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getProduk();
            data[6] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getNominal();
            data[7] = ObjectModelController_07293.transaksiMo.gettransaksiall().get(i).getHarga();
            daftartransaksi.addRow(data);
        }
        return daftartransaksi;
    }

    public DefaultTableModel daftarproduk(){
        DefaultTableModel daftarproduk = new DefaultTableModel();
        Object[] kolom = {"ID", "PRODUK", "NOMINAL", "HARGA"};
        daftarproduk.setColumnIdentifiers(kolom);
        int size = showproduk().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[4];
            data[0] = ObjectModelController_07293.transaksiMo.getProduk().get(i).getId();
            data[1] = ObjectModelController_07293.transaksiMo.getProduk().get(i).getProduk();
            data[2] = ObjectModelController_07293.transaksiMo.getProduk().get(i).getNominal();
            data[3] = ObjectModelController_07293.transaksiMo.getProduk().get(i).getHarga();
            daftarproduk.addRow(data);
        }
        return daftarproduk;
    }
}
