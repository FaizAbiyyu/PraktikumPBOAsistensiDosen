package Entitiy07293;

public abstract class BiodataEntity07293 {
        protected String nama07293, alamat07293, NoTelp07293;

        public BiodataEntity07293(String nama07293, String alamat07293, String NoTelp07293){
            this.nama07293 = nama07293;
            this.alamat07293 = alamat07293;
            this.NoTelp07293 = NoTelp07293;
        }

    public String getNama07293() {
        return nama07293;
    }

    public String getAlamat07293() {
        return alamat07293;
    }

    public String getNoTelp07293() {
        return NoTelp07293;
    }

    public void setNama07293(String nama07293) {
        this.nama07293 = nama07293;
    }

    public void setAlamat07293(String alamat07293) {
        this.alamat07293 = alamat07293;
    }

    public void setNoTelp07293(String noTelp07293) {
        this.NoTelp07293 = noTelp07293;
    }
}
