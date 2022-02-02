import javax.swing.*;
import java.sql.*;

public class DbConnector   {
    public Connection con;
    public Statement st;
    public ResultSet resultSet;
    int flag=0;

    DbConnector(){

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            st = con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public void InsertRegister(String insertQuery) {


        try{
            st.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null,"SuccessFully Registered");

        }
        catch (SQLException E)
        {
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"SuccessFully not Registered");

        }


    }



    public void Login(String queryLogin, String userName, String password) {
        try{
            resultSet =st.executeQuery(queryLogin);
            while(resultSet.next())
            {
                String tableUserName= resultSet.getString(2);
                String tablepass = resultSet.getString(3);
                if(userName.equals(tableUserName) && password.equals(tablepass))
                {

                    JOptionPane.showMessageDialog(null,"Congrats You are Valid User!!");
                    flag=1;
                    new Shop_Inventory_System();
                    break;


                }


            }
            if (flag==0)
            {
                JOptionPane.showMessageDialog(null," You are Valid not  User! ):");
                new login();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



}





