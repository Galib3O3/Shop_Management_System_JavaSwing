import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontWallpaper extends JFrame {

    JButton Press;
    JLabel wallpaper;

    Font ff = new Font("Georgia",Font.BOLD,20);

    FrontWallpaper(){
        intComponents();

    }

    public void intComponents() {
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setLayout(null);

        Press =new JButton("Press To Continue");
        Press.setBounds(220,420,300,200);
        Press.setBorderPainted(false);
        Press.setContentAreaFilled(false);
        Press.setFocusPainted(false);
        Press.setOpaque(false);
        Press.setFont(ff);
        Press.setForeground(new Color(0xA52AB7));
        add(Press);


        ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\Wlcm.jpg").getImage().getScaledInstance(800,600, Image.SCALE_SMOOTH));

        wallpaper = new JLabel(icon1);
        wallpaper.setBounds(0,0,800,600);
        add(wallpaper);




        Press.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                dispose();


            }
        });
        setVisible(true);

    }


}
