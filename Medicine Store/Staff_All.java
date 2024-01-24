import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Staff_All extends Frame implements ActionListener
{
    Connection con=null;

    TextArea ta1;
    Button b1;
    Label l1,l2;    
    Staff_All()
    {
        setSize(600,600);
        setVisible(true);
        setLayout(null);

        ta1=new TextArea();
        ta1.setBounds(40,40,400,200);
        add(ta1);
        b1=new Button("Get");
        b1.setBounds(200,250,60,25);
        b1.addActionListener(this);
        add(b1);

    }
    public void actionPerformed(ActionEvent e)
    {
        String name=null;
        String pass=null;
        if(e.getSource()==b1)
        {
             try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs= st.executeQuery("select * from admin");
                while(rs.next())
                {
                    name=rs.getString(1);
                    pass=rs.getString(3);
                    ta1.setText(name);
                   // ta1.setText(pass);
                    
                }
            } 
            catch(Exception ex)
            {
               System.out.println(ex);
            }
        }
    }
    public static void main(String ar[])
    {
        new Staff_All();
    }
}