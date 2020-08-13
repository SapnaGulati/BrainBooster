/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.booster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class Instructions implements ActionListener
{
    JFrame frame;
    JButton button;
    JLabel l;
    JTextArea t;
    JScrollPane s;
    
    Instructions()
    {
        frame=new JFrame();
        button=new JButton("Tap to Continue");
        t=new JTextArea(460,380);
        s=new JScrollPane(t);
        l=new JLabel();
        frame.setLayout(null);
        frame.setTitle("How To Play");
        frame.setSize(500,500);
        frame.setLocation(700,300);
        button.setBounds(170,400,140,25);
        button.addActionListener(this);
        t.setRows(5);
        t.setColumns(25);
        t.setBounds(10,10,460,380);
        t.setLineWrap(true);
        t.setEditable(false);
        t.setVisible(true);
        t.setFont(new java.awt.Font("Times New Roman", 1, 13));
        t.setBackground(new java.awt.Color(51, 51, 0));
        t.setForeground(new java.awt.Color(153, 255, 255));
        t.setText(" \t Welcome to the game \"Get Puzzle With Word.\" \n \n        In this game you will interact with some new vacobulory words. User will \n listen the word and then have to guess the right spelling of the word. There are \n four options from which user have to choose only the right one.\n\nHow To Play:-\n-At starting you have to signup in the game and then log-in into the login page \n with the password. \n-Then you will see the welcome note and the game will start.\n-You have to click on the \'Play\' word and you will listen a voice. You have to \n concentrate on the voice and then the four options will be shown.\n-You have to choose the right one option.\n-Once you will choose the right option, you will get the message of right answer. \n-After choosing a option either a right one or the wrong, you will be able to see the meaning of the word.\n-After that you can click on the next button and can answer the more questions.\n-You will also able to know your scores side by side.\n-In last, if you have answered all the questions correctly, then you will win the \n game otherwise you lose.\n\nRules & Regulations:-\n-If you answer a question correctly, you will get 10 scores.\n-If you answer a question wrong, then the 5 marks from your scores will be \n deducted.\n-After seeing the meaning of the word, you will not able to choose the option.\n-If you have choosen a wrong answer,then there will be no option to choose \n another option for getting the right answer.\n\nBenefits of the Game-\n-By playing this game, you can enjoy and with enjoying you will able to learn new \n words simultaneously.\n-You can improve your listening skills.\n-You can also learn the spellings of the difficult words simultaneously.\n\n          I hope you understand all the process of the game. So, \"All The Best\" and \n Let's play the game.");
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setBounds(10,10,460,380);
        l.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\giphy1.gif"));
        l.setBounds(0,0,500,500);
        frame.add(button);
        frame.add(s);
        frame.add(l);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] arg)
    {
        new Instructions();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String name=ae.getActionCommand();
        if(name.equals("Tap to Continue"))
        {
           new welcome();
           frame.dispose();
        }
    }
}
