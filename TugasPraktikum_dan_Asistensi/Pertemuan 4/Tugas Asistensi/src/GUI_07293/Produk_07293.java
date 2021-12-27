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
    }
}
