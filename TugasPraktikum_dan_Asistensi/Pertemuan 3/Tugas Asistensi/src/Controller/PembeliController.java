package Controller;

import Entity.PembeliEntity;

import java.util.ArrayList;

public class PembeliController {

    public void insertpembeli(String nama, String notelp , String idGame, String akun){
        PembeliEntity pembelien = new PembeliEntity();
        pembelien.setNama(nama);
        pembelien.setNotelp(notelp);
        pembelien.setIDGame(idGame);
        pembelien.setNamaAkun(akun);
        ObjectModelController.pembeliMo.insert(pembelien);
    }

    public PembeliEntity showpembelibyid(int id){
        return ObjectModelController.pembeliMo.getpembelibyid(id);
    }

    public ArrayList<PembeliEntity> showpembeli(){
        return ObjectModelController.pembeliMo.getPembeli();
    }


}
