package GUI;

import GUI_07293.AllObjectControllerGUI_07293;
import GUI_07293.ComponenGUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends ComponenGUI_07293 {
    JTable tabelmahasiswa = new JTable();
    JScrollPane spmahasiswa = new JScrollPane(tabelmahasiswa);
    JTextField textpilih = new JTextField();
    int kode;


    public Home(){
        initComponent();
    }

    void initComponent(){
        setTitle("PROGRAM VERIF MAHASISWA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setVisible(true);

        spmahasiswa.setBounds(20, 50, 500, 350);
        tabelmahasiswa.setModel(AllObjectControllerGUI_07293.mahasiswaCG.daftarMahasiswa());
        add(spmahasiswa);

        btndelet.setBounds(540, 95, 110, 25);
        btndelet.setFocusPainted(false);
        btndelet.setBorder(null);
        btndelet.setBackground(Color.black);
        btndelet.setForeground(Color.white);
        add(btndelet);

        btnbck.setBounds(25, 20, 80, 25);
        btnbck.setBackground(Color.white);
        btnbck.setFocusPainted(false);
        btnbck.setBorder(null);
        add(btnbck);

        labelmasuk.setBounds(540,130,110,25);
        add(labelmasuk);
        fieldmasuk.setBounds(540,175,110,25);
        add(fieldmasuk);

        btnUbah.setBounds(540,220,110,25);
        btnUbah.setBorder(null);
        btnUbah.setBackground(Color.black);
        btnUbah.setForeground(Color.white);
        btnUbah.setFocusPainted(false);
        add(btnUbah);

        tabelmahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelmahasiswa.getSelectedRow();
                textpilih.setText(AllObjectControllerGUI_07293.mahasiswaCG.daftarMahasiswa().getValueAt(i,0).toString());
            }
        });

        btndelet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectControllerGUI_07293.mahasiswaCG.deleteData(kode);
                tabelmahasiswa.setModel(AllObjectControllerGUI_07293.mahasiswaCG.daftarMahasiswa());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });

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


        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String idGamestr = fieldmasuk.getText();
                if(idGamestr.length() != 0){
                    int id = Integer.parseInt(idGamestr);
                    dispose();
                    AllObjectControllerGUI_07293.mahasiswaCG.ambilbyid(id);
                    new MahasiswaGUI(id).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });



}
}
