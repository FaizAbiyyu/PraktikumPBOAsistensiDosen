package Controller_07293;

import Entity_07293.PembeliEntity07293;

import java.util.ArrayList;

public class PembeliController_07293 {

    public void insertpembeli(String nama, String notelp , String idGame, String akun){
        PembeliEntity07293 pembelien = new PembeliEntity07293();
        pembelien.setNama(nama);
        pembelien.setNotelp(notelp);
        pembelien.setIDGame(idGame);
        pembelien.setNamaAkun(akun);
        ObjectModelController_07293.pembeliMo.insert(pembelien);
    }

    public PembeliEntity07293 showpembelibyid(int id){
        return ObjectModelController_07293.pembeliMo.getpembelibyid(id);
    }

    public ArrayList<PembeliEntity07293> showpembeli(){
        return ObjectModelController_07293.pembeliMo.getPembeli();
    }


}
