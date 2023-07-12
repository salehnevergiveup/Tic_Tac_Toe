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
public class HeaderClass extends JPanel{
    
    private JLabel close  = new   JLabel("X"); 
    private JLabel min = new  JLabel("-");
    private JButton backgroundSoundButton =  new JButton("Music"); 
    private JButton buttonsSoundButton =  new JButton("Effect"); 
    private JPanel  labelContainer =  new  JPanel();
    
    public HeaderClass(JFrame GameFrame) { 
        this.setPreferredSize(new  Dimension(800,  40)); 
        this.setBackground(new Color(87, 122, 158));
        this.setLayout(new BorderLayout());
        //Label 
        close.setPreferredSize(new Dimension(40,40));
        close.setFont(new Font("Tahoma",Font.BOLD, 15));
        close.setForeground(Color.white);
        close.setBackground(Color.red);
        
        min.setPreferredSize(new Dimension(40,40));
        min.setFont(new Font("Tahoma",Font.BOLD, 15));
        min.setForeground(Color.white);
     
        
        labelContainer.setOpaque(false);
        labelContainer.setPreferredSize(new  Dimension(80, 40));
        labelContainer.setLayout(new BorderLayout());
        labelContainer.add(close, BorderLayout.EAST);
        labelContainer.add( min, BorderLayout.CENTER);
        
        //sound button 
        JPanel buttonsContainer = new  JPanel(); 
        buttonsContainer.setLayout(new BorderLayout());
        buttonsContainer.setPreferredSize(new  Dimension( 150, 40));
        buttonsContainer.setOpaque(false);
        desginButtons(backgroundSoundButton);
        desginButtons(buttonsSoundButton);
        buttonsContainer.add(backgroundSoundButton,BorderLayout.WEST);
        buttonsContainer.add(buttonsSoundButton,BorderLayout.EAST);
        
        add( buttonsContainer, BorderLayout.WEST);
        add(labelContainer, BorderLayout.EAST);
        
        
        close.addMouseListener(
        
                new MouseListener() { 
            @Override
            public void mouseClicked(MouseEvent e) {
             GameFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            }
        );
        
         min.addMouseListener(
            new MouseListener() { 
            @Override
            public void mouseClicked(MouseEvent e) {
             GameFrame.setState(JFrame.ICONIFIED);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            }
        );
        
    }
    
    public  void desginButtons(JButton soundButton) { 
        soundButton.setPreferredSize(new Dimension(70, 30));       
        soundButton.setForeground(Color.white);
        soundButton.setBackground(new Color(38, 56, 74));
        soundButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        soundButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        soundButton.setFocusable(false);
    }
    
    public JButton backgroundSoundButton() {
        return this.backgroundSoundButton;
    }
    public JButton buttonssoundButton() {
        return this.buttonsSoundButton;
    }
}
