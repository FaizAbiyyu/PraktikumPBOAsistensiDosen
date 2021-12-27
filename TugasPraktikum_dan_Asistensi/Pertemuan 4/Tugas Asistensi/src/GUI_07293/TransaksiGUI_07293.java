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
    JTable tabelproduk = new JTable();
    JScrollPane spprodul = new JScrollPane(tabelproduk);

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
        setSize(900,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spprodul.setBounds(20, 50, 500, 350);
        tabelproduk.setModel(ObjectControllerGUI_07293.transaksiCon.daftarproduk());
        add(spprodul);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        labelnama.setBounds(525, 50, 40, 25);
        add(labelnama);
        fieldnama.setBounds(620, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelnotlp.setBounds(525, 90, 40, 25);
        add(labelnotlp);
        fieldnotelp.setBounds(620, 90, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);

        labelign.setBounds(525, 135, 40, 25);
        add(labelign);
        fieldign.setBounds(620, 135, 100, 25);
        fieldign.setText(ign);
        fieldign.setEditable(false);
        add(fieldign);

        labelakun.setBounds(525, 180, 80, 25);
        add(labelakun);
        fieldakun.setBounds(620, 180, 100, 25);
        fieldakun.setText(akun);
        fieldakun.setEditable(false);
        add(fieldakun);

        labelproduk.setBounds(525,225,80,25);
        add(labelproduk);
        fieldproduk.setBounds(620,225,100,25);
        fieldproduk.setText(produk);
        fieldproduk.setEditable(false);
        add(fieldproduk);

        labelnominal.setBounds(525,270,80,25);
        add(labelnominal);
        fieldnominal.setBounds(620,270,100,25);
        fieldnominal.setText(String.valueOf(nominal));
        fieldnominal.setEditable(false);
        add(fieldnominal);

        labelharga.setBounds(525,315,80,25);
        add(labelharga);
        fieldharga.setBounds(620,315,100,25);
        fieldharga.setText(String.valueOf(harga));
        fieldharga.setEditable(false);
        add(fieldharga);

        btnubahnama.setBounds(745, 50, 80, 25);
        btnubahnotelp.setBounds(745, 90, 80, 25);
        btnubahign.setBounds(745, 135, 80, 25);
        btnubahakun.setBounds(745, 180, 80, 25);
        btnubahproduk.setBounds(745, 225, 80, 25);
        btnubahnominal.setBounds(745,270,80,25);
        btnubahharga.setBounds(745,315,80,25);

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
                        fieldakun.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpro = JOptionPane.showInputDialog("Masukan nama Produk Baru");
                    if(inputpro.length() > 0){
                        ObjectControllerGUI_07293.adminCon.updateProduk( inputpro, cek);
                        fieldproduk.setText(inputpro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahnominal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan nominal Produk Baru");
                    if(inputpass.length() > 0){
                        int input = Integer.parseInt(inputpass);
                        ObjectControllerGUI_07293.adminCon.updateNominal( input, cek);
                        fieldnominal.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnubahharga.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan harga Produk Baru");
                    if(inputpass.length() > 0){
                        int input = Integer.parseInt(inputpass);
                        ObjectControllerGUI_07293.adminCon.updateHarga( input, cek);
                        fieldharga.setText(inputpass);
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
