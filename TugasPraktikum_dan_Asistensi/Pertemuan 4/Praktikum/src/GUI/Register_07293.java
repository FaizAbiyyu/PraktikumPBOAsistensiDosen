package GUI;

import GUI_07293.AllObjectControllerGUI_07293;
import GUI_07293.ComponenGUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register_07293 extends ComponenGUI_07293 {

    public Register_07293(){
        initComponen();
    }

    void initComponen(){
        setTitle("Daftar Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelregistrasi.setBounds(120,50,200,25);
        add(labelregistrasi);

        labelnama.setBounds(35,95,40,25);
        add(labelnama);
        fieldnama.setBounds(130,95,130,25);
        add(fieldnama);

        labeltlp.setBounds(35,140,80,25);
        add(labeltlp);
        fieldtlp.setBounds(130,140,130,25);
        add(fieldtlp);

        labelalamat.setBounds(35,185,80,25);
        add(labelalamat);
        fieldalamat.setBounds(130,185, 130, 25);
        add(fieldalamat);

        labelkelas.setBounds(35,230,80,25);
        add(labelkelas);
        fieldKelas.setBounds(130,230,130,25);
        add(fieldKelas);

        btnCekdata.setBounds(80,300,140,25);
        btnCekdata.setBorder(null);
        btnCekdata.setBackground(Color.black);
        btnCekdata.setForeground(Color.white);
        btnCekdata.setFocusPainted(false);
        add(btnCekdata);

        btnregister.setBounds(80,350,140,25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);

        btnCekdata.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCekdata.setForeground(Color.black);
                btnCekdata.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCekdata.setForeground(Color.white);
                btnCekdata.setBackground(Color.black);
            }
        });

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldnama.getText();
                String notelp = fieldtlp.getText();
                String alamat = fieldalamat.getText();
                String kelas = fieldKelas.getText();

                if(nama.length() != 0 && notelp.length() !=0 && alamat.length() != 0 && kelas.length()!= 0){
                    AllObjectControllerGUI_07293.mahasiswaCG.insertmahasiswa(nama,notelp,alamat,kelas);
                    JOptionPane.showMessageDialog(null,"data Telah ditambahkan");
                    dispose();
                    new Register_07293().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Data tidak boleh Kosong");
                    kosong();
                }
            }
        });

        btnCekdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home().setVisible(true);
            }
        });
    }

}
