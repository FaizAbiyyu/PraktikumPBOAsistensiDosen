import java.util.Scanner;

public class App_07293 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int pil;
        do{
            System.out.println("Selamat Datang di KampoengInggris");
            System.out.println("1. Registrasi Kursus");
            System.out.println("2. Lihat Data Siswa");
            System.out.println("3. Edit Data Siswa");
            System.out.println("4. Hapus Data Siswa");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan: ");
            pil = input.nextInt();
            input.nextLine();

            switch (pil){
                case 1 -> Pendaftaran_07293.Registrasi();
                case 2 -> Pendaftaran_07293.Lihat();
                case 3 -> Pendaftaran_07293.Edit();
                case 4 -> Pendaftaran_07293.Hapus();
            }
        }while (pil != 5);
    }

}
