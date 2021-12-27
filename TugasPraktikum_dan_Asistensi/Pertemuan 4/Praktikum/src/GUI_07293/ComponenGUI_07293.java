package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponenGUI_07293 extends JFrame{
    protected JButton btnregister = new JButton("Registrasi Pendaftaran");
    protected JButton btnCekdata = new JButton("Cek Data");
    protected JButton btnnoreg = new JButton("Belum Registrasi Silahkan Registrasi");
    protected JButton btnlogin = new JButton("LOGIN");
    protected JButton btnbck = new JButton("Kembali");
    protected JButton btndelet = new JButton("Hapus");
    protected JButton pilih = new JButton("pilih");

    protected JLabel labelregistrasi = new JLabel("REGISTRASI SEKARANG");
    protected JLabel labellgn = new JLabel("Login");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labeltlp = new JLabel("NO TELP");
    protected JLabel labelalamat = new JLabel("ALAMAT");
    protected JLabel labelkelas = new JLabel("kelas");
    protected JLabel labelmasuk = new JLabel("MASUK");

    protected JTextField fieldnama = new JTextField("");
    protected JTextField fieldtlp = new JTextField("");
    protected JTextField fieldalamat = new JTextField("");
    protected JTextField fieldKelas = new JTextField("");
    protected JTextField fieldmasuk = new JTextField("");

    protected JButton btnUbahnama = new JButton("Ubah Nama");
    protected JButton btnUbahtlp = new JButton("Ubah No Telp");
    protected JButton btnUbahalamat = new JButton("Ubah Alamat");
    protected JButton btnUbakelas = new JButton("Ubah Kelas");
    protected JButton btnUbah = new JButton("UBAH");

    BufferedImage bufferedImage = null;
    Image gambarrsize;

    protected void kosong(){
        fieldnama.setText(null);
        fieldtlp.setText(null);
        fieldalamat.setText(null);
        fieldKelas.setText(null);
    }


}
