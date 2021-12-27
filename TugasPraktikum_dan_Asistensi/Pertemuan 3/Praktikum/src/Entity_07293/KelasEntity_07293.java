package Entity_07293;

import java.util.ArrayList;

public class KelasEntity_07293 {
    public KelasEntity_07293(){}
    public ArrayList<String> daftarKelas(){
        ArrayList<String> kelas = new ArrayList<String>();
        kelas.add("Pemula English");
        kelas.add("Menangah English");
        kelas.add("Profesional English");
        return kelas;
    }

    public void lihatKelas(){
        int i = 0;
        for(String Kelas : daftarKelas()){
            System.out.println((i)+". "+Kelas);
            i++;
        }
    }

}
