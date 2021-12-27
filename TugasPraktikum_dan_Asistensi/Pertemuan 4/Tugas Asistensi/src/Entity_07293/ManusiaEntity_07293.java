package Entity_07293;

public class ManusiaEntity_07293 {
//    protected int id;
    protected String nama, notelp;

    public ManusiaEntity_07293(String nama, String notelp){
        this.nama = nama;
        this.notelp = notelp;
    }

    public ManusiaEntity_07293() {
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
