
package general;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author Mystra77
 */
public class Musica {
    String rutaCancionVictoria = "Victoria.wav";
    String rutaCancionBatalla = "Combates.wav";

    public static void iniciarMusica (){
        String rutaCancionVictoria = "Victoria.wav";

        try{
            File rutaMusica = new File(rutaCancionVictoria);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                Thread.sleep(20000);
                clip.close();
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
    
    public static void iniciarMusicaBatalla (){
        String rutaCancionVictoria = "Combates.wav";

        try{
            File rutaMusica = new File(rutaCancionVictoria);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                Thread.sleep(20000);
                clip.close();
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
}
