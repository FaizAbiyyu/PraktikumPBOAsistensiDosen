package Controller;

import Entity.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TransaksiController {

    public TransaksiController(){}

    public void insertDataPembeli(String nama,String notelp, String idGame,String akun, String namaProduk, int nominal,  int harga ){
        TransaksiEntity transaksiEntity_07293 = new TransaksiEntity();
        transaksiEntity_07293.setNama(nama);
        transaksiEntity_07293.setNotelp(notelp);
        transaksiEntity_07293.setIDGame(idGame);
        transaksiEntity_07293.setNamaAkun(akun);
        transaksiEntity_07293.setProduk(namaProduk);
        transaksiEntity_07293.setNominal(nominal);
        transaksiEntity_07293.setHarga(harga);
        ObjectModelController.transaksiMo.insertDataPembeli(transaksiEntity_07293);
    }

    public ArrayList<ProdukEntity> showproduk(){
        return ObjectModelController.transaksiMo.getProduk();
    }

    public ProdukEntity showprodukbyid(int nomortrx){
        return ObjectModelController.transaksiMo.produkbyid(nomortrx);
    }

    public ArrayList<TransaksiEntity> transaksibyidgame(int idgame){
        return ObjectModelController.transaksiMo.cari(idgame);
    }

    public void insertProduk( String namaProduk,int nominal, int harga){
        ProdukEntity produkEntity_07293 = new ProdukEntity();
        produkEntity_07293.setProduk(namaProduk);
        produkEntity_07293.setNominal(nominal);
        produkEntity_07293.setHarga(harga);
        ObjectModelController.transaksiMo.insertProduk(produkEntity_07293);
    }

    public ArrayList<TransaksiEntity> getPembeliEn(){
        return ObjectModelController.transaksiMo.getpembeli();
    }

    public ArrayList<TransaksiEntity> getdatatransaksi(){
        return ObjectModelController.transaksiMo.gettransaksiall();
    }

    public DefaultTableModel daftartransaksi(){
        DefaultTableModel daftartransaksi = new DefaultTableModel();
        Object[] kolom = {"NO", "STATUS", "NAMA", "NO.TELP", "ID GAME", "PRODUK", "NOMINAL", "HARGA"};
        daftartransaksi.setColumnIdentifiers(kolom);
        int size = getdatatransaksi().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[8];
            data[0] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getNomortrx();
            data[1] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getStatus();
            data[2] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getNama();
            data[3] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getNotelp();
            data[4] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getIDGame();
            data[5] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getProduk();
            data[6] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getNominal();
            data[7] = ObjectModelController.transaksiMo.gettransaksiall().get(i).getHarga();
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
            data[0] = ObjectModelController.transaksiMo.getProduk().get(i).getId();
            data[1] = ObjectModelController.transaksiMo.getProduk().get(i).getProduk();
            data[2] = ObjectModelController.transaksiMo.getProduk().get(i).getNominal();
            data[3] = ObjectModelController.transaksiMo.getProduk().get(i).getHarga();
            daftarproduk.addRow(data);
        }
        return daftarproduk;
    }
}
