package Entity;

public class AdminEntity extends ManusiaEntity{
    public String idAdmin,pass;

    public AdminEntity(String nama,String notelp, String idAdmin, String pass){
        super(nama,notelp);
        this.idAdmin = idAdmin;
        this.pass = pass;
    }

    public AdminEntity(){}

    @Override
    public String getNama() {
        return super.getNama();
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public String getPass() {
        return pass;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
