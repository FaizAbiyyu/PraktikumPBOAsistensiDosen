package Entitiy07293;

public class OwnerEntity07293 extends BiodataEntity07293{
    private String Password07293;

    public OwnerEntity07293(String Password07293, String nama07293, String alamat07293, String NoTelp07293) {
        super(nama07293,alamat07293,NoTelp07293);
        this.Password07293 = Password07293;
    }

    public String getPassword07293() {
        return Password07293;
    }

    public void setPassword07293(String password07293) {
        Password07293 = password07293;
    }
}