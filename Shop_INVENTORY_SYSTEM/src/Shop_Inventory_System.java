import com.mysql.cj.exceptions.DeadlockTimeoutRollbackMarker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class Shop_Inventory_System extends JFrame  {

    JPanel UpperPanel, MainPanel,TablePanel;
    JButton Print , add,Reset,delete,Admin,Exit,Details;
    JTextField OrderTxt;
    JTextField NameTxt;
    JTextField PriceTxt;
    JTextField costTxt;
    JTextField PayTxt;
    JTextField ReturnTxt;
    JSpinner  quantity;
    JLabel uppertext, OderCode, ProductName, Price, Quantity, TotalCost, Pay, Return,Picture,Picture2,picture3,text;
    JTable table1;
    DefaultTableModel model;
    Container c;

    int total;

    //database
    public Connection con;
    public PreparedStatement pst;
    public ResultSet resultSet;
    public PreparedStatement pst1 ;



    ////////////////FONT Attributes\\\\\\\\\\\\\\\\\\\\
    Font f1= new Font("Georgia",Font.ITALIC,30);
    Font f2= new Font("Georgia",Font.BOLD,20);
    Font f3 = new Font("Georgia",Font.BOLD,15);
    Font T = new Font("Arial",Font.BOLD,20);


    /////////////////////////////////////////////////////////////
    Shop_Inventory_System(){
        initComponents();
        Connect();

    }
    private void Connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void initComponents(){

        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setUndecorated(true);
        setTitle("Shop Inventory System");
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\rg.png").getImage().getScaledInstance(10000,10000, Image.SCALE_SMOOTH));
        this.setIconImage(icon1.getImage());


        //////UpperPanel & uppertext
        UpperPanel = new JPanel();
        UpperPanel.setBounds(0,0,1000,70);
        UpperPanel.setBackground(new Color(0x31314F));
        UpperPanel.setLayout(null);
        add(UpperPanel);

        uppertext = new JLabel("Shop Management");
        uppertext.setBounds(350,20,400,40);
        uppertext.setForeground(new Color(0x5D5D8F));
        uppertext.setFont(f1);
        UpperPanel.add(uppertext);
        //End


        //  MainPanel & attributes
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(0x3B3B6C));
        MainPanel.setBounds(20,80,960,330);
        add(MainPanel);

        //Table Panel

        TablePanel = new JPanel();
        TablePanel.setLayout(null);
        TablePanel.setBackground(new Color(0x3B3B6C));
        TablePanel.setBounds(20,410,600,240);
        add(TablePanel);

        OderCode = new JLabel("Order Code");
        OderCode.setBounds(70,30,150,40);
        OderCode.setForeground(new Color(181, 234, 245));
        OderCode.setFont(f2);
        MainPanel.add(OderCode);


        ProductName = new JLabel("Product");
        ProductName.setBounds(70,90,150,40);
        ProductName.setForeground(new Color(181, 234, 245));
        ProductName.setFont(f2);
        MainPanel.add(ProductName);

        Price = new JLabel("Price");
        Price.setBounds(70,160,150,40);
        Price.setForeground(new Color(181, 234, 245));
        Price.setFont(f2);
        MainPanel.add(Price);

        Quantity = new JLabel("Quantity");
        Quantity.setBounds(70,230,150,40);
        Quantity.setForeground(new Color(181, 234, 245));
        Quantity.setFont(f2);
        MainPanel.add(Quantity);

        TotalCost = new JLabel("Total Cost");
        TotalCost.setBounds(550,30,150,40);
        TotalCost.setForeground(new Color(181, 234, 245));
        TotalCost.setFont(f2);
        MainPanel.add(TotalCost);

        Pay = new JLabel("Pay");
        Pay.setBounds(550,90,150,40);
        Pay.setForeground(new Color(181, 234, 245));
        Pay.setFont(f2);
        MainPanel.add(Pay);

        Return= new JLabel("Return");
        Return.setBounds(550,160,150,40);
        Return.setForeground(new Color(181, 234, 245));
        Return.setFont(f2);
        MainPanel.add(Return);
        //End


        //ADD TextField
        OrderTxt = new JTextField();
        OrderTxt.setBounds(200,40,150,25);
        OrderTxt.setForeground(new Color(0x011717));
        OrderTxt.setFont(T);
        MainPanel.add(OrderTxt);

        NameTxt = new JTextField();
        NameTxt.setBounds(200,100,150,25);
        NameTxt.setForeground(new Color(0x011717));
        NameTxt.setFont(T);
        MainPanel.add(NameTxt);

        PriceTxt = new JTextField();
        PriceTxt.setBounds(200,160,150,25);
        PriceTxt.setForeground(new Color(0x000000));
        PriceTxt.setFont(T);
        MainPanel.add(PriceTxt);


        costTxt = new JTextField();
        costTxt.setBounds(680,40,150,25);
        costTxt.setForeground(new Color(0x000000));
        costTxt.setFont(T);
        MainPanel.add(costTxt);

        PayTxt = new JTextField();
        PayTxt.setBounds(680,90,150,25);
        PayTxt.setForeground(new Color(0x000000));
        PayTxt.setFont(T);
        MainPanel.add(PayTxt);

        ReturnTxt = new JTextField();
        ReturnTxt.setBounds(680,160,150,25);
        ReturnTxt.setForeground(new Color(0x000000));
        ReturnTxt.setFont(T);
        MainPanel.add(ReturnTxt);


        Print = new JButton("Enter");
        Print.setBounds(690,230,120,30);
        Print.setFont(f2);
        MainPanel.add(Print);



        //End

        //JSpinner
        quantity = new JSpinner();
        quantity.setBounds(200,230,150,25);
        quantity.setForeground(new Color(0x011717));
        quantity.setFont(f2);
        MainPanel.add(quantity);
        //End

        //Add nutton
        add = new JButton("ADD");
        add.setBounds(220,280,100,30);
        MainPanel.add(add);

        //MainPanel Picture Add
        ImageIcon Icon = new ImageIcon(new ImageIcon("F:\\JAVA6th\\login_Register\\src\\images\\G.jpg").getImage().getScaledInstance(960,360,Image.SCALE_SMOOTH));
        Picture = new JLabel(Icon);
        Picture.setBounds(0,0,960,360);
        MainPanel.add(Picture);

        ImageIcon Icon1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\ok.jpg").getImage().getScaledInstance(1000,70,Image.SCALE_SMOOTH));
        Picture2 = new JLabel(Icon1);
        Picture2.setBounds(0,0,1000,70);
        UpperPanel.add(Picture2);
        //End



        //JTablE ADD

        Object data[][]= {};
        String columnNames[]= {"Order Code","Name","Price","Quantity","total"};
        //Creating table model
        model = new DefaultTableModel(data,columnNames);
        //Adding
        table1 = new JTable(model);
        JScrollPane sp = new JScrollPane(table1);
        sp.setBounds(10,10,580,210);
        TablePanel.add(sp);


        Reset = new JButton("new");
        Reset.setBackground(new Color(0x09605C));
        Reset.setForeground(new Color(0xE8E8E8));
        Reset.setBounds(650,500,100,50);
        Reset.setFont(f3);
        add(Reset);

        delete =new JButton("Delete");
        delete.setBackground(new Color(0xE72500));
        delete.setForeground(new Color(0xE1DFDF));
        delete.setFont(f3);
        delete.setBounds(650,570,100,50);
        add(delete);

        Admin=new JButton("Admin");
        Admin.setBackground(new Color(0x279B97));
        Admin.setForeground(new Color(0xFADDDD));
        Admin.setFont(f3);
        Admin.setBounds(650,420,100,50);
        add(Admin);

        ImageIcon iconn1 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\exit.png").getImage().getScaledInstance(150,60, Image.SCALE_DEFAULT));
        Exit = new JButton(iconn1);
        Exit.setBackground(new Color(0x725D5D));
        Exit.setForeground(new Color(0xFADDDD));
        Exit.setFont(f3);
        Exit.setBounds(830,570,150,60);
        add(Exit);

        text=new JLabel("Shop Management System,@Rangnarok..Verison-2021-2022.0.001.0011");
        text.setBounds(610,665,400,20);
        text.setForeground(new Color(0xF5F5F5));
        add(text);

        ImageIcon icon2 = new ImageIcon(new ImageIcon("F:\\JAVA6th\\Shop_INVENTORY_SYSTEM\\src\\Image\\G.jpg").getImage().getScaledInstance(1000,40, Image.SCALE_DEFAULT));
        picture3=new JLabel(icon2);
        picture3.setBounds(0,660,1000,40);
        add(picture3);

        Details=new JButton("Details");
        Details.setBackground(new Color(0xAEDC0C));
        Details.setForeground(new Color(0x2F2020));
        Details.setBounds(850,420,100,50);
        add(Details);



        setVisible(true);

        OrderTxt.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){

                    String OrderCode = OrderTxt.getText();

                    String sql = "SELECT * FROM `product` WHERE OrderCode=?";
                    try {
                        pst=con.prepareStatement(sql);
                        pst.setString(1, OrderCode);
                        resultSet=pst.executeQuery();
                        if(resultSet.next()==false){
                            JOptionPane.showMessageDialog(null,"Order Not Found!!");
                        }
                        else{
                            String Product= resultSet.getString("Product");
                            NameTxt.setText(Product.trim());
                            String Price = resultSet.getString("Price");
                            PriceTxt.setText(Price.trim());
                            Quantity.requestFocus();

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int price= Integer.parseInt(PriceTxt.getText());
                int qntyty=Integer.parseInt(quantity.getValue().toString());
                total= price*qntyty ;

                model=(DefaultTableModel)table1.getModel();
                model.addRow(new Object[]
                        {

                                OrderTxt.getText(),
                                NameTxt.getText(),
                                PriceTxt.getText(),
                                quantity.getValue().toString(),
                                total

                        });
                int sum=0;
                for (int i =0; i<table1.getRowCount();i++ ) {
                    sum = sum + Integer.parseInt(table1.getValueAt(i, 4).toString());

                }

                costTxt.setText(String.valueOf(sum));
                OrderTxt.setText("");
                NameTxt.setText("");
                PriceTxt.setText("");
                quantity.setValue(0);
                NameTxt.requestFocus();
            }
        });
        Print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pay = Integer.parseInt(PayTxt.getText());
                int cost =Integer.parseInt(costTxt.getText());

                int Return = pay-cost;
                ReturnTxt.setText(String.valueOf(Return));

                sales();
            }
        });

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Shop_Inventory_System();
                dispose();

            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                if(a==JOptionPane.YES_OPTION) {
                    model.removeRow(table1.getSelectedRow());
                    JOptionPane.showMessageDialog(null,"Successfully deleted");

                }

                costTxt.setText("");
            }
        });
        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin();
                dispose();
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        });

        Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaleDetails();
            }
        });
    }



    public void sales(){
        String totalcost = costTxt.getText();
        String pay = PayTxt.getText();
        String Return = ReturnTxt.getText();

        int id=0;

        try{
            String query ="INSERT INTO `sales`( `Subtotal`, `Pay`, `balance`) VALUES (?,?,?)";
            pst=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,totalcost);
            pst.setString(2,pay);
            pst.setString(3,Return);
            pst.executeUpdate();
            resultSet =pst.getGeneratedKeys();

            if(resultSet.next()){
                id=resultSet.getInt(1);
            }
            // int rows = table1.getRowCount();
            String qury=" INSERT INTO `salees`(`Sale id`, `Name`, `Price`, `Quantity`, `Total`) VALUES  (?,?,?,?,?)";
            pst1=con.prepareStatement(qury);
            String name="";
            String  price ="";
            String quntyty="";
            int total=0;

            for(int i=0; i<table1.getRowCount();i++){
                name=(String)table1.getValueAt(i,1);
                price=(String)table1.getValueAt(i,2);
                quntyty=(String)table1.getValueAt(i,3);
                total=(int)table1.getValueAt(i,4);


                pst1.setInt(1,id);
                pst1.setString(2,name);
                pst1.setString(3,price);
                pst1.setString(4,quntyty);
                pst1.setInt(5,total);
                pst1.executeUpdate();
            }
            JOptionPane.showMessageDialog(this,"Sales Complete ");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



}




