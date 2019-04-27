
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
    
    /**
     * Funcion que nos permite crear AudioInput y gracias a una ruta añadimos sonidos.
     * @param rutaSonido Indicamos la ruta donde esta guardado el sonido que queremos escuchar.
     */
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
                System.out.println("No pudo encontrarse el archivo");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
    * Funcion que nos permite crear AudioInput y gracias a una ruta añadimos sonidos.
    * @param rutaSonido Indicamos la ruta donde esta guardado el sonido que queremos escuchar.
    */
    public static void iniciarSonidos (String rutaSonido){
        try{
            File rutaMusica = new File(rutaSonido);

            if(rutaMusica.exists())
            {
                AudioInputStream audioInputSonido = AudioSystem.getAudioInputStream(rutaMusica);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputSonido);
                clip.start();
                Thread.sleep(400);
                clip.close();
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
