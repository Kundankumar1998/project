import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;   
class TableExample(String n) //implements ActionListener
{    
   
    JFrame f;    
    JButton b1;
    String s="100";
    TableExample(){    
    f=new JFrame(); 

    b1 =new JButton("Done");
    b1.setBounds(150,200,80,30);
    f.add(b1);
    //b1.addActionListener(this);    
    String data[][]={ {s,"Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[]={"ID","NAME","SALARY"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(500,400);    
    f.setVisible(true);
       
}     
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b1)
    {
        f.dispose();
    }

}
/*public static void main(String[] args) {    
    new TableExample();    
}  */  
}  