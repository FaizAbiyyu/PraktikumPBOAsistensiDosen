package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminGUI_07293 extends ComponenGUI_07293 {
    JTable tabeltransaksi = new JTable();
    JScrollPane sptransaksi = new JScrollPane(tabeltransaksi);
    JTextField textpilih = new JTextField();
    int kode;

    public AdminGUI_07293(int cek){
        initComponent(cek);
    }

    void initComponent(final int cek){
        setTitle("PROGRAM SHOP ABAL ABAL");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        sptransaksi.setBounds(20, 50, 500, 350);
        tabeltransaksi.setModel(ObjectControllerGUI_07293.transaksiCon.daftartransaksi());
        add(sptransaksi);

        btnverif.setBounds(540, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);

        btndelet.setBounds(540, 95, 110, 25);
        btndelet.setFocusPainted(false);
        btndelet.setBorder(null);
        btndelet.setBackground(Color.black);
        btndelet.setForeground(Color.white);
        add(btndelet);

        btnubahpass.setText("UBAH PASSWORD");
        btnubahpass.setBounds(540, 140, 110, 25);
        btnubahpass.setFocusPainted(false);
        btnubahpass.setBorder(null);
        btnubahpass.setBackground(Color.black);
        btnubahpass.setForeground(Color.white);
        add(btnubahpass);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnregist.setText("REGIST ADMIN");
        btnregist.setBounds(540, 185, 110, 25);
        btnregist.setFocusPainted(false);
        btnregist.setBorder(null);
        btnregist.setBackground(Color.black);
        btnregist.setForeground(Color.white);
        add(btnregist);

        btnProduk.setText("Show Produk");
        btnProduk.setBounds(540,275,110,25);
        btnProduk.setFocusPainted(false);
        btnProduk.setBackground(Color.black);
        btnProduk.setForeground(Color.white);
        add(btnProduk);

        tabeltransaksi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabeltransaksi.getSelectedRow();
                textpilih.setText(ObjectControllerGUI_07293.transaksiCon.daftartransaksi().getValueAt(i, 0).toString());
            }
        });

        btndelet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                ObjectControllerGUI_07293.adminCon.deletetrx(kode);
                tabeltransaksi.setModel(ObjectControllerGUI_07293.transaksiCon.daftartransaksi());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });

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
                LoginAdmin_07293 loginAdmin07293Gui = new LoginAdmin_07293();
                loginAdmin07293Gui.setVisible(true);
                dispose();
            }
        });

        btnProduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Produk_07293 p = new Produk_07293();
            }
        });

        btnubahpass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updatePass(inputpass, cek);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnregist.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RegistAdmin_07293 registerAdminGui = new RegistAdmin_07293();
                registerAdminGui.setVisible(true);
                dispose();
            }
        });

        btnverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                ObjectControllerGUI_07293.adminCon.ubahStatus(kode);
                ObjectControllerGUI_07293.adminCon.deletetrx(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabeltransaksi.setModel(ObjectControllerGUI_07293.transaksiCon.daftartransaksi());

            }
        });
    }
}
