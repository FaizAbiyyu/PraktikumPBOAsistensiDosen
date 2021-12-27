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

public class LoginAdmin_07293 extends ComponenGUI_07293 {

    JButton Kembali = new JButton("KEMBALI KE MENU AWAL");
    String pathicon;

    public LoginAdmin_07293(){
        initComponent();
    }

    void initComponent(){
        setTitle("Login Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelidAdmin.setBounds(35, 250, 80, 25);
        add(labelidAdmin);
        fieldidAdmin.setBounds(130, 250, 130, 25);
        add(fieldidAdmin);

        labelpass.setBounds(35, 290, 80, 25);
        add(labelpass);
        fieldpass.setBounds(130, 290, 130, 25);
        add(fieldpass);

        btnLogin.setBounds(110, 350, 100, 25);
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);
        btnLogin.setBorder(null);
        add(btnLogin);

        Kembali.setBounds(70, 400, 180, 25);
        Kembali.setBorder(null);
        Kembali.setBackground(Color.white);
        add(Kembali);

        bingkaigambar.setBounds(80, 70, 150, 150);
        add(bingkaigambar);

        pathicon = "./src/Images/tokopedia.png";

        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginAdmin_07293.class.getName()).log(Level.SEVERE, null,ex);
        }

        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));

        Kembali.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                Kembali.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e){
                Kembali.setForeground(Color.black);
            }
        });

        Kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new Home_07293().setVisible(true);
            }
        });

        btnLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnLogin.setForeground(Color.black);
                btnLogin.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e){
                btnLogin.setForeground(Color.white);
                btnLogin.setBackground(Color.black);
            }
        });

        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String idAdmin = fieldidAdmin.getText();
                String password = fieldpass.getText();
                int cek = ObjectControllerGUI_07293.adminCon.login(idAdmin, password);
                if(cek > 0){
                    dispose();
                    AdminGUI_07293 adminGui07293 = new AdminGUI_07293(cek);
                    adminGui07293.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }

}
