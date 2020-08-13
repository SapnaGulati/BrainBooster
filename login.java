/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.booster;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class login implements ActionListener
{
    JFrame j;
    JLabel a,l,z,l1;
    JButton b,c;
    JTextField fn;
    JPasswordField pw;
    Container c1;
    public void initialization()
    {
        j=new JFrame();
        a=new JLabel("LOGIN PANEL");
        b=new JButton("Login");
        c=new JButton("Register");
        l=new JLabel("ENTER E-MAIL :");
        z=new JLabel("ENTER PASSWORD :");
        fn=new JTextField();
        pw=new JPasswordField();
        l1=new JLabel();
        c1 =new Container();
    }
    public void setbounds()
    {
        a.setBounds(140,20,250,40);
        b.setBounds(195,190,100,30);
        c.setBounds(195,230,100,30);
        l.setBounds(30,80,200,35);
        z.setBounds(30,130,250,30);
        fn.setBounds(300,80,150,30);
        pw.setBounds(300,130,150,30);
        l1.setBounds(0,0,500,320);
    }
    public void font()
    {
        a.setFont(new Font("ENGRAVERS MT",1,22));
        l.setFont(new Font("Castellar",1,16));
        z.setFont(new Font("Castellar",1,16));     
        fn.setFont(new Font("Arial",0,12));       
        pw.setFont(new Font("Arial",0,12)); 
    }
    public void foreground()
    {
        a.setForeground(Color.WHITE);            
        l.setForeground(Color.white);
    }
    public void background()
    {
        z.setForeground(Color.white);
    }
    public static void main(String[] args) 
    {
        login in=new login();
    }
    login()
    {    
       initialization();
       setbounds();
       font();
       foreground();
       background();
       l1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\giphy (1).gif"));
       j.setLayout(null);
       j.setTitle("LOGIN PAGE");      
       j.setSize(500,320);   
       j.setLocation(700,250);
       b.addActionListener(this);
       c.addActionListener(this);                     
       c1=j.getContentPane(); 
       c1.setBackground(Color.MAGENTA);
       c1.add(a);
       c1.add(l);
       c1.add(z);
       c1.add(fn);
       c1.add(pw);
       c1.add(b);
       c1.add(c);
       c1.add(l1);
       j.setVisible(true);
       j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        String name=ae.getActionCommand();
        if(name.equals("Login"))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
                String email=fn.getText();
                String Password=pw.getText();
                //FrameOne fr = new FrameOne();
                String a,b;
                a="email_address";
                b="pw";
                //fr.setEmail(email);
                //fr.setVisible(true);
                PreparedStatement pr=(PreparedStatement) con.prepareStatement("select * from signin where email_address = '"+email+"'");
                ResultSet rs;
                rs=pr.executeQuery();
                if(rs.next())
                {
                    a=rs.getString("email_address");
                    b=rs.getString("pw");
                }
                if(email.isEmpty() && Password.isEmpty())
                {
                    JOptionPane.showMessageDialog(c1,"USERNAME OR PASSWORD IS NOT ENTERED... PLEASE CHECK THE DETAILS CAREFULLY...");
                }
                else if(email.isEmpty())
                {
                   JOptionPane.showMessageDialog(c1,"ENTER THE USERNAME...");    
                }
                else if(Password.isEmpty())
                {
                    JOptionPane.showMessageDialog(c1,"ENTER THE PASSWORD...");
                }
                else if(Password.length()<8)
                {
                    JOptionPane.showMessageDialog(c1,"PASSWORD SHOULD BE ATLEAST OF 8 CHARACTERS...");
                }
                else
                {
                    if(email.equals(a) && Password.equals(b))
                    {
                        JOptionPane.showMessageDialog(c1,"LOGIN SUCCESSFULL...  WELCOME...");
                        new BrainBooster();
                        j.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(c1,"USERNAME OR PASSWORD IS IN-CORRECT..... PLEASE CHECK THE DETAILS....");
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(c1,"not inserted"+e);  
            }
        }
        else
        {
            new signup();
            j.dispose();
        }
    }
 
}



