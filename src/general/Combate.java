package general;

import clases.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Diaz Vera
 */
public class Combate {

//Primer combate
    public static void batalla(Heroe heroe, Enemigo enemigo){

        //Sonidos Combate
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaSonidoFisicoAliado = "./sonidos/FisicoAliado.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";
        String rutaSonidoCuraciones = "./sonidos/Curaciones.wav";

        Scanner sc=new Scanner(System.in);

        int aleatorio;
        boolean Victoria=false;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;


        do{
            //TURNO ALIADO
            //Comprobacion de que el heroe tiene mas de 0 puntos de salud.
            if(heroe.getSalud()>0){
            	if(defensaHeroe==true){
                    heroe.BloqueoOff(heroe);
                    defensaHeroe=false;
                }
                try {
                    //Comprobacion de que el heroe tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
                    System.out.println("----------------------------------------------");
                    System.out.println("Turno de "+heroe.getNombre()+" - Vida restante: "+heroe.getSalud()+"/"+heroe.getSaludMaxima());
                    System.out.println("\tAtaque(1) | Defensa(2) | Habilidades(3) | Objetos(4)");
                    int opcion=Integer.parseInt(sc.nextLine());

                    switch(opcion){
                        case 1:
                            heroe.atacar(heroe, enemigo);
                            Musica.iniciarSonidos(rutaSonidoFisicoAliado);
                            Thread.sleep(350);
                            break;

                        case 2:
                            System.out.println("- La defensa natural se multiplica por 2 durante un turno.\n");
                            heroe.Bloqueo(heroe);
                            defensaHeroe=true;
                            Musica.iniciarSonidos(rutaSonidoDefensa);
                            Thread.sleep(350);
                            break;

                        case 3:
                            heroe.mostrarHabilidades();
                            heroe.usarHabilidades(enemigo);
                            Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                            Thread.sleep(350);
                            break;
                        case 4:
                            heroe.mostrarObjetos();
                            heroe.usarObjetos(enemigo);
                            Musica.iniciarSonidos(rutaSonidoCuraciones);
                            Thread.sleep(350);
                            break;
                        default:
                            System.out.println("- Se que estas nervioso pero debes centrarte!");
                            batalla(heroe, enemigo);
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("\n\tDERROTA - Juega mejor la proxima vez ^_^\n");
                System.exit(0);
            }
            //TURNO ENEMIGO
            //Comprobacion de que el heroe tiene mas de 0 puntos de salud.
            if(enemigo.getSalud()>0){
                //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
                if(defensaEnemigo==true){
                        enemigo.BloqueoOff(enemigo);
                        defensaEnemigo=false;
                    }
                try {
                    System.out.println("----------------------------------------------");
                    System.out.println("Turno de "+enemigo.getNombre()+" - Vida restante: "+enemigo.getSalud()+"/"+enemigo.getSaludMaxima());
                    aleatorio = NumeroAleatorio(0, 6);
                    if(aleatorio<=3){
                        System.out.println("\tDecide atacar!\n");
                        enemigo.atacar(enemigo, heroe);
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                        Thread.sleep(150);
                    }else if(aleatorio==4){
                        System.out.println("\tDecide usar bloqueo!\n");
                        System.out.println("- Su defensa natural se multiplica por 2 durante un turno.");
                        enemigo.Bloqueo(enemigo);
                        defensaEnemigo=true;
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                        Thread.sleep(150);
                    }else{
                        System.out.println("\tDecide usar una habilidad!\n");
                        enemigo.usarHabilidadesEnemigos(heroe);
                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                        Thread.sleep(150);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    Victoria=true;
                    System.out.println("\n\t!!!"+enemigo.getNombre()+" Derrotado!!!"
                            +" Recibes "+enemigo.getDinero()+" Monedas de oro y "
                            + enemigo.getExperiencia()+" puntos de experiencia.");
                    heroe.subirNivel(enemigo.getExperiencia());
                    heroe.setDinero(heroe.getDinero()+enemigo.getDinero());
                    if(defensaEnemigo==true){
                        enemigo.BloqueoOff(enemigo);
                        defensaEnemigo=false;
                    }
                    Musica.iniciarMusica(rutaCancionVictoria);
                }
        }while(!Victoria);
        enemigo.restablecerEnemigo();
    }

    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
    }
}
