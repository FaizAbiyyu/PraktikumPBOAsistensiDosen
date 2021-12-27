package GUI;

import Entity_07293.MahasiswaEntity_07293;
import GUI_07293.AllObjectControllerGUI_07293;
import GUI_07293.ComponenGUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MahasiswaGUI extends ComponenGUI_07293 {
    int id;
    String nama, password, notelp, alamat, kelas, path;
    String filemove = "./src/Images/";

    File file;
    public MahasiswaGUI(int cek){
        initComponent(cek);
    }

    void initComponent(final int cek){
        for(MahasiswaEntity_07293 mahasiswaEntities : AllObjectControllerGUI_07293.mahasiswaCG.ambilbyid(cek)) {
            this.id       = mahasiswaEntities.getId();
            this.nama     = mahasiswaEntities.getNama();
            this.notelp   = mahasiswaEntities.getNo_telp();
            this.alamat = mahasiswaEntities.getAlamat();
            this.kelas = mahasiswaEntities.getKelas();
        }

        setTitle("PROGRAM UBAH MAHASISWA");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        btnbck.setBounds(25, 20, 80, 25);
        btnbck.setBackground(Color.white);
        btnbck.setFocusPainted(false);
        btnbck.setBorder(null);
        add(btnbck);

        labelnama.setBounds(35, 50, 80, 25);
        add(labelnama);
        fieldnama.setBounds(130, 50, 80, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);

        labeltlp.setBounds(35,90, 80, 25);
        add(labeltlp);
        fieldtlp.setBounds(130,90, 80, 25);
        fieldtlp.setText(notelp);
        fieldtlp.setEditable(false);
        add(fieldtlp);

        labelalamat.setBounds(35,135, 80, 25);
        add(labelalamat);
        fieldalamat.setBounds(130,135, 80, 25);
        fieldalamat.setText(alamat);
        fieldalamat.setEditable(false);
        add(fieldalamat);

        labelkelas.setBounds(35,180, 80, 25);
        add(labelkelas);
        fieldKelas.setBounds(130,180, 80, 25);
        fieldKelas.setText(kelas);
        fieldKelas.setEditable(false);
        add(fieldKelas);

        btnUbahnama.setBounds(245, 50, 80, 25);
        btnUbahtlp.setBounds(245, 90, 80, 25);
        btnUbahalamat.setBounds(245, 135, 80, 25);
        btnUbakelas.setBounds(245, 180, 80, 25);

        add(btnUbahnama);
        add(btnUbahtlp);
        add(btnUbahalamat);
        add(btnUbakelas);

        btnbck.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnbck.setForeground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e){
                btnbck.setForeground(Color.black);
            }
        });

        btnbck.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        btnUbahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Massukkan Nama Baru");
                    if(inputnama.length() > 0){
                        AllObjectControllerGUI_07293.mahasiswaCG.update(1, inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnUbahtlp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnpm = JOptionPane.showInputDialog("Masukan nomer telp Baru");
                    if(inputnpm.length() > 0){
                        AllObjectControllerGUI_07293.mahasiswaCG.update(2, inputnpm, cek);
                        fieldtlp.setText(inputnpm);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnUbahalamat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan alamat");
                    if(inputpass.length() > 0){
                        AllObjectControllerGUI_07293.mahasiswaCG.update(3, inputpass, cek);
                        fieldtlp.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        btnUbakelas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan kelas Baru");
                    if(inputNoTelp.length() > 0){
                        AllObjectControllerGUI_07293.mahasiswaCG.update(5, inputNoTelp, cek);
                        fieldKelas.setText(inputNoTelp);
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
