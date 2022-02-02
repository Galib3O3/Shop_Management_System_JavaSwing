import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class Register extends JFrame implements ActionListener {

    JTextField tt,tt1,tt4,tt5,tt6;
    JPasswordField tt2,tt3;
    JButton  login , register;
    JLabel image,img;
    Font FF = new Font("Arial",Font.BOLD,18);
    Font ff = new Font("Georgia",Font.BOLD,15);
    Font TT = new Font("Times New Roman",Font.BOLD,30);
    Font TT1 = new Font("Times New Roman",Font.BOLD,15);

    Font f = new Font("Georgia",Font.BOLD,12);
    Font f1 = new Font("Georgia",Font.BOLD,15);




    Register()
    {
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
//        getContentPane().setBackground(Color.gray);
        setTitle("Register");

        ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\download.jpg").getImage().getScaledInstance(10000,10000, Image.SCALE_SMOOTH));
        this.setIconImage(icon1.getImage());

        JLabel jj1 = new JLabel("Name");
        jj1.setBounds(600, 50, 80,40);
        jj1.setForeground(new Color(0x4C4C8C));
        add(jj1);
        jj1.setFont(TT1);

        JLabel jj2 = new JLabel("UserName");
        jj2.setBounds(600, 115, 80,40);
        jj2.setForeground(new Color(0x4C4C8C));
        add(jj2);
        jj2.setFont(TT1);

        JLabel jj3 = new JLabel("Password:");
        jj3.setBounds(600, 180, 100,40);
        jj3.setForeground(new Color(0x4C4C8C));
        add(jj3);
        jj3.setFont(TT1);

        JLabel jj4 = new JLabel("C.Password:");
        jj4.setBounds(600, 245, 120,40);
        jj4.setForeground(new Color(0x4C4C8C));
        add(jj4);
        jj4.setFont(TT1);

        JLabel jj5 = new JLabel("Email:");
        jj5.setBounds(600, 310, 80,40);
        jj5.setForeground(new Color(0x4C4C8C));
        add(jj5);
        jj5.setFont(TT1);

        JLabel jj6 = new JLabel("phone:");
        jj6.setBounds(600, 370, 80,40);
        jj6.setForeground(new Color(0x4C4C8C));
        add(jj6);
        jj6.setFont(TT1);


        login = new JButton("Login");
        login.setBounds(650,450,100,30);
        login.setBackground(new Color(0x279B97));
        login.addActionListener(this);
        login.setForeground(new Color(0xFADDDD));
        add(login);
        login.setFont(f1);

        register = new JButton("Have an account");
        register.setBounds(600,490,230,30);
        register.setBackground(new Color(0x279B97));
        register.setForeground(new Color(0xFADDDD));
        register.addActionListener(this);
        add(register);
        register.setFont(f1);




        ImageIcon iconn = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\W.jpg").getImage().getScaledInstance(900,600, Image.SCALE_DEFAULT));
        image = new JLabel(iconn);
        image.setBackground(new Color(0xFFFFFF));
        image.setBounds(500,0,900,600);
        add(image);

        //for name
        tt = new JTextField();
        tt.setBounds(600,80,200,30);
        tt.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt.setFont(ff);
        add(tt);
        //for username
        tt1 = new JTextField();
        tt1.setBounds(600,145,200,30);
        tt1.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt1.setFont(ff);
        add(tt1);

        //for password
        tt2 = new JPasswordField();
        tt2.setBounds(600,210,200,30);
        tt2.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt2.setFont(ff);
        add(tt2);

        //for c.pass
        tt3 = new JPasswordField();
        tt3.setBounds(600,275,200,30);
        tt3.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt3.setFont(ff);
        add(tt3);



        // for Email
        tt4 = new JTextField();
        tt4.setBounds(600,340,200,30);
        tt4.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt4.setFont(ff);
        add(tt4);

        //for phone
        tt5 = new JTextField();
        tt5.setBounds(600,400,200,30);
        tt5.setBorder(new MatteBorder(0,0,2,0,new Color(0x4C4C8C) ));
        tt5.setFont(ff);
        add(tt5);


        ImageIcon iconPng = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\ff.png").getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT));
        img=new JLabel(iconPng);
        img.setBounds(70,80,400,400);
        add(img);
        ImageIcon iconn1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\G.jpg").getImage().getScaledInstance(500,600, Image.SCALE_DEFAULT));
        JLabel i = new JLabel(iconn1);
        i.setBounds(0,0,500,600);
        add(i);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String Name = tt.getText();
            String UserName = tt1.getText();
            String Password = tt2.getText();
            String ConfirmPass = tt3.getText();
            String Email = tt4.getText();
            String Phone = tt5.getText();


            String NameRegex = "^[a-zA-Z ]+$";
            String UserNameRegex= "^[a-z0-9]+$";
            String passRegex = "(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%*()]).{6,25}";
            String EmailRegex="^[a-z0-9]+@(gmail|yahoo|outlook).[a-z]{2,3}$";
            String mobileRegex ="(\\+88)?-?01[3-9]\\d{8}";

            if (!Pattern.matches(NameRegex,Name)){
                JOptionPane.showMessageDialog(null,"Sorry use character like(a-zA-Z)");

            }
            else if (!Pattern.matches(UserNameRegex,UserName)){
                JOptionPane.showMessageDialog(null,"Use lower case & Digit(a-z0-9)");
            }
            else if (!Pattern.matches(passRegex,Password)){
                JOptionPane.showMessageDialog(null,"Your Password Contains 1 uppercase,1 lower case,1 special Symbol,range(6-25)");
            }
            else if (!ConfirmPass.equals(Password)){
                JOptionPane.showMessageDialog(null,"Woops password don't match");
            }
            else if (!Pattern.matches(EmailRegex,Email)){
                JOptionPane.showMessageDialog(null,"In-valid Email!!, use a valid Email");
            }
            else if (!Pattern.matches(mobileRegex,Phone)){
                JOptionPane.showMessageDialog(null,"Use a Valid Mobile number");
            }
            else {

                String insertQuery = "INSERT INTO `register`(`Name`, `UserName`, `Password`, `Phone`, `Email`) VALUES ('" + Name + "','" + UserName + "','" + Password + "','" + Phone + "','" + Email + "')";

                DbConnector db = new DbConnector();
                db.InsertRegister(insertQuery);
                if (e.getSource() == login) {
                    new login();
                    dispose();
                }
            }
        }
        if(e.getSource()==register)
        {
            new login();
            dispose();
        }
    }

}