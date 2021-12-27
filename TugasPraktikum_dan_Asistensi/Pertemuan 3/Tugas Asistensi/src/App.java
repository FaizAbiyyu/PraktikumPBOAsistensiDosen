import Controller.AdminContorller;
import Controller.ObjectModelController;
import Controller.PembeliController;
import Controller.TransaksiController;
import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;

import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);
    public static TransaksiController transaksi = new TransaksiController();
    public static PembeliController pembeli = new PembeliController();
    public static AdminContorller admin = new AdminContorller();

    public static void main(String[] args) {

        int pilih;
        do {
            System.out.println("Selamat datang di minishop");
            System.out.println("1. Login Admin\n" +
                    "2. Beli Voucher\n" +
                    "3. Lihat Produk\n" +
                    "4. keluar\n" +
                    "Masukkan pilihan : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1->loginAdmin();
                case 2->inserDataPembeli1();
                case 3->showDataProduk();
            }
        }while (pilih <= 3);
    }

    public static void showDataProduk(){
        for (ProdukEntity p: transaksi.showproduk()) {
            System.out.println("===================================");
            System.out.println("Nama Produk = " +p.produk);
            System.out.println("Nominal Produk = " +p.nominal);
            System.out.println("Harga Produk = " +p.harga);
        }
    }

    public static void showDataProdukbyid(int id){
            ProdukEntity p = transaksi.showprodukbyid(id);
            System.out.println("===================================");
            System.out.println("ID Produk = " +p.id);
            System.out.println("Nama Produk = " +p.produk);
            System.out.println("Nominal Produk = " +p.nominal);
            System.out.println("Harga Produk = " +p.harga);
            System.out.println("===================================");
    }

    public static void showDataPembeli(int cek){
        PembeliEntity pe = pembeli.showpembelibyid(cek);
        System.out.println("===================================");
        System.out.println("Nama = " +pe.IDGame);
        System.out.println("Nama Produk = " +pe.namaAkun);
        System.out.println("===================================");
    }

    public static void showDataPembeli(){
        for (TransaksiEntity pem: transaksi.getdatatransaksi()) {
            System.out.println("===================================");
            System.out.println("id = " + pem.getNomortrx());
            System.out.println("Nama = " + pem.getNama());
            System.out.println("No Telp = " + pem.getNotelp());
            System.out.println("ID Game = " + pem.getIDGame());
            System.out.println("NAMA Akun = " + pem.getNamaAkun());
            System.out.println("produk = " + pem.getProduk());
            System.out.println("nominal = " + pem.getNominal());
            System.out.println("Harga = " + pem.getHarga());
            System.out.print("Status = ");
            if (pem.getStatus() == 0){
                System.out.println("Belum diproses");
            }else {
                System.out.println("Sudah DiProses");
            }
        }
    }

    static void inserDataPembeli1(){
        showDataProduk();
        System.out.print("Nama = ");
        String nama = input.next();
        System.out.print("notelp = ");
        String notelp = input.next();
        System.out.print("IDGame = ");
        String ign = input.next();
        System.out.print("Nama Akun = ");
        String akun = input.next();
        System.out.println("Nama Produk = ");
        String produk = input.next();
        System.out.println("Nominal = ");
        int nominal = input.nextInt();
        System.out.println("Harga = ");
        int harga = input.nextInt();
        ObjectModelController.pembeliCon.insertpembeli(nama,notelp,ign,akun);
        ObjectModelController.transaksiCon.insertDataPembeli(nama,notelp,ign,akun, produk,nominal,harga);
    }

    static void deleteDataPembeli(){
        showDataPembeli();
        System.out.println("Hapus Nomor Trx = ");
        int id = input.nextInt();
        admin.deletetrx(id);
    }

    static void updateDataPem(int id){
        int pil;
        do {
            System.out.println("pilih data Pembeli yang dirubah\n" +
                    "1. Nama\n" +
                    "2. No Telp\n" +
                    "3. ID Game\n" +
                    "4. Nama Akun\n" +
                    "masukkan pilihan : ");
            pil = input.nextInt();
            switch (pil){
                case 1 -> {
                    System.out.println("Nama : ");
                    String nama = input.next();
                    admin.updatenamaPem(nama,id);
                }
                case 2->{
                    System.out.println("No Telp : ");
                    String notelp = input.next();
                    admin.updatenoPem(notelp,id);
                }
                case 3->{
                    System.out.println("ID Game : ");
                    String Ign = input.next();
                    admin.updateidGame(Ign,id);
                }
                case 4->{
                    System.out.println("Nama Akun : ");
                    String akun = input.next();
                    admin.updatenamaAkun(akun,id);
                }
                case 5->{
                    System.out.println("keluar");
                }
                default -> {
                    System.out.println("Inputan Salah");
                }
            }
        }while (pil<= 5);
    }

    public static void prosesPembelian(){
        showDataPembeli();
        System.out.print("Status id-");
        int id = input.nextInt();
        admin.ubahStatus(id);
    }

    public static void loginAdmin(){
        System.out.print("ID Admin : ");
        String idAdmin = input.next();
        System.out.print("Password : ");
        String pass = input.next();
        int cek = admin.login(idAdmin,pass);

        if (cek != 0){
            System.out.println("Berhasil Login");

            int pil;
            do {
                showDataPembeli();
                System.out.println("1. Hapus\n" +
                        "2. proses\n" +
                        "3. Registrasi Admin\n" +
                        "4. Ubah Password Admin\n" +
                        "5. Tambah Produk\n" +
                        "6. update Data Pembeli\n" +
                        "6. Keluar\n" +
                        "Masukkan Pilihan : ");
                pil = input.nextInt();

                switch (pil){
                    case 1-> deleteDataPembeli();
                    case 2-> prosesPembelian();
                    case 3-> insertAdmin();
                    case 4-> updatepassAdmin(cek);
                    case 5-> tambahproduk();
                    case 6-> updateDataPem(cek);
                    case 7-> System.out.println("Keluar");
                    default -> System.out.println("Inputan Salah");

                }
            }while (pil <= 6);
        }else {
            System.out.println("GAGAL LOGIN");
        }

    }

    private static void tambahproduk(){
        System.out.println("Nama Produk : ");
        String namaPro = input.next();
        System.out.println("Nominal Produk : ");
        int nom = input.nextInt();
        System.out.print("Harga Produk : ");
        int harga = input.nextInt();
        transaksi.insertProduk(namaPro,nom,harga);
    }

    private static void insertAdmin(){
        System.out.println("Nama = ");
        String nama = input.next();
        System.out.println("No Telp = ");
        String notelp = input.next();
        System.out.println("ID Admin = ");
        String idAdmin = input.next();
        System.out.println("Password = ");
        String pass = input.next();
        admin.insertdata(nama,notelp,idAdmin,pass);
    }

    private static void updatepassAdmin(int id){
        System.out.println("Password Baru : ");
        String pass = input.next();
        admin.updatePass(pass,id);
    }
}
