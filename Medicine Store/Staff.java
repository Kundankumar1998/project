import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Staff extends Frame implements ActionListener
{
    Menu menu,menu2,menu3,menu4;
    MenuBar mb;
    MenuItem exit,mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11;  
    Image img;
    Toolkit tk;  
    
    public Staff()
    {  
        setSize(800,700);  
        setLayout(null);  
        setVisible(true); 
        tk=Toolkit.getDefaultToolkit();
        img=tk.getImage("HOSPITAL1.png"); 

        mb=new MenuBar();  
        menu=new Menu("Billin");  
        mi1=new MenuItem("new Billing");  
        mi2=new MenuItem("Old Bill");
        mi3=new MenuItem("Update Bill");
     
        menu.add(mi1);
        menu.add(mi2);
        menu.add(mi3);
        
        menu2=new Menu("Medicine");          
        mi4=new MenuItem("Add Medicine");  
        mi5=new MenuItem("Check Medicine");
        mi6=new MenuItem("Sold Medicine");
        mi7=new MenuItem("Purchese Order");
        mi8=new MenuItem("Empty");
        
        menu2.add(mi4);  
        menu2.add(mi5);
        menu2.add(mi6);
        menu2.add(mi7);
        menu2.add(mi8);

        menu3 = new Menu("Credential");
        mi9=new MenuItem("Change Password");
        mi10=new MenuItem("Change Usename");
        mi11=new MenuItem("Logout");
        menu3.add(mi9);
        menu3.add(mi10);
        menu3.add(mi11);

        menu4=new Menu("Exit");
        exit=new MenuItem("Exit");  
        menu4.add(exit);
        
        mb.add(menu);  
        mb.add(menu2);
        mb.add(menu3);
        mb.add(menu4);
        setMenuBar(mb);  

        exit.addActionListener(this);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi9.addActionListener(this);
        mi10.addActionListener(this);
        mi11.addActionListener(this);
    }   
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==exit)
       {
            dispose();
        }else
        if(e.getSource()==mi1)
        {
            new New_Bill();
            dispose();
        }else
        if(e.getSource()==mi4)
        {
            new Add_Medicine();
        }else
       if(e.getSource()==mi11)
       {
            new Medicine();
            dispose();
        }else
        if(e.getSource()==mi5)
        {
            new Check_Medicine();
        }
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }
}