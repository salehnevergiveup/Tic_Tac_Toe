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
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.LineBorder;

public class Game extends JPanel{

    private JButton[] gameButtons = { 
        new JButton(""),
        new JButton(""),
        new JButton (""),
        new JButton(""),
        new JButton(""),
        new JButton(""),
        new JButton(""),
        new JButton(""),
        new JButton("")
    }; 
    
    private int round = 1;
    private String turn = "";
    private Player player1; 
    private Player player2;
    private GameInfo gameinfo;
    private Sound GameButtonSound;

    public Game(Player player1 , Player player2) { 
        this.setPreferredSize(new Dimension(450, 400));
        this.setLayout(new GridLayout(3, 3, 5, 5));
        this.setBorder(new LineBorder(new Color(87, 122, 158), 5));

         
        this.player1 = player1;
        this.player2 = player2;
        turn = player1.getRole(); 
        if(turn.equalsIgnoreCase("O")) { 
            this.setBackground(new Color(4, 217 ,255));
        }else { 
            this.setBackground(new Color(254, 0, 101));
        }
        
        
        for(JButton b : gameButtons) { 
            this.add(b);
            b.setBackground(new Color(38, 56, 74));
            b.setFont(new Font("Tahoma", Font.BOLD, 30));
            b.setFocusable(false);
             
            
            //ActionListener 
            b.addActionListener(
            new  ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
            if (GameButtonSound.status())  GameButtonSound.playButtonSound(false);
            if(setButtonText(b)) {
                changeColors(b);
                turnChanger();
                theWinner();
                reset(b);
            }
        }
        }
        );
        }
    }
    
    //gettres 
    public Player getPlayer1() { 
        return player1;
    }
    
    public Player getPlayer2() { 
        return player2;
    }
    
    //setter
    public void setGameInfo(GameInfo gameInfo) { 
        this.gameinfo = gameInfo;
    }
    
    
    public void setGameButtonSound(Sound GameButtonSound) {
        this.GameButtonSound = GameButtonSound;
    }

    
    
    //Functions
    public boolean setButtonText(JButton b) {
                if (b.getText().isEmpty()) {
                     b.setText(turn);
                    return true;
                }
                return false;
    }
    
    public  void  changeColors(JButton b){ 
        if(turn.equalsIgnoreCase("O")) { 
                b.setForeground(new Color(4, 217 ,255));
                this.setBackground(new Color(254, 0, 101));
            }else { 
                b.setForeground(new Color(254, 0, 101));
                this.setBackground(new Color(4, 217 ,255));
            }
    }
    
    public void turnChanger(){ 
        if(turn.equalsIgnoreCase(player1.getRole())) { 
            turn = player2.getRole();
        }else if(turn.equalsIgnoreCase(player2.getRole())) { 
            turn =  player1.getRole();
        }
    }
    
    private void winner(int i1 , int i2 , int i3 ) { 
         if(gameButtons[i1].getText() == gameButtons[i2].getText() && gameButtons[i2].getText() == gameButtons[i3].getText()
        &&(!gameButtons[i1].getText().isEmpty() && !gameButtons[i2].getText().isEmpty() && !gameButtons[i3].getText().isEmpty())) { 
            if (GameButtonSound.status())  GameButtonSound.playWinnerSound();
            if(gameButtons[i1].getText().equalsIgnoreCase(player1.getRole())) { 
                player1.setWins();
                round++;
                gameinfo.setLabelWins1(player1.getWin());
                gameinfo.setLabelRound(round);
                clearButtons();
            }else { 
                  player2.setWins();
                  round++;
                  gameinfo.setLabelWins2(player2.getWin());
                  gameinfo.setLabelRound(round);
                  clearButtons();
            }
        
        }
    }
         
    public void theWinner() { 
       winner(0 , 1, 2 );
       winner(3 , 4, 5 );
       winner(6 , 7, 8 );
       winner(0 , 3, 6 );
       winner(1 , 4, 7 );
       winner(2 , 5, 8 );
       winner(0 , 4, 8 );
       winner(2 , 4, 6 );
        
    }
    
    public void  reset(JButton button) { 
        boolean checker = true;
        for(JButton b : gameButtons){ 
            if(b.getText().isEmpty()) checker =false;
        }
        if(checker){
            round++;
            gameinfo.setLabelRound(round);
            clearButtons();
        }
    }
    
    public void clearButtons()  { 
         for (JButton b : gameButtons)
            b.setText("");
         turn = player1.getRole();
         if (turn.equalsIgnoreCase("O")) {
            this.setBackground(new Color(4, 217, 255));
        } else {
            this.setBackground(new Color(254, 0, 101));
        }
    }
    
    public void clear() { 
        turn = player1.getRole();
        round =1;
        gameinfo.setLabelRound(round);
        player1.reSetWins();
        player2.reSetWins();
        gameinfo.setLabelWins1(player1.getWin());
        gameinfo.setLabelWins2(player2.getWin());
        clearButtons();
    }
}
