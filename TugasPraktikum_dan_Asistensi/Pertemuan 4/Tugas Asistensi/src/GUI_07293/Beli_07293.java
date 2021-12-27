package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Beli_07293 extends ComponenGUI_07293 {

    JTable tabelproduk = new JTable();
    JScrollPane spprodul = new JScrollPane(tabelproduk);
    JTextField textpilih = new JTextField();
    int kode;

    public Beli_07293(){
        initComponenGUI();
    }

    void initComponenGUI(){
        setTitle("BELI VOUCHER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        labelawal.setBounds(120,30,70,25);
        add(labelawal);

        spprodul.setBounds(20, 50, 500, 350);
        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
        add(spprodul);

        labelnama.setBounds(535,50,40,25);
        add(labelnama);
        fieldnama.setBounds(630,50,130,25);
        add(fieldnama);

        labelnotlp.setBounds(535,95,80,25);
        add(labelnotlp);
        fieldnotelp.setBounds(630,95,130,25);
        add(fieldnotelp);

        labelign.setBounds(535,140,80,25);
        add(labelign);
        fieldign.setBounds(630,140, 130, 25);
        add(fieldign);

        labelakun.setBounds(535,185,80,25);
        add(labelakun);
        fieldakun.setBounds(630,185,130,25);
        add(fieldakun);

        labelproduk.setBounds(535,230,80,25);
        add(labelproduk);
        fieldproduk.setBounds(630,230,80,25);
        add(fieldproduk);

        labelnominal.setBounds(535,275,80,25);
        add(labelnominal);
        fieldnominal.setBounds(630,275,80,25);
        add(fieldnominal);

        labelharga.setBounds(535,315,80,25);
        add(labelharga);
        fieldharga.setBounds(630,315,80,25);
        add(fieldharga);

        btnBeli.setBounds(580, 350, 140, 25);
        btnBeli.setBorder(null);
        btnBeli.setBackground(Color.black);
        btnBeli.setForeground(Color.white);
        btnBeli.setFocusPainted(false);
        add(btnBeli);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });

        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        btnBeli.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBeli.setForeground(Color.black);
                btnBeli.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnBeli.setForeground(Color.white);
                btnBeli.setBackground(Color.black);
            }
        });

        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldnama.getText();
                String notelp = fieldnotelp.getText();
                String ign = fieldign.getText();
                String akun = fieldakun.getText();
                String produk = fieldproduk.getText();
                String nominalstr = fieldnominal.getText();
                String hargastr = fieldharga.getText();

                if(nama.length() != 0 && notelp.length() !=0 && ign.length() != 0 && akun.length()!= 0 && produk.length()!=0 && nominalstr.length()!=0 && hargastr.length()!=0){
                    int nominal = Integer.parseInt(nominalstr);
                    int harga = Integer.parseInt(hargastr);
                    ObjectControllerGUI_07293.transaksiCon.insertDataPembeli(nama,notelp,ign,akun,produk,nominal,harga);
                    JOptionPane.showMessageDialog(null,"data Telah ditambahkan");
                    dispose();
                    new Home_07293().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Data tidak boleh Kosong");
                    kosong();
                }
            }
        });
    }

}
