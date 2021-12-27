package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Produk_07293 extends ComponenGUI_07293 {
    JTable tabelproduk = new JTable();
    JScrollPane spprodul = new JScrollPane(tabelproduk);
    JTextField textpilih = new JTextField();
    int kode;

    public Produk_07293(){
        initcomponen();
    }

    void initcomponen(){
        setTitle("PROGRAM SHOP KW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        spprodul.setBounds(20, 50, 500, 350);
        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
        add(spprodul);

        btndelet.setBounds(540, 95, 110, 25);
        btndelet.setFocusPainted(false);
        btndelet.setBorder(null);
        btndelet.setBackground(Color.black);
        btndelet.setForeground(Color.white);
        add(btndelet);

        btnchangepro.setBounds(540,140,110,25);
        btnchangepro.setFocusPainted(false);
        btnchangepro.setBorder(null);
        btnchangepro.setBackground(Color.black);
        btnchangepro.setForeground(Color.white);
        add(btnchangepro);

        btnchangenom.setBounds(540,185,110,25);
        btnchangenom.setFocusPainted(false);
        btnchangenom.setBorder(null);
        btnchangenom.setBackground(Color.black);
        btnchangenom.setForeground(Color.white);
        add(btnchangenom);

        btnchangehar.setBounds(540,230,110,25);
        btnchangehar.setFocusPainted(false);
        btnchangehar.setBorder(null);
        btnchangehar.setBackground(Color.black);
        btnchangehar.setForeground(Color.white);
        add(btnchangehar);

        btntbhproduk.setText("Add Produk");
        btntbhproduk.setBounds(540,275,110,25);
        btntbhproduk.setFocusPainted(false);
        btntbhproduk.setBackground(Color.black);
        btntbhproduk.setForeground(Color.white);
        add(btntbhproduk);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        tabelproduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelproduk.getSelectedRow();
                textpilih.setText(ObjectControllerGUI_07293.transaksiCon.daftarproduk().getValueAt(i,0).toString());
            }
        });

        btndelet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                ObjectControllerGUI_07293.adminCon.deletetrx(kode);
                tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
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
                dispose();
            }
        });

        btnchangepro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String  id = JOptionPane.showInputDialog("Masukkan ID ");
                    String inputpro = JOptionPane.showInputDialog("Masukan nama Produk Baru");
                    if(id.length()> 0 && inputpro.length() > 0){
                        int ids = Integer.parseInt(id);
                        ObjectControllerGUI_07293.adminCon.updatepro( inputpro, ids);
                        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnchangenom.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String  id = JOptionPane.showInputDialog("Masukkan ID ");
                    String inputpro = JOptionPane.showInputDialog("Masukan Nominal Produk Baru");
                    if(id.length()> 0 && inputpro.length() > 0){
                        int ids = Integer.parseInt(id);
                        int inputpors = Integer.parseInt(inputpro);
                        ObjectControllerGUI_07293.adminCon.updatenom( inputpors, ids);
                        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnchangehar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String  id = JOptionPane.showInputDialog("Masukkan ID ");
                    String inputpro = JOptionPane.showInputDialog("Masukan nama Produk Baru");
                    if(id.length()> 0 && inputpro.length() > 0){
                        int ids = Integer.parseInt(id);
                        int inputpros = Integer.parseInt(inputpro);
                        ObjectControllerGUI_07293.adminCon.updatehar( inputpros, ids);
                        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });


        btntbhproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String produk = JOptionPane.showInputDialog("Masukkan Produk");
                    String nominalstr = JOptionPane.showInputDialog("Masukkan nominal");
                    String hargastr = JOptionPane.showInputDialog("Masukkan Harga");
                    if(produk.length() > 0 && nominalstr.length() > 0 && hargastr.length() > 0){
                        int nominal = Integer.parseInt(nominalstr);
                        int harga = Integer.parseInt(hargastr);
                        ObjectControllerGUI_07293.transaksiCon.insertProduk(produk,nominal,harga);
                        JOptionPane.showMessageDialog(null, "Berhasil Tambah Produk");
                        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
}
