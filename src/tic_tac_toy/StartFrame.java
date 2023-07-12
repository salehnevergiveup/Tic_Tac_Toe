/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic_tac_toy;

/**
 *
 * @author User
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

public class StartFrame extends JFrame{
    private Player player1 = new  Player(); 
    private Player player2 = new Player();
    private  HeaderClass header = new HeaderClass(this);
    private StartPageContent content = new StartPageContent(); 
    private Sound backgorundSound = new  Sound("stratGame.wav");
    private Sound Buttonsound = new  Sound("formsButtons.wav");
    private JButton backgroundSoundButton;
    private JButton buttonsSoundButton;
    public StartFrame() { 
        
        this.setSize(500,  370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        
        //Add Header 
        add(header, BorderLayout.NORTH);
        
        //Add Content  
        add(content);
        
        //Buttons 
        JButton[] buttonsP1 = content.getButtonsP1(); 
        JButton[] buttonsP2 = content.getButtonsP2(); 
        JButton buttonClear = content.getButtonClear();
        JButton buttonPlay  = content.getPlayButton();
        JTextField fieldP1  = content.getPlayerOneName();
        JTextField fieldP2  = content.getPlayerTwoName();
        JFrame  ThisFrame   = this;
        
        //Functions 
        for(JButton b : buttonsP1) { 
            b.addActionListener(
              new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                    if(buttonsP2[0].getText().equalsIgnoreCase(b.getText())){ 
                        buttonsP2[0].setEnabled(false);
                        buttonsP2[1].setEnabled(true);
                    }
                    else { 
                        buttonsP2[0].setEnabled(true);
                        buttonsP2[1].setEnabled(false);
                    }
                    player1.setRole(b.getText());
                }
              }
            );
        }
        
        for(JButton b : buttonsP2) { 
            b.addActionListener(
              new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                    if (buttonsP1[0].getText().equalsIgnoreCase(b.getText())) {
                        buttonsP1[0].setEnabled(false);
                        buttonsP1[1].setEnabled(true);
                    } else {
                        buttonsP1[0].setEnabled(true);
                        buttonsP1[1].setEnabled(false);
                    }
                    player2.setRole(b.getText());
                }
              }
            );
        }
             
       buttonPlay.addActionListener(
            new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                    if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                    if(!fieldP1.getText().isEmpty() && !fieldP2.getText().isEmpty() && !player1.getRole().isEmpty() && !player2.getRole().isEmpty() ) {
                        player1.setUserName(fieldP1.getText());
                        player2.setUserName(fieldP2.getText());
                        new GameFrame(player1, player2).setVisible(true);
                        backgorundSound.close();
                        ThisFrame.dispose();
                    }
                    }catch(Exception ex) {}
                }
            }
        );      
        
       buttonClear.addActionListener(
            new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                        buttonsP1[0].setEnabled(true);
                        buttonsP1[1].setEnabled(true);
                        buttonsP2[0].setEnabled(true);
                        buttonsP2[1].setEnabled(true);
                        fieldP1.setText("");
                        fieldP2.setText("");
                        player1.setRole("");
                        player2.setRole("");
                        if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                        
                }
            }
        );  
       
       
        buttonsSoundButton  = header.buttonssoundButton();

        buttonsSoundButton.addActionListener(
            new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(Buttonsound.status()) { 
                        Buttonsound.close();
                        buttonsSoundButton.setText("unmute");
                    }
                    else { 
                        Buttonsound.playButtonSound(true);
                        buttonsSoundButton.setText("Effect"); }
                }

            }
        );  
       
       
       
       backgroundSoundButton  = header.backgroundSoundButton();
       backgorundSound.start();
       backgroundSoundButton.addActionListener(
            new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Buttonsound.status())  Buttonsound.playButtonSound(false);
                    if(backgorundSound.status()) { 
                        backgorundSound .close();
                        backgroundSoundButton.setText("unmute");
                    }
                    else { 
                        backgorundSound .start();
                        backgroundSoundButton.setText("mute"); }
                }

            }
        );  
       
       
    }
}
