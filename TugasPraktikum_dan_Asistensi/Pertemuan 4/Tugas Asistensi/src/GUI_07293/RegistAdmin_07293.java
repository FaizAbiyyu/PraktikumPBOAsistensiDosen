package GUI_07293;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistAdmin_07293 extends ComponenGUI_07293 {
    public RegistAdmin_07293(){
        initComponent();
    }

    void initComponent(){
        setTitle("Register Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelregist.setText("REGISTER ADMIN");
        labelregist.setBounds(100, 50, 110, 25);
        add(labelregist);
        labelnama.setBounds(35, 95, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 95, 130, 25);
        add(fieldnama);

        labelnotlp.setBounds(35, 140, 80, 25);
        add(labelnotlp);
        fieldnotelp.setBounds(130, 140, 130, 25);
        add(fieldnotelp);

        labelidAdmin.setBounds(35, 185, 80, 25);
        add(labelidAdmin);
        fieldidAdmin.setBounds(130, 185, 130, 25);
        add(fieldidAdmin);

        labelpass.setBounds(35, 230, 80, 25);
        add(labelpass);
        fieldpass.setBounds(130, 230, 130, 25);
        add(fieldpass);

        btnregist.setBounds(80, 350, 140, 25);
        btnregist.setBorder(null);
        btnregist.setBackground(Color.black);
        btnregist.setForeground(Color.white);
        btnregist.setFocusPainted(false);
        add(btnregist);

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
                LoginAdmin_07293 adminGUI = new LoginAdmin_07293();
                dispose();
            }
        });

        btnregist.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnregist.setForeground(Color.black);
                btnregist.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e){
                btnregist.setForeground(Color.white);
                btnregist.setBackground(Color.black);
            }
        });

        btnregist.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = fieldnama.getText();
                String notelp = fieldnotelp.getText();
                String idAdmin = fieldidAdmin.getText();
                String password = fieldpass.getText();
                if(nama.length() != 0 && notelp.length() != 0 && idAdmin.length() != 0 && password.length() != 0){
                    ObjectControllerGUI_07293.adminCon.insertdata(nama,notelp,idAdmin,password);
                    JOptionPane.showMessageDialog(null, nama + "Adalah Admin");
                    dispose();
                    new LoginAdmin_07293().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
