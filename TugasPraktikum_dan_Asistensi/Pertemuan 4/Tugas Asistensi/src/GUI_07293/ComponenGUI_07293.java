package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponenGUI_07293 extends JFrame{
    protected JButton btnBeli = new JButton("BELI");
    protected JButton btnback = new JButton("<< keluar");
    protected JButton btnLogin = new JButton("Login");
    protected JButton btnProduk = new JButton("Show Produk");
    protected JButton btndelet = new JButton("DELETE");
    protected JButton btnverif = new JButton("Selesai");
    protected JButton btntbhproduk = new JButton("Tambah Produk");

    protected JLabel labelawal = new JLabel("Mini Shoop");
    protected JLabel labellogin = new JLabel("Login");
    protected JLabel labelnomortrx = new JLabel("Nomor trx");
    protected JLabel labelnama = new JLabel("Nama");
    protected JLabel labelnotlp = new JLabel("NoTelp");
    protected JLabel labelign = new JLabel("ID Game");
    protected JLabel labelakun = new JLabel("Nama Akun");
    protected JLabel labelproduk = new JLabel("Produk");
    protected JLabel labelharga = new JLabel("Harga");
    protected JLabel labelnominal = new JLabel("Nominal");
    protected JLabel labelidAdmin = new JLabel("ID Admin");
    protected JLabel labelpass = new JLabel("Password");
    protected JLabel labelregist = new JLabel("Registeasi");
    protected JLabel bingkaigambar = new JLabel();
    protected JLabel labelpilih = new JLabel("Piliha");
    protected JLabel labelmasuk = new JLabel("Ubah data");

    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnotelp = new JTextField();
    protected JTextField fieldign = new JTextField();
    protected JTextField fieldakun = new JTextField();
    protected JTextField fieldproduk = new JTextField();
    protected JTextField fieldnominal = new JTextField();
    protected JTextField fieldharga = new JTextField();
    protected JTextField fieldidAdmin = new JTextField();
    protected JPasswordField fieldpass = new JPasswordField();
    protected JTextField fieldpilih = new JTextField();
    protected JTextField fieldmasuk = new JTextField();

    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
    protected JButton btnubahign = new JButton("Ubah");
    protected JButton btnubahakun = new JButton("Ubah");
    protected JButton btnubahproduk = new JButton("ubah");
    protected JButton btnubahnominal = new JButton("Ubah");
    protected JButton btnubahharga = new JButton("ubah");
    protected JButton btnubahpass = new JButton("Ubah");
    protected JButton btnregist = new JButton("Registrasi");
    protected JButton btnmasuk = new JButton("Masuk");
    protected JButton btnchangepro = new JButton("Ubah Produk");
    protected JButton btnchangenom = new JButton("Ubah Produk");
    protected JButton btnchangehar = new JButton("Ubah Produk");


    BufferedImage bufferedImage = null;
    Image gambarresize;

    void kosong(){
        fieldnama.setText(null);
        fieldnotelp.setText(null);
        fieldign.setText(null);
        fieldakun.setText(null);
        fieldproduk.setText(null);
        fieldnominal.setText(null);
        fieldharga.setText(null);
    }

}
