import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Update_adm extends Frame implements ActionListener
{
    Label l1,msg_l,id_l,l2;
    Button b1,b2;
    MenuItem m1;
    Choice ch1;
    TextField tf1,id_tf;
    Update_adm()
    {
        setSize(500,400);
        setVisible(true);
        setLayout(null);
        setBackground(Color.cyan);

        ch1=new Choice();
        ch1.setBounds(110,130,100,40);
        add(ch1);
        
        id_l=new Label("ID :");
        id_l.setBounds(150,80,40,30);
        add(id_l);

        id_tf = new TextField();
        id_tf.setBounds(200,80,100,30);
        add(id_tf);

        tf1 = new TextField();
        tf1.setBounds(200,130,100,30);
        add(tf1);

        b1=new Button("Submit");
        b1.setBounds(170,190,60,25);
        add(b1);
        b1.addActionListener(this);

        b2=new Button("Back");
        b2.setBounds(30,30,60,25);
        add(b2);
        b2.addActionListener(this);
       
        ch1.add("Name");    
        ch1.add("Password");
        ch1.add("Email");
        ch1.add("Mobile");
        ch1.add("Address");

        msg_l=new Label();
        msg_l.setBounds(150,40,120,30);
        add(msg_l);

        l1=new Label();
        l1.setBounds(150,60,100,100);
        add(l1); 
    }
    public void actionPerformed(ActionEvent e)
    {
        String data=null;
        String Value=null;
        int temp=0,id=0;
        if(e.getSource()==b2)
        {
            dispose();
        }
        if(e.getSource()==b1)
        {
            data =ch1.getItem(ch1.getSelectedIndex()); 
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs=null;    
                id=Integer.parseInt(id_tf.getText());
                Value=tf1.getText();
                if(data.equals("Name"))
                {
                    st.executeUpdate("update admin set name=('"+Value+"') where id=("+id+")");
                    msg_l.setText("Update Succesfully");
                    temp++;  
                    con.close();      
                }else
                if(data.equals("Password"))
                {
                    st.executeUpdate("update admin set password=('"+Value+"') where id=("+id+")");
                    msg_l.setText("Update Succesfully");
                    temp++;  
                    con.close();      
                }else
                if(data.equals("Email"))
                {
                    st.executeUpdate("update admin set email=('"+Value+"') where id=("+id+")");
                    msg_l.setText("Update Succesfully");
                    temp++;  
                    con.close();      
                }else
                if(data.equals("Mobile"))
                {
                    st.executeUpdate("update admin set mobile=('"+Value+"') where id=("+id+")");
                    msg_l.setText("Update Succesfully");
                    temp++;  
                    con.close();      
                }else
                if(data.equals("Address"))
                {
                    st.executeUpdate("update admin set address=('"+Value+"') where id=("+id+")");
                    msg_l.setText("Update Succesfully");
                    temp++;  
                    con.close();      
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            if(temp==0)
            {
                msg_l.setText("ERROR");
            }
        }
    }
    public static void main(String a[])
    {
        new Update_adm();
    }

}