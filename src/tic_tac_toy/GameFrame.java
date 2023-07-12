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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{
    private HeaderClass header = new  HeaderClass(this);
    private JPanel  container   = new JPanel();// content  of the game  and  the  users  
    private JPanel  gameContent  = new JPanel();// content  of the game  and  the  users  
    private GameInfo gameInfo; 
    private Game game;
    
                     
    private Sound backgorundSound = new  Sound("LobbyTime.wav");
    private Sound Buttonsound = new  Sound("formsButtons.wav");
    private Sound GameButtonssound = new  Sound("GameButton.wav", "Win.wav");
    
    public JButton backgroundSoundButton;
    private JButton buttonsSoundButton;
    private Footer footer = new  Footer(this );
    public GameFrame(Player player1, Player player2) { 
        this.setSize(800,  500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());

        //Add Header 
        add(header, BorderLayout.NORTH);
        
        //container 
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(800, 420));
        container.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        container.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
        container.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        container.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        container.add(gameContent, BorderLayout.CENTER);
        container.setBackground(new Color(53, 76, 100));
        add(container);
        
        //Set the game content 
        gameContent.setPreferredSize(new Dimension(760, 400));
        gameContent.setLayout(new BorderLayout()); 
        gameContent.setOpaque(false);
        
        
         game = new Game(player1 , player2);
        
        
        //Add GameInfo 
        gameInfo = new GameInfo(game);
        gameInfo.setButtonSound(Buttonsound);
        gameContent.add(gameInfo, BorderLayout.EAST);
       
        
        //Add Game  
        game.setGameInfo(gameInfo);
        game.setGameButtonSound(GameButtonssound);
        gameContent.add(game,BorderLayout.WEST);
        
        
         
        //Adding the footer 
        footer.setButtonSound(Buttonsound);
        footer.setbackgorundSound(backgorundSound);
        this.add(footer, BorderLayout.SOUTH);
        
        
        
        
        buttonsSoundButton  = header.buttonssoundButton();
        buttonsSoundButton.addActionListener(
            new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(Buttonsound.status()) { 
                        Buttonsound.close();
                         GameButtonssound.close();
                        buttonsSoundButton.setText("unmute");
                    }
                    else { 
                        Buttonsound.playButtonSound(true);
                        GameButtonssound .playButtonSound(true);
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
