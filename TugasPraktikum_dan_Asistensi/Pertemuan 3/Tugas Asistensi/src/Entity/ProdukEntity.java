package Entity;

public class ProdukEntity {
    public int id;
    public String produk;
    public int nominal;
    public int harga;

    public ProdukEntity( String produk,int nominal, int harga){
        this.produk = produk;
        this.nominal = nominal;
        this.harga= harga;
    }

    public ProdukEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNominal() {
        return nominal;
    }

    public String getProduk() {
        return produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
