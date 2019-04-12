
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

    public static void iniciarMusica (String rutaSonido){
        try{
            File rutaMusica = new File(rutaSonido);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInputVictoria = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputVictoria);
                clip.start();
                Thread.sleep(6000);
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
    
    public static void iniciarSonidos (String rutaSonido){
        try{
            File rutaMusica = new File(rutaSonido);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInputSonido = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputSonido);
                clip.start();
                Thread.sleep(500);
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
