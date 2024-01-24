import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Create_stf extends Frame implements ActionListener
{
    Label l1,l2,l3,l4,l5,l6,l7,l8,msg_l;
    TextField name_tf,id_tf,pass_tf,mobile_tf,salary_tf,email_tf,add_tf;
    Button b1,b2;
    Image img;
    Toolkit tk;
    String s_name,s_pass,s_email,s_add;
    int s_id=0,s_mobile=0,s_salary=0,i=0;
    Create_stf()
    {
        setSize(800,700);
        setVisible(true);
        setLayout(null);
        tk=Toolkit.getDefaultToolkit();
        img=tk.getImage("HOSPITAL1.png");

        msg_l=new Label();
        msg_l.setBounds(200,45,120,25);

        l1=new Label("Name :");
        l1.setBounds(200,80,60,25);
        name_tf=new TextField();
        name_tf.setBounds(300,80,120,30);
        
        l2=new Label("ID       :");
        l2.setBounds(200,130,60,25);
        id_tf=new TextField();
        id_tf.setBounds(300,130,120,30);

        l3=new Label("Password :");
        l3.setBounds(200,180,60,25);
        pass_tf=new TextField();
        pass_tf.setBounds(300,180,120,30);

        l4=new Label("Mobile :");
        l4.setBounds(200,230,60,25);
        mobile_tf=new TextField();
        mobile_tf.setBounds(300,230,120,30);

        l5=new Label("Salary :");
        l5.setBounds(200,280,60,25);
        salary_tf=new TextField();
        salary_tf.setBounds(300,280,120,30);

        l6=new Label("Email :");
        l6.setBounds(200,330,60,25);
        email_tf=new TextField();
        email_tf.setBounds(300,330,120,30);

        l7=new Label("Address :");
        l7.setBounds(200,390,60,25);
        add_tf=new TextField();
        add_tf.setBounds(300,390,120,30);

        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
        add(name_tf);add(id_tf);add(pass_tf);add(mobile_tf);add(salary_tf);add(email_tf);add(add_tf);
   
        b1=new Button("Submit");
        b1.setBounds(300,440,70,30);
        add(b1);
        b1.addActionListener(this);

        b2=new Button("Back");
        b2.setBounds(30,40,60,25);
        add(b2);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        int temp=0;
        if(e.getSource()==b2)
        {
            dispose();
        }
        if(e.getSource()==b1)
        {
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs=null;    
                s_name=name_tf.getText();
                s_id=Integer.parseInt(id_tf.getText());
                s_pass=pass_tf.getText();
                s_mobile=Integer.parseInt(mobile_tf.getText());
                s_salary=Integer.parseInt(salary_tf.getText());
                s_email=email_tf.getText();
                s_add=add_tf.getText();
            

                i=st.executeUpdate("insert into staff values('"+s_name+"',"+s_id+",'"+s_pass+"',"+s_mobile+","+s_salary+",'"+s_email+"','"+s_add+"')");
                temp++;
                add(msg_l);
                msg_l.setText("Succesfully Inserted");  
                con.close();      
        
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        
            if(temp==0)
            {
                add(msg_l);
                msg_l.setText("ERROR");
            }
        }

    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }
}