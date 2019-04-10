
package popollo_adventures;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author Mystra77
 */
public class Musica {

    void iniciarMusica (String musicLocation){
        try{
            File rutaMusica = new File(musicLocation);
            
            if(rutaMusica.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);   
            }
            else
            {
                System.out.println("No puedo encontrar el archivo");
            }    
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    } 
    
    void stopMusic (){
       
    }
}
