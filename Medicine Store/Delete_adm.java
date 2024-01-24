import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Delete_adm extends Frame implements ActionListener
{
    Label l1,l2,msg_l;
    TextField id_tf;
    Button b1,b2;
    int a_id=0,i=0;
    Delete_adm()
    {
        setSize(500,400);
        setVisible(true);
        setLayout(null);
        setBackground(Color.cyan);

        msg_l = new Label();
        msg_l.setBounds(220,80,110,25);
        add(msg_l);

        l2=new Label("ID       :");
        l2.setBounds(120,130,60,25);
        id_tf=new TextField();
        id_tf.setBounds(220,130,120,30);

        add(l2);
        add(id_tf);
   
        b1=new Button("Submit");
        b1.setBounds(220,190,70,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new Button("Close");
        b2.setBounds(50,40,70,30);
        add(b2);
        b2.addActionListener(this);
        ///b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        int temp=0;
        if(e.getSource()==b2)
        {
           dispose();
        }else
        if(e.getSource()==b1)
        {
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs=null;    
                a_id=Integer.parseInt(id_tf.getText());

                i=st.executeUpdate("delete from admin where id = ("+a_id+")");
                msg_l.setText("Deteted Succesfully");
                temp++;  
                con.close();      
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            if(temp==0)
            {
                msg_l.setText("ERROR");
                //System.out.println("error");
            }
        }
    }
    
}