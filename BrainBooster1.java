package brain.booster;

import com.mysql.jdbc.Connection;
import jaco.mp3.player.MP3Player;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.border.BevelBorder.RAISED;

/**
 *
 * @author SAPNA
 */
public class BrainBooster implements MouseListener
{
    int i,value=1,t=0,u=0,score=0;
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    JPanel panel1=new JPanel();
    JLabel label=new JLabel("1.");
    JLabel label1=new JLabel();
    ImageIcon icon=new ImageIcon("C:\\Users\\ADMIN\\Documents\\glitter.jpg");
    JButton b=new JButton("PLAY");
    JButton b1=new JButton("NEXT");
    JButton b2=new JButton("MEANING OF WORD");
    JLabel label2=new JLabel("SCORES:"+score);
    JRadioButton r,r1,r2,r3;
    ButtonGroup g=new ButtonGroup();
    ImageIcon i1=new ImageIcon("C:\\Users\\ADMIN\\Documents\\emoji5.png");
    ImageIcon i2=new ImageIcon("C:\\Users\\ADMIN\\Documents\\e1.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\ADMIN\\Documents\\emoji3.png");
    ImageIcon i4=new ImageIcon("C:\\Users\\ADMIN\\Documents\\emoji4.png");
    ImageIcon i5=new ImageIcon("C:\\Users\\ADMIN\\Documents\\dandu.png");
    ImageIcon i6=new ImageIcon("C:\\Users\\ADMIN\\Documents\\welcome.gif");
    ImageIcon i7=new ImageIcon("C:\\Users\\ADMIN\\Documents\\emoji2.png");
    ImageIcon i8=new ImageIcon("C:\\Users\\ADMIN\\Documents\\emoji6.png");
    MP3Player mp3;

    BrainBooster()
    {
        frame.setSize(400,400);
        frame.setTitle("GET PUZZLE WITH WORD");
        frame.setLayout(null);
        frame.setLocation(700,250);
        frame.add(panel);
        label1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\stock-photo-pink-background-sparkles-glitter-ombre-colourful-background-glittery-hot-pink-ombre-pink-ombre-effect-ac2729b7-5a9d-4f33-bee0-c48f4171e011.jpg"));
        label1.setBounds(0,0,400,400);
        label.setBounds(100,50,50,25);
        label.setFont(new Font("ALGERIAN",1,24));
        label.setForeground(Color.white);
        label2.setBounds(240,10,150,25);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("ALGERIAN",2,24));
        r=new JRadioButton();
        r1=new JRadioButton();
        r2=new JRadioButton();
        r3=new JRadioButton();
        r.addMouseListener(this);
        r1.addMouseListener(this);
        r2.addMouseListener(this);
        r3.addMouseListener(this);
        frame.add(r);
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.setBounds(150,50,80,25);
        b.setFont(new Font("Monotype Corsiva",1,18));
        b.setForeground(Color.BLACK);
        b1.setBounds(250,300,80,25);
        b.setBorder(BorderFactory.createBevelBorder(RAISED));
        b2.setBounds(50,300,150,25);
        frame.add(label);
        frame.add(b);
        frame.add(b1);
        frame.add(b2);
        frame.add(label2);
        frame.add(label1);
        JOptionPane.showMessageDialog(frame,"YOUR GAME STARTS NOW","START",INFORMATION_MESSAGE, i6);
        frame.setVisible(true);
        
