package Entity;

import java.util.ArrayList;

public class NilaiMataKuliah {
    private float NilaiMK;
    private MataKuliahEntity mataKuliah;

    public float getNilaiMK() {
        return NilaiMK;
    }

    public void setNilaiMK(float nilaiMK) {
        NilaiMK = nilaiMK;
    }

    public MataKuliahEntity getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliahEntity mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public float hitungNilai(ArrayList<Float>listNilai){
        for (int i = 0;i < listNilai.size(); i++){
            NilaiMK = listNilai.get(i);
        }
        return NilaiMK / listNilai.size();
    }

}
