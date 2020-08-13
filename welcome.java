package brain.booster;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SAPNA
 */
public class welcome implements ActionListener
{
    JFrame j;
    
    public static void main(String[] arg)
    {
        new welcome();
    }
    
    welcome()
    {
    j=new JFrame();
    JLabel l=new JLabel();
    JLabel l1=new JLabel();
    l.setBounds(30,130,320,80);
    l1.setBounds(0,0,400,400);;
    JButton b=new JButton("Login");
    JButton b1=new JButton("Signup");
    JButton b2=new JButton("How to Play");
    b.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b.setBounds(165,260,70,25);
    b1.setBounds(160,300,80,25);
    b2.setBounds(270,20,100,25);
    l.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\w1.gif"));
    l1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\star1.gif")); 
    j.setLayout(null);
    j.setTitle("WELCOME");
    j.setSize(400,400);
    j.setLocation(700,250);
    j.add(b);
    j.add(b1);
    j.add(b2);
    j.add(l);
    j.add(l1);
    j.setVisible(true);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String name=ae.getActionCommand();
        if(name.equals("Login"))
        {
           new login();
           j.dispose();
        }
        else if(name.equals("Signup"))
        {
            new signup();
            j.dispose();
        }
        else
        {
            new Instructions();
            j.dispose();
        }
    }
}
