package Entity_07293;

public class PembeliEntity07293 extends ManusiaEntity_07293 {
    public String IDGame,namaAkun;

//    public PembeliEntity(String nama, String notelp, String IDGame, String namaAkun) {
//        super(nama, notelp);
//        this.IDGame = IDGame;
//        this.namaAkun = namaAkun;
//    }

    public PembeliEntity07293(){}

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public String getNotelp() {
        return super.getNotelp();
    }

    public String getIDGame() {
        return IDGame;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public String setIDGame(String IDGame) {
        this.IDGame = IDGame;
        return IDGame;
    }

    public String setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
        return namaAkun;
    }
}
