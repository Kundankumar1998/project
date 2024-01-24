import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends Frame implements ActionListener
{
    Menu menu,menu2,menu3,menu4,menu5;
    Menu submenu,submenu1,submenu2,submenu3,submenu4,submenu5,submenu6,submenu7,submenu8,submenu9;
    MenuBar mb;
    MenuItem logout,exit,mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,mi17,mi18,mi19,mi20,mi21,mi22,mi23,mi24,mi25,mi26,mi27,mi28,mi29,mi30;
    Label front_logo;
    Button b1,b2;
    Image img;
    Toolkit tk;
    
    public Admin()
    {  
        setSize(800,700);  
        setLayout(null);  
        setVisible(true);  
        tk=Toolkit.getDefaultToolkit();
        img=tk.getImage("HOSPITAL1.png");

        mb=new MenuBar();  
        menu=new Menu("Manage");  
        submenu1=new Menu("Manage Staff");  
        mi9=new MenuItem("Add_staff");  
        mi10=new MenuItem("Delete_staff");
        mi11=new MenuItem("Update_staff");
     
        submenu=new Menu("Manage Store");          
        mi4=new MenuItem("Add Medicine");  
        mi5=new MenuItem("Check Medicine");
        mi6=new MenuItem("Sold Medicine");
        mi7=new MenuItem("Purchese Order");
        mi8=new MenuItem("Empty");
        exit=new MenuItem("Exit");  
            
        submenu1.add(mi9);
        submenu1.add(mi10);
        submenu1.add(mi11);
        submenu.add(mi4);  
        submenu.add(mi5);
        submenu.add(mi6);
        submenu.add(mi7);
        submenu.add(mi8);

        menu.add(submenu1);
        menu.add(submenu);  
        
        menu2 = new Menu("View");
        submenu3 =new Menu("Staff");
        mi1=new MenuItem("All");
        mi2=new MenuItem("Name");
        mi3=new MenuItem("Salary");
        mi12=new MenuItem("D.O.J");
        
        submenu3.add(mi1);
        submenu3.add(mi2);
        submenu3.add(mi3);
        submenu3.add(mi12);
        menu2.add(submenu3);

        submenu4 =new Menu("Medicine");
        menu2.add(submenu4);
        mi13=new MenuItem("InStock");
        mi14=new MenuItem("OutStock");
        mi15=new MenuItem("Most Selling");
        mi16=new MenuItem("New Added");
        submenu4.add(mi13);
        submenu4.add(mi14);
        submenu4.add(mi15);
        submenu4.add(mi16);
        

        submenu5 =new Menu("Amount Purcheging");
        menu2.add(submenu5);
        mi17=new MenuItem("Today");
        mi18=new MenuItem("Month");
        mi19=new MenuItem("Year");
        submenu5.add(mi17);
        submenu5.add(mi18);
        submenu5.add(mi19);

        submenu6 =new Menu("Amount Selling");
        menu2.add(submenu6);
        mi20=new MenuItem("Today");
        mi21=new MenuItem("Month");
        mi22=new MenuItem("Year");
        submenu6.add(mi20);
        submenu6.add(mi21);
        submenu6.add(mi22);

        submenu7 =new Menu("Profit");
        menu2.add(submenu7);
        mi23=new MenuItem("Today");
        mi24=new MenuItem("Current Month");
        submenu7.add(mi23);
        submenu7.add(mi24);
        

        
        menu3=new Menu("Exit");
        menu3.add(exit);

        menu4 = new Menu("Account");
        submenu8 =new Menu("Account");
        menu4.add(submenu8);
        mi25=new MenuItem("Create A/C");
        mi26=new MenuItem("Delete A/C");
        mi27=new MenuItem("Update A/C");
        submenu8.add(mi25);
        submenu8.add(mi26);
        submenu8.add(mi27);
        menu4.add(submenu8);
        logout=new MenuItem("Logout");
        menu4.add(logout);
        mb.add(menu4);
        mb.add(menu);  
        mb.add(menu2);
        mb.add(menu3);
        
        setMenuBar(mb);  

        logout.addActionListener(this);
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
        mi12.addActionListener(this);
        mi13.addActionListener(this);
        mi14.addActionListener(this);
        mi15.addActionListener(this);
        mi16.addActionListener(this);
        mi17.addActionListener(this);
        mi18.addActionListener(this);
        mi19.addActionListener(this);
        mi20.addActionListener(this);
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);
        mi24.addActionListener(this);
        mi25.addActionListener(this);
        mi26.addActionListener(this);
        mi27.addActionListener(this);
    }   
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==exit)
       {
            dispose();
       }else
       if(e.getSource()==logout)
       {
            new Medicine();
            dispose();
       }else
       if(e.getSource()==mi1)
       {
         new Data();
       }
       if(e.getSource()==mi4)
      {
         new Add_Medicine();
      }else
      if(e.getSource()==mi5)
      {
         new Check_Medicine();
      }else
       if(e.getSource()==mi25)
       {
            new Create_adm();
       }else
       if(e.getSource()==mi26)
       {
        new Delete_adm();
       }else
       if(e.getSource()==mi9)
       {
            new Create_stf();
       }else
       if(e.getSource()==mi26)
       {
          new Delete_adm();
       }else
       if(e.getSource()==mi10)
       {
          new Delete_staff();
       }else
       if(e.getSource()==mi27)
       {
          new Update_adm();
       }else
       if(e.getSource()==mi11)
       {
          new Update_staff();
       }
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }
    
    public static void main(String ar[])
    {
      new Admin();
    }
}