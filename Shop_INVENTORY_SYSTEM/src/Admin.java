import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin extends JFrame {
    JButton ADD, CROSS, DELETE,Show,Refresh,Back;
    JTable Table2;
    JLabel bg,Admin;
    JTextField OC,PRO,QUAN,PRICE;
    DefaultTableModel table;
    Connection con;
    PreparedStatement st;
    ResultSet resultSet;

    Font F = new Font("Arial Narrow",Font.BOLD,30);



    Admin(){
        InitComponents();
        Connect();
    }

    public void Connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        public void InitComponents(){

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setTitle("Admin");
        setLocationRelativeTo(null);

            ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\adomin.png").getImage().getScaledInstance(10000,10000, Image.SCALE_SMOOTH));
            this.setIconImage(icon1.getImage());

            OC= new JTextField("OrderCode");
            OC.setBounds(320,270,150,30);
            add(OC);
            PRO= new JTextField("Product");
            PRO.setBounds(320,310,150,30);
            add(PRO);
            QUAN= new JTextField("Quantity");
            QUAN.setBounds(320,350,150,30);
            add(QUAN);
            PRICE= new JTextField("Price");
            PRICE.setBounds(320,390,150,30);
            add(PRICE);


        Show=new JButton("Show Items");
        Show.setBounds(323,485,150,30);
        add(Show);

        Refresh = new JButton("Refresh");
        Refresh.setBounds(345,530,100,30);
        add(Refresh);

        ADD=new JButton("Add");
        ADD.setBackground(new Color(0x279B97));
        ADD.setForeground(new Color(0xFADDDD));
        ADD.setBounds(300,430,80,30);
        add(ADD);

        Admin=new JLabel("ADMIN");
        Admin.setBounds(345,20,110,30);
        Admin.setForeground(new Color(0xFDFDFD));
        Admin.setFont(F);
        add(Admin);

        ImageIcon cross = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\cross.png").getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
        CROSS = new JButton(cross);
        CROSS.setBounds(770,0,30,30);
        add(CROSS);

        ImageIcon back = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\back.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
        Back = new JButton(back);
        Back.setBounds(0,0,30,30);
        add(Back);

        DELETE = new JButton("Delete");
        DELETE.setBounds(410,430,80,30);
        DELETE.setBackground(new Color(0xAD1300));
        DELETE.setForeground(new Color(0xE1DFDF));
        add(DELETE);



        Object data[][]= {};
        String columnNames[]= {"Order Code","Product","Quantity","Price"};
        //Creating table model
        table = new DefaultTableModel(data,columnNames);
        //Adding
        Table2 = new JTable(table);
        JScrollPane sp = new JScrollPane(Table2);
        sp.setBounds(50,60,700,200);
        add(sp);




        ImageIcon iconn1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\G.jpg").getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT));
        bg = new JLabel(iconn1);
        bg.setBounds(0,0,800,600);
        add(bg);

        setVisible(true);

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String InsetrData= "SELECT * FROM `product`";
                try {
                    st=con.prepareStatement(InsetrData);
                    resultSet = st.executeQuery();
                    while (resultSet.next())
                    {
                        String Order_Code=resultSet.getString("OrderCode");
                        String Product=resultSet.getString("Product");
                        String Quntity=resultSet.getString("qntity");
                        String Price=resultSet.getString("Price");

                        String data[]={Order_Code,Product,Quntity,Price};
                        table =(DefaultTableModel)Table2.getModel();
                        table.addRow(data);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
            ADD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{
                        st=con.prepareStatement("INSERT INTO `product`(`OrderCode`, `Product`, `qntity`, `Price`) VALUES (?,?,?,?)");
                        st.setString(1,OC.getText());
                        st.setString(2,PRO.getText());
                        st.setString(3,QUAN.getText());
                        st.setString(4,PRICE.getText());
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Record Added");
                        Connect();
                        con.close();
                    }catch (SQLException E){
                        E.printStackTrace();
                    }
                }
            });

            Refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Admin();
                }
            });

            CROSS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Shop_Inventory_System();
                    dispose();
                }
            });
            DELETE.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row =Table2.getSelectedRow();
                    String val =Table2.getModel().getValueAt(row,0).toString();
                    String Qury =("DELETE FROM `product` WHERE OrderCode= "+val);
                    try{
                        st=con.prepareStatement(Qury);
                        st.execute();

                        int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                        if(a==JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null,"Record deleted Sucessfully");
                        }

                    } catch(SQLException E){
                        E.printStackTrace();
                    }

                }
            });







        }
}
