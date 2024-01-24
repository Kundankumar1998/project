import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Medicine extends Frame implements ActionListener
{
    Connection con=null;
    Button b2,b3,b4,b5;
    JButton b1;
    TextField tf1,tf2,tf3,tf4;
    Label l1,l2,l3,l4,l5;
    Image img;
    ImageIcon adm_But_img,stf_But_img;
    Toolkit tk,adm_tk,stf_tk;

    Medicine()
    {
        tk=Toolkit.getDefaultToolkit();
        adm_tk=Toolkit.getDefaultToolkit();
        img=tk.getImage("HOSPITAL1.png");
        adm_But_img=new ImageIcon("admin.jpg");
        setSize(800,700);
        setVisible(true);
        setLayout(null);

        b1=new JButton(adm_But_img);
        //b1.setBackgroundImage(adm_But_img);
        b1.setBounds(50,50,75,35);
        add(b1);
        b1.addActionListener(this);

        l5=new Label();
        l5.setBounds(300,50,130,15);
        

        b2=new Button("Staff");
        b2.setBounds(50,200,75,35);
        add(b2);
        b2.addActionListener(this);
    
        b3=new Button("Exit");
        b3.setBounds(700,40,75,35);
        add(b3);
        b3.addActionListener(this);

        l1 = new Label("Username:");     
        l2 = new Label("Password:");    
        tf1 = new TextField();
        tf2 = new TextField();
        tf2.setEchoChar('*');
        b4=new Button("Login");
        b4.addActionListener(this);
        b5=new Button("Login");
        b5.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e)
    {
        
        int match=0,temp=0;
        if(e.getSource()==b1)
        {
            b5.setBounds(0,0,0,0);
            l1.setBounds(20,100,65,25);
            l2.setBounds(20,130,65,25);
            tf1.setBounds(100,100,100,25);
            tf2.setBounds(100,130,100,25);
            b4.setBounds(100,160,60,25);
            add(l1);    
            add(l2);
            add(tf1);
            add(tf2);
            add(b4);
        }
        else if(e.getSource()==b4)
        {
            String name1=tf1.getText();
            String pass1=tf2.getText();
            String name=null,pass=null;
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
                    if(name.equals(name1) && pass.equals(pass1))
                    {       
                        new Admin();
                        con.close();
                        dispose();
                        match++;
                        break;
                    }
                }
                if(match==0)
                {
                    add(l5);
                    l5.setText("Wrong User&Password");
                    System.out.println("Error");
                    temp++;        
                }
            } 
            catch(Exception ex)
            {
               System.out.println(ex);
            }        
        }
        else if(e.getSource()==b2)
        {
            b4.setBounds(0,0,0,0);
            l1.setBounds(20,250,65,25);
            l2.setBounds(20,280,65,25);
            tf1.setBounds(100,250,100,25);
            tf2.setBounds(100,280,100,25);
            b5.setBounds(100,335,60,25);
            add(l1);    
            add(l2);
            add(tf1);
            add(tf2);
            add(b5);
        }else
        if(e.getSource()==b5)
        {
            String name1=tf1.getText();
            String pass1=tf2.getText();
            String name=null,pass=null;
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs= st.executeQuery("select * from staff");
                while(rs.next())
                {
                    name=rs.getString(1);
                    pass=rs.getString(3);
                    if(name.equals(name1) && pass.equals(pass1))
                    {
                        new Staff();
                        con.close();
                        dispose();
                        match++;
                        break;
                    }
                }
                if(match==0)
                {
                    add(l5);
                    l5.setText("Wrong User&Password");
                    System.out.println("Error");
                    temp++;        
                }   
            } 
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        } 
        else
        if(e.getSource()==b3)
        {
          dispose();
        }
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }
    public static void main(String[] ar)
    {
     new Medicine();
    }
}