/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic_tac_toy;

/**
 *
 * @author User
 */

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GameInfo extends JPanel{
  private JPanel titlePanel = new JPanel ();   
  private JLabel title = new  JLabel("Round");
  
  private JPanel player1Panel  = new  JPanel();
  private JLabel userName1 =  new JLabel(); 
  private JLabel role1 =  new JLabel(); 
  private JLabel wins1 =  new JLabel(); 
  
  private JPanel player1Pane2  = new  JPanel();
  private JLabel userName2 =  new JLabel(); 
  private JLabel role2 =  new JLabel(); 
  private JLabel wins2 =  new JLabel(); 
  
  private JButton clear = new JButton("Clear");
  private Player player1; 
  private Player player2;
  
  private Sound Buttonsound;
  
  public  GameInfo(Game game) { 
      
      this.setPreferredSize(new Dimension(312, 400));
      this.setLayout(new GridLayout(5,1,0, 20));
      this.setBorder(new LineBorder(new Color(87, 122, 158), 5));
      this.setOpaque(false);
  
      player1 = game.getPlayer1();
      player2 = game.getPlayer2();
      
      
      //title 
      titlePanel.setPreferredSize(new Dimension(302,  40));
      titlePanel.setLayout(new BorderLayout());
      title.setVerticalAlignment(SwingConstants.BOTTOM);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setForeground(new Color(97 ,242 ,245));
      title.setText("Round: " + 1);
      title.setFont(new Font("Tahoma",Font.BOLD , 20));
      titlePanel.add(title);
      titlePanel.setOpaque(false);
      add(titlePanel);
      
      //headers 
      JPanel header  = new  JPanel(); 
      JLabel userName = new JLabel("UserName");
      JLabel role = new JLabel("Role");
      JLabel win = new JLabel("Wins");
      header.setOpaque(false);
      setInfo( header , userName, role, win,15 ,15,15);

      //player One  
       userName1.setText(player1.getUserName());
       role1.setText(player1.getRole());
       wins1.setText(player1.getWin() + "");
       setInfo( player1Panel,userName1, role1, wins1,20,20,20);
       
       //Player Two
       userName2.setText(player2.getUserName());
       role2.setText(player2.getRole());
       wins2.setText(player2.getWin() + "");
       setInfo(player1Pane2, userName2, role2, wins2, 20, 20, 20);

       //Button 
       JPanel p = new JPanel();
       p.setOpaque(false);
       clear.setPreferredSize(new Dimension(100, 30));
       clear.setMaximumSize(new Dimension(100, 40));
       clear.setForeground(new Color(97 ,242 ,245));
       clear.setBackground(new Color(38, 56, 74));
       clear.setFont(new Font("Tahoma", Font.BOLD, 15));
       clear.setBorder(new EmptyBorder(0, 0, 0, 0));
       clear.setFocusable(false);
       
       p.add(clear);
       add(p);
       
       
       //function 
       clear.addActionListener(
        new  ActionListener() { 
            
            @Override
            public void  actionPerformed(ActionEvent e) { 
                if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                game.clear();
            }
        }
       
       );
  }
  
  public void setButtonSound(Sound Buttonsound) { 
        this.Buttonsound= Buttonsound;
  }
  
  public void setLabelRound(int round){ 
      title.setText( "Round: " + round);
  }
  public void setLabelWins1(int win1){ 
      this.wins1.setText( win1+"");
  }
  public void setLabelWins2(int win2){ 
       this.wins2.setText( win2+"");
  }
  
  
  private  void setInfo(JPanel panel , JLabel userName, JLabel role,  JLabel  win ,
                        int uSize, int rSize, int wSize ) { 
      
      panel.setOpaque(false);
      panel.setPreferredSize(new Dimension(302, 60));

     
      userName.setPreferredSize(new Dimension(102, 60));
      userName.setHorizontalAlignment(SwingConstants.CENTER);     
      userName.setVerticalAlignment(SwingConstants.TOP);
      userName.setFont(new Font("Tahoma", Font.BOLD, uSize));

      
      role.setPreferredSize(new Dimension(100, 60));
      role.setHorizontalAlignment(SwingConstants.CENTER);
      role.setVerticalAlignment(SwingConstants.TOP);
      role.setFont(new Font("Tahoma", Font.BOLD, rSize));
      
      win.setPreferredSize(new Dimension(80, 60));
      win.setHorizontalAlignment(SwingConstants.CENTER);
      win.setVerticalAlignment(SwingConstants.TOP);
      win.setFont(new Font("Tahoma", Font.BOLD, wSize));

      if(role.getText().equalsIgnoreCase("O")){ 
          userName.setForeground(new Color(4, 217 ,255));
          role.setForeground(new Color(4, 217 ,255));
          win.setForeground(new Color(4, 217 ,255));
      }else if(role.getText().equalsIgnoreCase("x")) { 
          userName.setForeground(new Color(254, 0, 101));
          role.setForeground(new Color(254, 0, 101));
          win.setForeground(new Color(254, 0, 101));
      }else { 
          userName.setForeground(new Color(97 ,242 ,245));
          role.setForeground(new Color(97 ,242 ,245));
          win.setForeground(new Color(97 ,242 ,245));
      }
      
      panel.add(userName);
      panel.add(role);
      panel.add(win);
      add(panel);
      
  }
  
}
