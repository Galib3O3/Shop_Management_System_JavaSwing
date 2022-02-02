import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SaleDetails extends JFrame {

    JTable Table2;
    JButton Details;
    JLabel bg,Sales;
    DefaultTableModel table;
    ///////////////
    Connection con;
    PreparedStatement st;
    ResultSet resultSet;
    ///////////////
    Font F = new Font("Arial Narrow",Font.BOLD,30);


    public void Connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    SaleDetails(){
        InitComponents();
        Connect();
    }

    public void InitComponents() {
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setTitle("Sales Details");
        setLocationRelativeTo(null);

        ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\details.jpg").getImage().getScaledInstance(10000,10000, Image.SCALE_SMOOTH));
        this.setIconImage(icon1.getImage());

        Object data[][]= {};
        String columnNames[]= {"ID","Sub-total","Pay","Return"};
        //Creating table model
        table = new DefaultTableModel(data,columnNames);
        //Adding
        Table2 = new JTable(table);
        JScrollPane sp = new JScrollPane(Table2);
        sp.setBounds(20,60,750,300);
        add(sp);

        Sales=new JLabel("Sales");
        Sales.setBounds(345,20,110,30);
        Sales.setForeground(new Color(0xFDFDFD));
        Sales.setFont(F);
        add(Sales);

        ImageIcon icon = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\d.png").getImage().getScaledInstance(150,50, Image.SCALE_DEFAULT));
        Details=new JButton(icon);
        Details.setBounds(320,380,150,50);
        add(Details);

        ImageIcon iconn1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\G.jpg").getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT));
        bg = new JLabel(iconn1);
        bg.setBounds(0,0,800,500);
        add(bg);
        setVisible(true);


        Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String InsetrData= "SELECT * FROM `sales`";
                try {
                    st=con.prepareStatement(InsetrData);
                    resultSet = st.executeQuery();
                    while (resultSet.next())
                    {
                        String ID=resultSet.getString("ID");
                        String subtotal=resultSet.getString("Subtotal");
                        String pay=resultSet.getString("Pay");
                        String balance=resultSet.getString("balance");

                        String data[]={ID,subtotal,pay,balance};
                        table =(DefaultTableModel)Table2.getModel();
                        table.addRow(data);

                    }
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });


    }
}
