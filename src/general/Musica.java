package general;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author Ivan Diaz Vera
 */
public class Musica {
    public static void sonidosBoton(String rutaSonido){
        try{
            File rutaMusica = new File(rutaSonido);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInputSonido = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputSonido);
                clip.start();
            }
            else
            {
                System.out.println("No pudo encontrarse el archivo");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
