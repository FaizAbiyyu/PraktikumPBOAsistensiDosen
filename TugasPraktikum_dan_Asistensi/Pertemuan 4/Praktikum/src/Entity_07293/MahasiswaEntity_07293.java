package Entity_07293;

public class MahasiswaEntity_07293 extends BiodataEntity_07293{
    private String alamat,kelas;

    public MahasiswaEntity_07293(String nama, String noTelp, String alamat, String kelas){
        super(nama,noTelp);
        this.alamat = alamat;
        this.kelas = kelas;
    }

    public MahasiswaEntity_07293(){}

    public String getAlamat() {
        return alamat;
    }
    public String getKelas() {
        return kelas;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
