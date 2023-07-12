/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic_tac_toy;

/**
 *
 * @author User
 */
public class Player {
    
    private String userName; 
    private String role; 
    private int wins = 0;
    
    public Player(){} 
    
    public Player(String userName, String role) { 
        this.role = role; 
        this.userName = userName;
    }
    
    public String getUserName() { 
        return userName;
    } 
    
    public String getRole() { 
        return role;
    }
    
    public int getWin() { 
        return wins;
    }
    
    
    public void setUserName(String userName) { 
        this.userName = userName;
    }
    
    
    public void setRole(String role) { 
        this.role = role;
    }
    
    public void setWins () { 
        this.wins++;
    }
    
    public void reSetWins() { 
        this.wins = 0;
    }
}