        b.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                g.clearSelection();
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
                    PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from quiz where id = ?");
                    ResultSet rs;
                    ps.setInt(1,value);
                    rs=ps.executeQuery();
                    if(rs.next())
                    {
                        MP3Player mp3= new MP3Player(new File(rs.getString("voice")));
                        mp3.play();
                        label.setText(rs.getString("id"));
                        r.setText(rs.getString("o1"));
                        r1.setText(rs.getString("o2"));
                        r2.setText(rs.getString("o3"));
                        r3.setText(rs.getString("o4"));
                    }
                    r.setBounds(100,100,120,25);
                    r1.setBounds(100,140,120,25);
                    r2.setBounds(100,180,120,25);
                    r3.setBounds(100,220,120,25);
                    r.setFont(new Font("Monotype Corsiva",1,16));
                    r1.setFont(new Font("Monotype Corsiva",1,16));
                    r2.setFont(new Font("Monotype Corsiva",1,16));
                    r3.setFont(new Font("Monotype Corsiva",1,16));
                    g.add(r);
                    g.add(r1);
                    g.add(r2);
                    g.add(r3);
                }
                catch(ClassNotFoundException ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                }
                catch(SQLException ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                } 
            }
        });
             
        b1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                t=0;
                ++value;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
                    PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from quiz where id = ?");
                    ResultSet rs;
                    ps.setInt(1,value);
                    rs=ps.executeQuery();
                    if(rs.next())
                    {
                        label.setText(rs.getString("id"));
                    }
                    r.setText("");
                    r1.setText("");
                    r2.setText("");
                    r3.setText("");
                }
                catch(ClassNotFoundException ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                }
                catch(SQLException ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                }
                Statement st = null;
                /*try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
                    String email=st.toString();
                    //PreparedStatement pr=(PreparedStatement) con.prepareStatement("update signin set scores = ? where email_address= ?");
                    private JTextField fn;
                    public void setEmail(String email) {this.fn.setText(email);}
                    public String getEmail() {return this.fn.getText();}
                    public FrameOne()
                    {
                    st = con.createStatement();
                    String sql = "UPDATE signin" + "SET scores = ? WHERE email_address = '"+email+"'";
                    st.executeUpdate(sql);
                    //String scores=String.valueOf(score);
                    //pr.setString(1,scores);
                    ResultSet rs=st.executeQuery(sql);
                    if(rs.next())
                    {
                        String score = rs.getString("scores");
                        JOptionPane.showMessageDialog(frame,"SCORES ARE UPDATED SUCCESSFULLY");
                    }
                    rs.close();
                    //}
                }
                catch(SQLException ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                }
                catch(Exception ex)
                {
                     JOptionPane.showMessageDialog(frame, ex);
                }*/
            }
        });    
        
        b2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bb","root","");
                    String a = "meaning";
                    PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from quiz where id = ?");
                    ResultSet rs;
                    ps.setInt(1,value);
                    rs=ps.executeQuery();
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(frame,rs.getString("meaning"),"ANSWER", INFORMATION_MESSAGE,i1);
                        t=t+1;
                    }
                }
                catch (ClassNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(frame, ex);
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(frame, ex);
                }
            }
        });
        
        
    }    
    public static void main (String[] args) 
    {
        new BrainBooster();
    }

    public void mouseClicked(MouseEvent me) 
    {
        switch(value)
        {
            case 1:
                    if(r2.isSelected() && u==0 && t==0)
                    {
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                    }
                    else if(u != 0 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=1;
                    break;
            case 2:
                    if(r1.isSelected() && u==1 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 1 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=2;
                    break;
            case 3:
                    if(r.isSelected() && u==2 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 2 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=3;
                    break;
            case 4:
                    if(r1.isSelected() && u==3 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 3 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=4;
                    break;
            case 5:
                    if(r1.isSelected() && u==4 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 4 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=5;
                    break;
            case 6:
                    if(r3.isSelected() && u==5 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 5 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=6;
                    break;
            case 7:
                    if(r2.isSelected() && u==6 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 6 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=7;
                    break;
            case 8:
                    if(r3.isSelected() && u==7 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 7 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=8;
                    break;            
            case 9:
                    if(r1.isSelected() && u==8 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 8 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=9;
                    break;
            case 10:
                    if(r.isSelected() && u==9 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 9 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=10;
                    break;    
            case 11:
                    if(r3.isSelected() && u==10 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 10 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=11;
                    break;
            case 12:
                    if(r.isSelected() && u==11 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 11 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=12;
                    break;
            case 13:
                    if(r3.isSelected() && u==12 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 12 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=13;
                    break;
            case 14:
                    if(r2.isSelected() && u==13 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 13 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=14;
                    break;
            case 15:
                    if(r.isSelected() && u==14 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 14 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=15;
                    break;
            case 16:
                    if(r1.isSelected() && u==15 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 15 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=16;
                    break;
            case 17:
                    if(r2.isSelected() && u==16 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 16 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=17;
                    break;
            case 18:
                    if(r.isSelected() && u==17 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 17 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=18;
                    break;
            case 19:
                    if(r.isSelected() && u==18 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 18 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=19;
                    break;
            case 20:
                    if(r3.isSelected() && u==19 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 19 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=20;
                    break;
            case 21:
                    if(r2.isSelected() && u==20 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 20 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=21;
                    break;
            case 22:
                    if(r.isSelected() && u==21 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 21 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=22;
                    break;
            case 23:
                    if(r3.isSelected() && u==22 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 22 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=23;
                    break;
            case 24:
                    if(r1.isSelected() && u==23 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 23 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    u=24;
                    break;
            case 25:
                    if(r3.isSelected() && u==24 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"RIGHT ANSWER","Win",INFORMATION_MESSAGE,i2);
                        u=u+1;
                        score+=10;
                        label2.setText("SCORES:"+score);
                    }
                    else if(u != 24 && t==0)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU ARE NOT ELIGIBLE TO CHOOSE MULTIPLE ANSWERS","WARNING",INFORMATION_MESSAGE,i5);
                    }
                    else if(t != 0)
                    {
                        JOptionPane.showMessageDialog(frame,"DON'T ACT SO SMART","WARNING",INFORMATION_MESSAGE,i4);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame,"OOPS.... WRONG ANSWER...","You Lose",INFORMATION_MESSAGE,i3);
                        u=u+1;
                        score-=5;
                        label2.setText("SCORES:"+score);
                    }
                    t=0;
                    break; 
            default:
                    if(score==250)
                    {                    
                        JOptionPane.showMessageDialog(frame,"YOU WIN THE GAME","Winner",INFORMATION_MESSAGE,i7);
                    }
                    else if(score<=250)
                    {
                        JOptionPane.showMessageDialog(frame,"YOU HAVE TO CONCENTRATE ON THE WORD AND TRY AGAIN","Loser",INFORMATION_MESSAGE,i8);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame,"YOUR GAME STARTS NOW","START",INFORMATION_MESSAGE, i6);
                    }
                    frame.dispose();
                    break;
        };
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {        
    }

    @Override
    public void mouseReleased(MouseEvent me) 
    {
    }

    @Override
    public void mouseEntered(MouseEvent me) 
    {
    }

    @Override
    public void mouseExited(MouseEvent me) 
    {
    }
}
