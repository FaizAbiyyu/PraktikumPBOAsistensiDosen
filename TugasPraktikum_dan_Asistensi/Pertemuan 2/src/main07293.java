import Entitiy07293.SizeEntity;
import Proses07293.*;
import Entitiy07293.JenisSepatuEntity07293;

import java.util.Scanner;

public class main07293 {
    private static Scanner input = new Scanner(System.in);
    private static OwnerProses07293 prosesOwner = new OwnerProses07293();
    private static SepatuProses07293 prosesSepatu = new SepatuProses07293();
    private static int pilJenis;
    private static int cekOwner;

    public static void main(String[] args) {
        dataOwner();
        int pil;
        do {
            System.out.println("Jumlah Sepatu : " + SepatuProses07293.jumSepatu);
            System.out.println("1. Login Owner");
            System.out.println("2. Lihat Sepatu Terdaftar");
            System.out.println("3. Lihat Biodata Owner");
            System.out.println("0. exit");
            System.out.print("Masukkan Pilihan : ");
            pil = input.nextInt();
            input.nextLine();
            switch (pil){
                case 1:
                    loginOwner();
                    break;
                case 2:
                    prosesOwner.view();
                    break;
                case 3 :
                    prosesSepatu.view();
                    break;
            }
        }while (pil != 0 );
    }

    static void dataOwner(){
        String namaOwner[] = {"KimRaKha", "faiz"};
        String pasOwner[] = {"01", "02"};
        String noTelpOwner[] = {"081xx", "082xx"};
        String alamat[] = {"Jl.a", "Jl.b"};
        prosesOwner.insert(pasOwner, namaOwner, alamat, noTelpOwner);
    }

    static void loginOwner(){
        System.out.print("Nama : ");
        String namaOwner07293 = input.next();
        System.out.print("Password : ");
        String passOwner07393 = input.next();
        cekOwner = prosesOwner.cekData(namaOwner07293, passOwner07393);

        System.out.println("Selamat datang " + OwnerProses07293.getOwner07293()[cekOwner].getNama07293());
        int pil;
        do {
            System.out.println("Jumlah Sepatu : " +SepatuProses07293.jumSepatu);
            System.out.println("1. Tambah Sepatu ");
            System.out.println("2. Ubah Data Sepatu ");
            System.out.println("3. Lihat Sepatu Terdaftar ");
            System.out.println("4. Hapus Sepatu");
            System.out.println("0. exit");
            System.out.print("Masukkan Pilihan : ");
            pil = input.nextInt();
            input.nextLine();

            switch (pil){
                case 1 :
                    tambahSepatu();
                    break;
                case 2 :
                    prosesSepatu.update();
                    break;
                case 3 :
                    prosesSepatu.view();
                    break;
                case 4 :
                    prosesSepatu.delete();
                    break;
            }
        }while (pil != 0);
    }

    static void tambahSepatu(){
        System.out.print("Size Sepatu : ");
        double size07293 = input.nextDouble();
        prosesSepatu.insert(size07293);
        insertJenis();
    }

    static void insertJenis(){
        input.nextLine();
        System.out.println("Jenis Sepatu : ");
        for (int i = 0; i < JenisSepatuEntity07293.jenis.length; i++){
            System.out.println(i+". " + JenisSepatuEntity07293.jenis[i]);
        }
        System.out.println("Pilih Nama Sepatu");
        pilJenis = input.nextInt();

        System.out.println("Input KodeSepatu : ");
        String KodeSepatu = input.next();

        prosesSepatu.insert(prosesSepatu.getSizeEntities()[SepatuProses07293.jumSepatu], pilJenis, KodeSepatu );
    }
}
