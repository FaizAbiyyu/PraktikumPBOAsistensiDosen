package Entity;

public class ManusiaEntity {
//    protected int id;
    protected String nama, notelp;

    public ManusiaEntity(String nama, String notelp){
        this.nama = nama;
        this.notelp = notelp;
    }

    public ManusiaEntity() {
    }

    public String getNama() {
        return nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public String setNama(String nama) {
        this.nama = nama;
        return nama;
    }

    public String setNotelp(String notelp) {
        this.notelp = notelp;
        return notelp;
    }
}
