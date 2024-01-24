import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Add_Medicine extends Frame implements ActionListener
{
    Label msg,p_name,p_rate,p_qty;
    TextField tf_pname,tf_rate,tf_pqty;
    Button save,back,reset;
    String name=null,rate=null,qty=null;
    Add_Medicine()
    {
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setBackground(Color.cyan);

        msg =new Label();
        msg.setBounds(200,60,140,20);
        add(msg);
       // tf_pid=new TextField();
        p_name=new Label("Medicine Name :");
        p_name.setBounds(100,100,90,30);
        add(p_name);
        tf_pname=new TextField();
        tf_pname.setBounds(200,100,100,30);
        add(tf_pname);
        p_rate=new Label("Rate:");
        p_rate.setBounds(100,160,60,30);
        add(p_rate);
        tf_rate=new TextField();
        tf_rate.setBounds(200,160,100,30);
        add(tf_rate);

        p_qty=new Label("Quantity :");
        p_qty.setBounds(100,210,50,25);
        add(p_qty);
        tf_pqty=new TextField();
        tf_pqty.setBounds(200,210,100,30);
        add(tf_pqty);


        back=new Button("Back");
        back.setBounds(30,35,70,30);
        add(back);
        back.addActionListener(this);
        save=new Button("Save");
        save.setBounds(200,250,70,30);
        add(save);
        save.addActionListener(this);
        reset=new Button("reset");
        reset.setBounds(200,300,70,30);
        add(reset);
        reset.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            dispose();
        }else
        if(e.getSource()==save)
        {
            try
            {
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kundan");
                Statement st=con.createStatement();
                ResultSet rs=null;    
                name=tf_pname.getText();
                rate=tf_rate.getText();
                qty=tf_pqty.getText();
                st.executeUpdate("insert into medicine1 values('"+name+"','"+rate+"','"+qty+"')");      
                msg.setText("Added SuccessFully");
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
    }


}