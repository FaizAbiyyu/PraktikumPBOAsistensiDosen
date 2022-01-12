package Entity_07293;

public class TransaksiEntity_07293 extends ManusiaEntity_07293 {
    public int nomortrx;
    public int status;
    public String idGame,namaAkun;
    public String produk;
    public int nominal,harga;

    public TransaksiEntity_07293(int nomortrx, int status ){
        this.nomortrx = nomortrx;
        this.status = status;
    }

    public TransaksiEntity_07293(){}

    public int getNomortrx() {
        return nomortrx;
    }

    public int getStatus() {
        return status;
    }

    public PembeliEntity_07293 getPembeli() {
        PembeliEntity_07293 pembeli = new PembeliEntity_07293();
        pembeli.getNama();
        pembeli.getNotelp();
        pembeli.getIDGame();
        pembeli.getNamaAkun();
        return pembeli;
    }

    public String getNama() {
        return super.getNama();
    }

    @Override
    public String getNotelp() {
        return super.getNotelp();
    }

    public String getIDGame() {
        return idGame;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public String setIDGame(String IDGame) {
        this.idGame = IDGame;
        return IDGame;
    }

    public String setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
        return namaAkun;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public void setNomortrx(int nomortrx) {
        this.nomortrx = nomortrx;
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
