import Controller_07293.MahasiswaController_07293;
import Entity_07293.KelasEntity_07293;

import java.util.Scanner;

public class Pendaftaran_07293 {
    public static Scanner input = new Scanner(System.in);
    public static MahasiswaController_07293 mahasiswaCon = new MahasiswaController_07293();
    public static KelasEntity_07293 kelas = new KelasEntity_07293();

    static void Registrasi(){
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NoTelp: ");
        String no_telp = input.nextLine();
        System.out.print("Masukkan Alamat: ");
        String alamat = input.nextLine();
        System.out.println("Kelas Yang Tersedia");
        kelas.lihatKelas();
        System.out.print("Pilih Kelas: ");
        int pil = input.nextInt();
        mahasiswaCon.insertData(nama,no_telp,alamat,pil);
        input.nextLine();
    }
    static void Lihat(){
        mahasiswaCon.showData();
    }
    static void Edit(){
        System.out.print("Masukkan id yang ingin diedit: ");
        int id = input.nextInt();
        mahasiswaCon.updateData(id);
    }
    static void Hapus(){
        System.out.print("Masukkan id yang ingin dihapus: ");
        int id = input.nextInt();
        mahasiswaCon.deleteData(id);
    }

}
