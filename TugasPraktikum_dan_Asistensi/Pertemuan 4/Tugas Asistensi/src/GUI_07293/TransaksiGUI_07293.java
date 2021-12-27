package GUI_07293;

import Entity_07293.TransaksiEntity07293;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransaksiGUI_07293 extends ComponenGUI_07293 {
    int nomortrx;
    int status;
    int  nominal, harga;
    String nama, ign, produk, notelp, akun;

    public TransaksiGUI_07293(int cek){
        initComponent(cek);
    }

    void initComponent(final int cek){
        for(TransaksiEntity07293 tranEntities : ObjectControllerGUI_07293.transaksiCon.transaksibyidgame(cek)) {
            this.nomortrx = tranEntities.getNomortrx();
            this.status = tranEntities.getStatus();
            this.nama = tranEntities.getNama();
            this.notelp = tranEntities.getNotelp();
            this.ign = tranEntities.getIDGame();
            this.akun = tranEntities.getNamaAkun();
            this.produk = tranEntities.getProduk();
            this.nominal = tranEntities.getNominal();
            this.harga = tranEntities.getHarga();
        }

        setTitle("PROGRAM Ubah Data");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        labelnama.setBounds(25, 50, 40, 25);
        add(labelnama);
        fieldnama.setBounds(120, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelnotlp.setBounds(25, 90, 40, 25);
        add(labelnotlp);
        fieldnotelp.setBounds(120, 90, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);

        labelign.setBounds(25, 135, 40, 25);
        add(labelign);
        fieldign.setBounds(120, 135, 100, 25);
        fieldign.setText(ign);
        fieldign.setEditable(false);
        add(fieldign);

        labelakun.setBounds(25, 180, 80, 25);
        add(labelakun);
        fieldakun.setBounds(120, 180, 100, 25);
        fieldakun.setText(akun);
        fieldakun.setEditable(false);
        add(fieldakun);

        labelproduk.setBounds(25,225,80,25);
        add(labelproduk);
        fieldproduk.setBounds(120,225,100,25);
        fieldproduk.setText(produk);
        fieldproduk.setEditable(false);
        add(fieldproduk);

        labelnominal.setBounds(25,270,80,25);
        add(labelnominal);
        fieldnominal.setBounds(120,270,100,25);
        fieldnominal.setText(String.valueOf(nominal));
        fieldnominal.setEditable(false);
        add(fieldnominal);

        labelharga.setBounds(25,315,80,25);
        add(labelharga);
        fieldharga.setBounds(120,315,100,25);
        fieldharga.setText(String.valueOf(harga));
        fieldharga.setEditable(false);
        add(fieldharga);

        btnubahnama.setBounds(245, 50, 80, 25);
        btnubahnotelp.setBounds(245, 90, 80, 25);
        btnubahign.setBounds(245, 135, 80, 25);
        btnubahakun.setBounds(245, 180, 80, 25);
        btnubahproduk.setBounds(245, 225, 80, 25);
        btnubahnominal.setBounds(245,270,80,25);
        btnubahharga.setBounds(245,315,80,25);

        add(btnubahnama);
        add(btnubahnotelp);
        add(btnubahign);
        add(btnubahakun);
        add(btnubahproduk);
        add(btnubahnominal);
        add(btnubahharga);

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
                Home_07293 Home_07293 = new Home_07293();
                Home_07293.setVisible(true);
                dispose();
            }
        });

        btnubahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Massukkan Nama Baru");
                    if(inputnama.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updatenamaPem( inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahnotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnpm = JOptionPane.showInputDialog("Masukan notelp Baru");
                    if(inputnpm.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updatenoPem( inputnpm, cek);
                        fieldnotelp.setText(inputnpm);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahign.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan ID Ga,e Baru");
                    if(inputpass.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updateidGame( inputpass, cek);
                        fieldign.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahakun.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan namaAkun Baru");
                    if(inputNoTelp.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updatenamaAkun( inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

    }
}
