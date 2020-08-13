/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.booster;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import javax.swing.*;
/**
 *
 * @author ADMIN
 */
public class signup implements ActionListener
{
    JFrame jf;
    JLabel sign,fn,ln,em,ad,a,g,p,mobile,st,cn,ct,bd,by,bm,l1,l2,l3,l4;
    JTextField n,n1,add,email,age,mobileno,state,country,city;
    JButton signup;
    JComboBox gender,birthmonth,birthdate,birthyear;
    JPasswordField pass;
    Container c;
    public void initialize()
    {
        jf=new JFrame();
        sign=new JLabel("SIGN-IN PAGE");
        fn=new JLabel("FIRST NAME :");
        ln=new JLabel("LAST NAME :");
        em=new JLabel("E-MAIL :");
        p=new JLabel("PASSWORD :");
        ad=new JLabel("ADDRESS :");
        a=new JLabel("AGE :");
        g=new JLabel("GENDER :");
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        signup=new JButton("SIGN-UP");
        mobile=new JLabel("MOBILE NUMBER :");
        cn=new JLabel("COUNTRY :");
        st=new JLabel("STATE :");
        ct=new JLabel("CITY :");
        bd=new JLabel("BIRTH DATE :");
        bm=new JLabel("BIRTH MONTH :");
        by=new JLabel("BIRTH YEAR :");
        signup.addActionListener(this);
        n=new JTextField();
        n1=new JTextField();
        email=new JTextField();
        add=new JTextField();
        age=new JTextField();
        String ob[]={"Male","Female","Other"};
        gender=new JComboBox(ob);
        pass=new JPasswordField();
        mobileno=new JTextField();
        state=new JTextField();
        country=new JTextField();
        city=new JTextField();
        String d[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        birthdate=new JComboBox(d);
        String ob1[]={"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
        birthmonth=new JComboBox(ob1);
        String y[]={"Below 1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","Above 2010"};
        birthyear=new JComboBox(y);
        c=new Container();
    } 
    public void setbound()
    {
        sign.setBounds(270,20,250,40);
        fn.setBounds(15,100,150,30);
        ln.setBounds(420,100,150,30);
        n.setBounds(160,100,150,30);
        n1.setBounds(550,100,150,30);
        em.setBounds(15,150,150,30);
        p.setBounds(15,200,150,30);
        mobile.setBounds(390,200,180,30);
        ad.setBounds(15,250,150,30);
        a.setBounds(15,300,100,30);
        g.setBounds(420,300,100,30);
        cn.setBounds(15,350,100,30);
        st.setBounds(280,350,80,30);
        ct.setBounds(500,350,80,30);
        bd.setBounds(15,400,120,30);
        bm.setBounds(250,400,140,30);
        by.setBounds(480,400,120,30);
        email.setBounds(160,150,530,30);
        add.setBounds(160,250,530,30);
        age.setBounds(160,300,150,30);
        gender.setBounds(550,300,150,30);
        pass.setBounds(160,200,150,30);
        mobileno.setBounds(550,200,150,30);
        country.setBounds(160,350,80,30);
        state.setBounds(380,350,80,30);
        city.setBounds(600,350,100,30);
        birthdate.setBounds(160,400,80,30);
        birthmonth.setBounds(380,400,80,30);
        birthyear.setBounds(600,400,100,30);
        signup.setBounds(320,500,100,30);
        l1.setBounds(0,0,365,300);
        l2.setBounds(0,300,365,300);
        l3.setBounds(365,0,367,300);
        l4.setBounds(365,300,367,300);
    }
    public void fonts()
    {
        sign.setFont(new Font("ENGRAVERS MT",1,22));
        fn.setFont(new Font("Castellar",1,14));
        ln.setFont(new Font("Castellar",1,14));
        em.setFont(new Font("Castellar",1,14));
        p.setFont(new Font("Castellar",1,14));
        ad.setFont(new Font("Castellar",1,14));
        a.setFont(new Font("Castellar",1,14));
        g.setFont(new Font("Castellar",1,14));
        mobile.setFont(new Font("Castellar",1,14));
        bd.setFont(new Font("Castellar",1,14));
        bm.setFont(new Font("Castellar",1,14));
        by.setFont(new Font("Castellar",1,14));
        cn.setFont(new Font("Castellar",1,14));
        st.setFont(new Font("Castellar",1,14));
        ct.setFont(new Font("Castellar",1,14));
        n.setFont(new Font("Arial",0,14));       
        n1.setFont(new Font("Arial",0,14)); 
        email.setFont(new Font("Arial",0,14));       
        add.setFont(new Font("Arial",0,14)); 
        age.setFont(new Font("Arial",0,14));       
        gender.setFont(new Font("Arial",0,14)); 
    }
    public void foreground()
    {
        sign.setForeground(new java.awt.Color(255, 255, 255));
        fn.setForeground(new java.awt.Color(255, 255, 255));
        ln.setForeground(new java.awt.Color(255, 255, 255));
        em.setForeground(new java.awt.Color(255, 255, 255));
        p.setForeground(new java.awt.Color(255, 255, 255));
        ad.setForeground(new java.awt.Color(255, 255, 255));
        a.setForeground(new java.awt.Color(255, 255, 255));
        g.setForeground(new java.awt.Color(255, 255, 255));
        mobile.setForeground(new java.awt.Color(255, 255, 255));
        bd.setForeground(new java.awt.Color(255, 255, 255));
        bm.setForeground(new java.awt.Color(255, 255, 255));
        by.setForeground(new java.awt.Color(255, 255, 255));
        cn.setForeground(new java.awt.Color(255, 255, 255));
        st.setForeground(new java.awt.Color(255, 255, 255));
        ct.setForeground(new java.awt.Color(255, 255, 255));
    }
    public static void main(String[] args)
    {
       new signup();
    }
    signup()
    {
        initialize();
        setbound();
        fonts();
        foreground();
        l1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\cCf7T.gif"));
        l2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\cCf7T.gif"));
        l3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\cCf7T.gif"));
        l4.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\cCf7T.gif"));
        jf.setLayout(null);
        jf.setTitle("SIGNIN PAGE");
        jf.setSize(750,600);
        jf.setLocation(650,200);
        c=jf.getContentPane();
        c.setBackground(Color.CYAN);
        c.add(sign);
        c.add(fn);
        c.add(ln);
        c.add(em);
        c.add(p);
        c.add(ad);
        c.add(bd);
        c.add(by);
        c.add(bm);
        c.add(ct);
        c.add(st);
        c.add(cn);
        c.add(mobile);
        c.add(country);
        c.add(state);
        c.add(city);
        c.add(mobileno);
        c.add(birthdate);
        c.add(birthmonth);
        c.add(birthyear);
        c.add(a);
        c.add(g);
        c.add(n);
        c.add(n1);
        c.add(email);
        c.add(add);
        c.add(age);
        c.add(gender);
        c.add(pass);
        c.add(signup);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
            PreparedStatement pr=(PreparedStatement) con.prepareStatement("insert into signin values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String first_name=n.getText();
            String last_name=n1.getText(); 
            String address=add.getText();
            String email_address=email.getText();
            String ag=age.getText();
            String pw=pass.getText();
            String mon=birthmonth.getSelectedItem().toString();
            String bdate=birthdate.getSelectedItem().toString();
            String byear=birthyear.getSelectedItem().toString();
            String gen=gender.getSelectedItem().toString();
            String mob=mobileno.getText();
            String se=state.getText();
            String c1=country.getText();
            String t=city.getText();
            pr.setString(1,first_name);
            pr.setString(2,last_name);
            pr.setString(3,address);
            pr.setString(4,email_address);
            pr.setString(5,ag);
            pr.setString(6,pw);
            pr.setString(7,mon);
            pr.setString(8,bdate);
            pr.setString(9,byear);
            pr.setString(10,gen);
            pr.setString(11,mob);
            pr.setString(12,se);
            pr.setString(13,c1);
            pr.setString(14,t);
            pr.executeUpdate();
            if(first_name.isEmpty() || last_name.isEmpty() || address.isEmpty() || email_address.isEmpty() || ag.isEmpty() || pw.length()<8 || mob.isEmpty() || se.isEmpty() || c1.isEmpty() || t.isEmpty() || mon.equals("Month") || bdate.equals("Date"))
            {
                JOptionPane.showMessageDialog(c,"PLEASE FILL THE DETAILS AND TRY AGAIN...");
            }
            else if(pw.length()<8)
            {
                JOptionPane.showMessageDialog(c,"PASSWORD SHOULD BE ATLEAST OF 8 CHARACTERS...");
            }
            else
            {
                JOptionPane.showMessageDialog(c,"SUCCESSFULLY SIGNED IN...");
                new login();
                jf.dispose();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(c,"not inserted"+e);  
        } 
    } 
}
   
