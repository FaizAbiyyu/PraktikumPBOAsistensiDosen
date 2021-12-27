package GUI_07293;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home_07293 extends ComponenGUI_07293 {
    JButton admin = new JButton();
    String pathicon;

    public Home_07293(){
        initComponen();
    }

    void initComponen(){
        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        btnBeli.setBounds(90,250,130,25);
        btnBeli.setBorder(null);
        btnBeli.setBackground(Color.BLACK);
        btnBeli.setForeground(Color.white);
        add(btnBeli);

        labelmasuk.setBounds(35,330,60,25);
        add(labelmasuk);
        fieldmasuk.setBounds(130,330,130,25);
        add(fieldmasuk);

        btnLogin.setBounds(0, 405, 20, 20);
        btnLogin.setBorder(null);
        btnLogin.setBackground(Color.black);
        add(btnLogin);

        btnmasuk.setBounds(90, 375,130,25);
        btnmasuk.setBorder(null);
        btnmasuk.setBackground(Color.black);
        btnmasuk.setForeground(Color.white);
        add(btnmasuk);

        bingkaigambar.setBounds(80,70,150,150);
        add(bingkaigambar);

        pathicon = "./src/images/m3.jpg";

        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(Home_07293.class.getName()).log(Level.SEVERE, null, ex);
        }

        gambarresize = bufferedImage.getScaledInstance(150, 150,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));

        btnBeli.addMouseListener(new MouseAdapter(){
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

        btnmasuk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnmasuk.setForeground(Color.black);
                btnmasuk.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnmasuk.setForeground(Color.white);
                btnmasuk.setBackground(Color.black);
            }
        });

        btnLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setForeground(Color.black);
                btnLogin.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setForeground(Color.white);
                btnLogin.setBackground(Color.black);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginAdmin_07293 loginAdmin07293Gui = new LoginAdmin_07293();
                loginAdmin07293Gui.setVisible(true);
            }
        });

        //kebeli
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Beli_07293().setVisible(true);
            }
        });

        btnProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Produk_07293().setVisible(true);
            }
        });

        //kurang
        btnmasuk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String idGamestr = fieldmasuk.getText();
                if(idGamestr.length() != 0){
                    int id = Integer.parseInt(idGamestr);
                    dispose();
                    ObjectControllerGUI_07293.transaksiCon.transaksibyidgame(id);
                    new TransaksiGUI_07293(id).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });


    }

}
