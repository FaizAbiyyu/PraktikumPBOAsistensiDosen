import Entity.MataKuliahEntity;
import Entity.NilaiMataKuliah;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * membuat Program Seperti TAsistensiPBO dengan
 * MataKuliah
 * - nama: String
 *
 * NilaiMataKuliah
 * - mataKuliah: MataKuliah
 * - nilai: float
 */

public class TADosenPBO {
    private static Scanner input_07293 = new Scanner(System.in);
    private static ArrayList<NilaiMataKuliah> listMataKuliah_07293 = new ArrayList<>();
    private static int jumlahmk_07293;

    public static void main(String[] args) {
        System.out.print("Masukkan Jumlah data : ");
        jumlahmk_07293 = input_07293.nextInt();
        int i_07293 = 0;
        int Pil_07293;
        do {
            System.out.print("Masukkan Nama MataKuliah : ");
            String nama_07293 = input_07293.next();
            System.out.print("Masukkan Nilai : ");
            float nilai_07293 = input_07293.nextFloat();
            NilaiMataKuliah temp = new NilaiMataKuliah();
            temp.setNilaiMK(nilai_07293);
            temp.setMataKuliah(new MataKuliahEntity(nama_07293));
            listMataKuliah_07293.add(temp);
            i_07293++;
        }while (i_07293 < jumlahmk_07293);

        do {
            System.out.println("\n===================================");
            System.out.println("1. Urutkan Nilai dari yang terkecil");
            System.out.println("2. Tampilkan Rata-Rata");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            Pil_07293 = input_07293.nextInt();
            switch (Pil_07293) {
                case 1 :
                    tukar(listMataKuliah_07293);
                    System.out.println();
                    for(int k=0;k<listMataKuliah_07293.size();k++){
                        System.out.println("Nama MataKuliah : " + listMataKuliah_07293.get(k).getMataKuliah().getNama_07293());
                        System.out.println("Nilai MataKuliah : " + listMataKuliah_07293.get(k).getNilaiMK());
                    }
                    break;
                case 2 :
                    System.out.println("Rata - Rata : " +hitung(listMataKuliah_07293));
                    break;
            }
        }while (Pil_07293 != 0);
    }

    static float hitung(ArrayList<NilaiMataKuliah> list){
        float total_07293 = 0;

        for(int i=0;i<list.size();i++)
            total_07293 += list.get(i).getNilaiMK();

        return total_07293 / list.size();
    }

    static void tukar(ArrayList<NilaiMataKuliah> urut){
        for (int i = 0; i < jumlahmk_07293; i++) {
            for (int j = 0; j < jumlahmk_07293; j++) {
                if (urut.get(i).getNilaiMK()<urut.get(j).getNilaiMK()) {
                    float temp1 = urut.get(i).getNilaiMK();
                    urut.get(i).setNilaiMK(urut.get(j).getNilaiMK());
                    urut.get(j).setNilaiMK(temp1);
                    MataKuliahEntity temp2 = urut.get(i).getMataKuliah();
                    urut.get(i).setMataKuliah(urut.get(j).getMataKuliah());
                    urut.get(j).setMataKuliah(temp2);
                }
            }
        }
    }
}
