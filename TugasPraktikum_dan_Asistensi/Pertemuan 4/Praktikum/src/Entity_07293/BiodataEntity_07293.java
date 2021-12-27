package Entity_07293;

public abstract class BiodataEntity_07293 {
    protected int id;
    protected String nama,no_telp;

    public BiodataEntity_07293(){}

    public BiodataEntity_07293(String nama, String no_telp){
        this.nama = nama;
        this.no_telp = no_telp;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
