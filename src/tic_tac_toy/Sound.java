/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic_tac_toy;

/**
 *
 * @author User
 */

import java.io.File;
import javax.sound.sampled.*; 

public class Sound  {
    
    private File file1;
    private File file2;
    private boolean status = true;
    
    private Clip  clip;
    public Sound(String  filePath) { 
            file1  = new File(filePath);
    }
    
    public Sound(String filePath, String filePath2) {
        file1 = new File(filePath);
        file2 = new File(filePath2);
    }
    
   public void  close() { 
       status = false;
       if(!(clip == null) ) clip.close();
   }
   
   
   
   
   public  void start() { 
       if(clip== null || !clip.isActive()) { 
        try { 
            status = true;
            AudioInputStream audio = AudioSystem.getAudioInputStream(file1);
            clip  = AudioSystem.getClip();
            clip.open(audio);
        }catch(Exception e){} 
        
       }
       clip.loop(clip.LOOP_CONTINUOUSLY);
       clip.start();
   }
   
   
   public  void playButtonSound(boolean controller) { 
      if(controller) status = true;
      if(status) {
            try { 
                AudioInputStream audio = AudioSystem.getAudioInputStream(file1);
                clip  = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }catch(Exception e){} 
       }
     }
     
    public  void playWinnerSound() { 

      if(status) {
            try { 
                AudioInputStream audio = AudioSystem.getAudioInputStream(file2);
                clip  = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }catch(Exception e){} 
       }
     }
   
   public boolean status() { 
       return status;
   }
}
