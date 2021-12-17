package Entity_07293;

public class MahasiswaEntity_07293 extends BiodataEntity_07293{
    public int id;
    private String alamat,kelas;

    public MahasiswaEntity_07293(String nama, String noTelp, String alamat){
        super(nama,noTelp);
        this.alamat = alamat;
    }

    public MahasiswaEntity_07293(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}

