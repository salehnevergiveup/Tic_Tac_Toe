/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic_tac_toy;

/**
 *
 * @author User
 */

import java.awt.*;
import javax.swing.*; 
import javax.swing.border.EmptyBorder;
 

public class StartPageContent extends  JPanel{
    
   JLabel lbPlayer1 = new JLabel("Player1:"); 
   JLabel lbPlayer2 = new JLabel("Player2:"); 
   JTextField p1 = new JTextField();
   JTextField p2 = new JTextField();
   JButton x = new  JButton("x"); 
   JButton x2 = new  JButton("x"); 
   JButton O = new  JButton("O");
   JButton O2 = new  JButton("O");
   JButton play = new JButton("Play");
   JButton clear = new JButton("Clear");
   JPanel continerPalyerOne = new JPanel(); 
   JPanel continerPalyerTwo = new JPanel(); 
   
   public  StartPageContent() { 
       
       this.setPreferredSize(new Dimension(500, 460));
       this.setBackground(new Color(53, 76, 100));

      
       //Player One 
        lbPlayer1.setFont(new Font("Tahoma",Font.BOLD, 15));
        lbPlayer1.setForeground(new  Color(245 ,245, 245));
        
        //TextField
        p1.setPreferredSize(new Dimension(250, 30));
        p1.setBorder(new EmptyBorder(0,0,0,0));
        p1.setFont(new Font("Tahoma", Font.CENTER_BASELINE , 20));
        p1.setBackground(new Color(87, 122, 158));
        p1.setForeground(new Color(245, 245, 245));
        
        
        //Buttons 
       x.setPreferredSize(new Dimension(50,30));
       x.setForeground(new Color(254, 0, 101));
       x.setBackground(new Color(38 ,56 ,74));
       x.setFont(new Font("Tahoma", Font.BOLD, 20));
       x.setBorder(new EmptyBorder(0,0,0,0));
       x.setFocusable(false);
       
       O.setPreferredSize(new Dimension(50,30));
       O.setForeground(new Color(4, 217 ,255));
       O.setFont(new Font("Tahoma", Font.BOLD, 20));
       O.setBorder(new EmptyBorder(0,0,0,0));
       O.setFocusable(false);
       O.setBackground(new Color(38 ,56 ,74));
       
       
        //Container Payer One 
       continerPalyerOne.setPreferredSize(new Dimension(500, 80));
       continerPalyerOne.setOpaque(false);
       continerPalyerOne.add(Box.createHorizontalStrut(5));
       continerPalyerOne.add(lbPlayer1);
       continerPalyerOne.add(Box.createHorizontalStrut(5));
       continerPalyerOne.add(p1);
       continerPalyerOne.add(Box.createHorizontalStrut(5));
       continerPalyerOne.add(x);
       continerPalyerOne.add(Box.createHorizontalStrut(5));
       continerPalyerOne.add(O);
       continerPalyerOne.add(Box.createHorizontalStrut(5));
        
       //Player Two 
       lbPlayer2.setFont(new Font("Tahoma", Font.BOLD, 15));
       lbPlayer2.setForeground(new  Color(245 ,245, 245));
       
       //TextField
       p2.setPreferredSize(new Dimension(250, 30));
       p2.setBorder(new EmptyBorder(0, 0, 0, 0));
       p2.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20)); 
       p2.setBackground(new Color(87, 122, 158));
       p2.setForeground(new  Color(245 ,245, 245));
       
       //Buttons
       x2.setPreferredSize(new Dimension(50, 30));
       x2.setForeground(new Color(254, 0, 101));
       x2.setFont(new Font("Tahoma", Font.BOLD, 20));
       x2.setBorder(new EmptyBorder(0,0,0,0));
       x2.setFocusable(false);
       x2.setBackground(new Color(38 ,56 ,74));
       
       O2.setPreferredSize(new Dimension(50, 30));
       O2.setForeground(new Color(4, 217 ,255));
       O2.setFont(new Font("Tahoma", Font.BOLD, 20));
       O2.setBorder(new EmptyBorder(0,0,0,0));
       O2.setFocusable(false);
       O2.setBackground(new Color(38 ,56 ,74));
       
       
       //Container Payer Tow 
       continerPalyerTwo.setPreferredSize(new Dimension(500, 80));
       continerPalyerTwo.setOpaque(false);
       continerPalyerTwo.add(Box.createHorizontalStrut(5));
       continerPalyerTwo.add(lbPlayer2);
       continerPalyerTwo.add(Box.createHorizontalStrut(5));
       continerPalyerTwo.add(p2);
       continerPalyerTwo.add(Box.createHorizontalStrut(5));
       continerPalyerTwo.add(x2);
       continerPalyerTwo.add(Box.createHorizontalStrut(5));
       continerPalyerTwo.add(O2);
       continerPalyerTwo.add(Box.createHorizontalStrut(5));
       
       //Play Button 
       play.setPreferredSize(new Dimension(100,30));
       play.setForeground(new Color(97 ,242 ,245));
       play.setFont(new Font("Tahoma", Font.BOLD, 20));
       play.setFocusable(false);
       play.setBorder(new EmptyBorder(0,0,0,0));
       play.setBackground(new Color(38 ,56 ,74));
       
       
        //clear Button 
       clear.setPreferredSize(new Dimension(100,30));
       clear.setForeground(new Color(254, 0, 101));
       clear.setFont(new Font("Tahoma", Font.BOLD, 20));
       clear.setFocusable(false);
       clear.setBorder(new EmptyBorder(0,0,0,0));
       clear.setBackground(new Color(38 ,56 ,74));
       
       //
       JLabel text = new JLabel("TIC TAC TOY");
       text.setForeground(new  Color(245 ,245, 245));
       text.setFont(new Font("Tahoma", Font.BOLD, 20));
       
       JPanel title = new  JPanel(); 
       title.add(text);
       title.setOpaque(false);
       title.setPreferredSize(new Dimension(500, 80));
       
       
       this.add(title);
       this.add(continerPalyerOne);
       this.add(continerPalyerTwo);
       this.add(play);
       this.add(clear);
   }
   
   
   public JTextField getPlayerOneName() { 
       return p1; 
   }
   
   public JTextField getPlayerTwoName() { 
       return p2; 
   }
   
   public String getButtonText(JButton button) { 
       return button.getText();
   }
   
   public JButton[] getButtonsP1() { 
       JButton[] buttons = {O,x};
       return buttons;
   }
   public JButton[] getButtonsP2() { 
       JButton[] buttons = {x2,O2};
       return buttons;
   }
   
   public JButton getButtonClear() { 
       return clear;
   }

   public JButton getPlayButton() { 
       return play;
   }

}
