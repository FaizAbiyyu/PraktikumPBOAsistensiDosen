package Proses07293;

import Entitiy07293.SizeEntity;
import Entitiy07293.SepatuTerdaftarEntity07293;
import Entitiy07293.JenisSepatuEntity07293;
import java.util.Scanner;

public class SepatuProses07293 implements Interface07293{
    private static Scanner input = new Scanner(System.in);
    private static SepatuTerdaftarEntity07293[] sepatuTerdaftar
            = new SepatuTerdaftarEntity07293[100];
    private static SizeEntity[] sizeEntities
            = new SizeEntity[100];
    public static int jumSepatu = 0;

    public static SepatuTerdaftarEntity07293[] getSepatuTerdaftar() {
        return sepatuTerdaftar;
    }

    public SizeEntity[] getSizeEntities() {
        return sizeEntities;
    }

    public void insert(double size07293){
        sizeEntities[jumSepatu] = new SizeEntity(size07293);
    }

    public void insert(SizeEntity sizeEntity07293, int indexJenis07293,
                       String KodeSepatu07293){
        sepatuTerdaftar[jumSepatu]= new SepatuTerdaftarEntity07293(sizeEntity07293,
                indexJenis07293,KodeSepatu07293);
        jumSepatu +=1;
    }

    @Override
    public void view(){
        if(jumSepatu == 0){
            System.out.println("Belum ada Sepatu yang dimasukkan");
        }else{
            for (int i = 0; i <jumSepatu ; i++){
                System.out.println("===========================");
                System.out.println("Kode Rak Sepatu : " + sepatuTerdaftar[i].getKodeSepatu07293());
                System.out.println("===========================");
                System.out.println("Size Sepatu : " + sizeEntities[i].getSize07293()
                        + "\nNama Sepatu : " + JenisSepatuEntity07293.jenis[sepatuTerdaftar[i].getIndexJenis07293()]);
                System.out.println("===========================");
            }
        }
    }

    public void update(){
        System.out.print("Masukkan Kode Sepatu : " );
        String search = input.next();
        int cari = 0;
        do {
            if (cari == jumSepatu ){
                System.err.println("Tidak ada data");
                break;
            }else if(sepatuTerdaftar[cari].getKodeSepatu07293().equals(search)){
                int pilup;
                do {
                    System.out.println("Pilih daa yang akan di edit : ");
                    System.out.println("1. Lihat Biodata");
                    System.out.println("2. Size Sepatu");
                    System.out.println("3. Nama Sepatu");
                    System.out.println("0. exit");
                    System.out.print("Masukkan Pilihan : ");
                    pilup = input.nextInt();
                    input.nextLine();
                    if (pilup == 1 ){
                        System.out.println("========================");
                        System.out.println("Kode Peserta : " + sepatuTerdaftar[cari].getKodeSepatu07293());
                        System.out.println("=========================");
                        System.out.println("Size Sepatu : " + sizeEntities[cari].getSize07293() +
                                "\nNama Sepatu : " + JenisSepatuEntity07293.jenis[sepatuTerdaftar[cari].getIndexJenis07293()]);
                        System.out.println("=======================");
                    }else if (pilup == 2){
                        System.out.print("Ubah Size Sepatu : ");
                        double editSize = input.nextInt();
                        sizeEntities[cari].setSize07293(editSize);
                    }else if (pilup == 3){
                        System.out.println("Ubah Nama Sepatu : ");
                        for (int i = 0; i < JenisSepatuEntity07293.jenis.length; i++){
                            System.out.println(i + ". " + JenisSepatuEntity07293.jenis[i]);
                        }
                        System.out.print("Pilih Nama Sepatu : ");
                        int editNama = input.nextInt();
                        sepatuTerdaftar[cari].setIndexJenis07293(editNama);
                    }
                }while (pilup != 0);
                break;
            }else {
                cari +=1;
            }
        }while (true);
    }

    public void delete(){
        System.out.println("Masukkan Kode Sepatu yang akan dihapus : ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do {
            if (cari == jumSepatu){
                System.err.println("Tidak Ada Sepatu");
            }else if (sepatuTerdaftar[cari].getKodeSepatu07293().equals(search)){
                if (cari == jumSepatu-1){
                    jumSepatu-=1;
                }else {
                    for (int i = cari; i< jumSepatu;i++){
                        sepatuTerdaftar[i] = sepatuTerdaftar[i+1];
                        sizeEntities[i] = sizeEntities[i+1];
                    }
                    jumSepatu -=1;
                }
                break;
            }else {
                cari +=1;
            }
        }while (true);
    }
}
