package Entity_07293;

public class BiodataEntity_07293 {
    private String nama,no_telp;

    public BiodataEntity_07293(String nama, String no_telp){
        this.nama = nama;
        this.no_telp = no_telp;
    }

    public BiodataEntity_07293(){}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

}
