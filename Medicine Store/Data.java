import java.awt.*;      
import java.awt.event.*;
import java.sql.*;      
import javax.swing.*;   
public class Data extends Frame implements ActionListener
{
    Connection con;
    int i=-1,j=-1;
    String s[][]=new String[3][10];
    Button b1;
    JFrame f;
    Data()
    {
        setSize(200,200);
        setLayout(null);
        setVisible(true);

        b1=new Button("Check");
        b1.setBounds(70,70,60,35);
        add(b1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==b1)
        {
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                
                ResultSet rs= st.executeQuery("select * from staff");
                while(rs.next())
                {
                    i=i+1;
                    j=j+1;
                    s[i][j]=rs.getString(1);
                    j=j+1;
                    s[i][j]=rs.getString(2);
                    j=j+1;
                    s[i][j]=rs.getString(4);
                    j=-1;
                }
            } 
            catch(Exception ex)
            {
               System.out.println(ex);
            }
                f=new JFrame();   
                String data111[][]=new String[3][10];
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        data111[i][j]=s[i][j];
                    }
                }
                String column[]={"NAME","ID","MOBILE"};         
                JTable jt=new JTable(data111,column);    
                jt.setBounds(30,40,200,300);          
                JScrollPane sp=new JScrollPane(jt);    
                f.add(sp);
                f.setSize(500,400);    
                f.setVisible(true);

            dispose();
        }
    }

   /* public static void main(String ar[])
    {
       new Data();
    }*/

}