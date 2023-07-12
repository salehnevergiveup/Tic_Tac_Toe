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

public class Footer extends JPanel{
    
    private JButton leave = new  JButton("Exit"); 
    private  Sound Buttonsound;
    private  Sound backgorundSound;
    
    public Footer(JFrame GameFrame) { 
        this.setPreferredSize(new Dimension(500, 40));
        this.setMaximumSize(new Dimension(500, 40));
        this.setBackground(new Color(87, 122, 158));
        
        // 
        leave.setPreferredSize(new Dimension(100, 30));       
        leave.setMaximumSize(new Dimension(100, 40));
        leave.setForeground(new Color(254, 0, 101));
        leave.setBackground(new Color(38, 56, 74));
        leave.setFont(new Font("Tahoma", Font.BOLD, 20));
        leave.setBorder(new EmptyBorder(0, 0, 0, 0));
        leave.setFocusable(false);
        
        this.add(leave);
        
        leave.addActionListener(
          new ActionListener(){ 
              @Override
              public void actionPerformed(ActionEvent  e) { 
                  new StartFrame().setVisible(true);
                  GameFrame.dispose();
                  if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                  backgorundSound.close();
              }
          }
        );
    }
    
    public void setButtonSound(Sound Buttonsound) { 
        this.Buttonsound= Buttonsound;
    }
    public void setbackgorundSound(Sound backgorundSound) { 
        this.backgorundSound = backgorundSound;
    }
    
}
