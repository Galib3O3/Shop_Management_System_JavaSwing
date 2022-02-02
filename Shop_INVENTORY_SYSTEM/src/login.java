import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class login extends JFrame  {
    JButton jb, jb1,jb2,ab,cont;
    JTextField t;
    JLabel image,im,ii,lgin;
    JPasswordField t1;
    Font F = new Font("Arial",Font.BOLD,18);
    Font f = new Font("Georgia",Font.BOLD,12);
    Font f1 = new Font("Georgia",Font.BOLD,15);
    Font T = new Font("Times New Roman",Font.BOLD,30);

    login()
    {

        setSize(700,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");



        ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\lg.png").getImage().getScaledInstance(10000,10000, Image.SCALE_SMOOTH));
        this.setIconImage(icon1.getImage());





//        JLabel jlb = new JLabel("Login");
//        jlb.setForeground(Color.WHITE);
//        jlb.setBounds(150,20,100,40);
//        add(jlb);
//        jlb.setFont(T);
//



        JLabel jl = new JLabel("Username");
        jl.setForeground(new Color(0x06394D));
        jl.setBounds(405,150,100,40);
        add(jl);


        JLabel jl2 = new JLabel("password");
        jl.setForeground(new Color(0x06394D));
        jl2.setBounds(405,220,100,40);
        add(jl2);

        ab= new JButton("About us");
        ab.setBounds(450,460,70,30);
        ab.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        ab.setForeground(new Color(0x4C4C));
        ab.setContentAreaFilled(false);
        ab.setFocusPainted(false);
        ab.setOpaque(false);
        add(ab);



        cont= new JButton("Contact us");
        cont.setBounds(570,460,70,30);
        cont.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        cont.setForeground(new Color(0x4C4C));
        cont.setContentAreaFilled(false);
        cont.setFocusPainted(false);
        cont.setOpaque(false);
        add(cont);


        t = new JTextField();
        t.setBounds(405,175,200,30);
        t.setForeground(new Color(0x181818));
        t.setFont(f);
        t.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        add(t);

        t1 = new JPasswordField();
        t1.setEchoChar('*');
        t1.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        t1.setBounds(405,250,200,30);
        add(t1);



        jb = new JButton("Login");
        jb.setBounds(390,330,90,40);
        jb.setBackground(new Color(0x279B97));
        jb.setForeground(new Color(0xFADDDD));
        add(jb);
        jb.setFont(f1);

        jb1 = new JButton("Register");
        jb1.setBounds(490,330,150,40);
        jb1.setBackground(new Color(0x279B97));
        jb1.setForeground(new Color(0xFADDDD));
        add(jb1);
        jb1.setFont(f1);



        ImageIcon iconn2 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\lg1.png").getImage().getScaledInstance(158,158, Image.SCALE_DEFAULT));
        ii = new JLabel(iconn2);
        ii.setBounds(440,0,158,158);
        add(ii);


        ImageIcon iconn = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\W.jpg").getImage().getScaledInstance(700,500, Image.SCALE_DEFAULT));
        image = new JLabel(iconn);
        image.setBackground(new Color(0xFFFFFF));
        image.setBounds(300,0,700,500);
        add(image);

//        ImageIcon iconn3 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\gg.png").getImage().getScaledInstance(158,158, Image.SCALE_DEFAULT));
//        iii = new JLabel(iconn3);
//        iii.setBounds(50,100,158,158);
//        add(iii);

        ImageIcon lgin1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\lgin.png").getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT));
        lgin=new JLabel(lgin1);
        lgin.setBounds(40,150,250,250);
        add(lgin);

        ImageIcon iconn1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\G.jpg").getImage().getScaledInstance(700,500, Image.SCALE_DEFAULT));
        im = new JLabel(iconn1);
        im.setBackground(new Color(0xFFFFFF));
        im.setBounds(0,0,300,500);
        add(im);
        setVisible(true);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserName = t.getText();
                String Password = t1.getText();

                DbConnector db = new DbConnector();
                String queryLogin = "SELECT * FROM `register` ";
                db.Login(queryLogin,UserName,Password);
                dispose();

            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
                dispose();

            }
        });
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URL("https://github.com/Galib3O3").toURI());

                }
                catch(IOException | URISyntaxException E)
                {}
            }
        });
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/GalluXman303/").toURI());

                }
                catch(IOException | URISyntaxException E)
                {}

            }
        });

    }

    }



