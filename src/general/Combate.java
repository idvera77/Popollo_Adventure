/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import clases.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Combate {

//Primer combate 
    public static void Batalla(Heroe heroe, Enemigo enemigo){
       
        //Sonidos Combate
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaCancionCombates = "./sonidos/Combates.wav";
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
            if(heroe.getSalud()>0){
                if(defensaHeroe==true){
                    heroe.BloqueoOff(heroe);
                    defensaHeroe=false;
                }
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+heroe.getNombre()+" - Vida restante: "+heroe.getSalud()+"/"+heroe.getSaludMaxima());
                System.out.println("\tAtaque(1) | Defensa(2) | Habilidades(3) | Objetos(4)");
                int opcion=Integer.parseInt(sc.nextLine());

                switch(opcion){
                    case 1:
                        heroe.atacar(heroe, enemigo);
                        Musica.iniciarSonidos(rutaSonidoFisicoAliado);
                        break;

                    case 2:    
                        System.out.println("- La defensa natural se multiplica por 2 durante un turno.\n");
                        heroe.Bloqueo(heroe);
                        defensaHeroe=true;
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                        break;

                    case 3:
                        heroe.MostrarHabilidades(heroe);
                        heroe.usarHabilidades(heroe, enemigo);
                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                        break;
                    case 4:
                        heroe.MostrarObjetos(heroe);
                        heroe.usarObjetos(heroe, enemigo);
                        Musica.iniciarSonidos(rutaSonidoCuraciones);
                        break;
                    default:
                        System.out.println("- Se que estas nervioso pero debes centrarte!");
                        Batalla(heroe, enemigo);
                        break;
                }
            }else{
                System.out.println("\n\tDERROTA - Juega mejor la proxima vez ^_^\n");
                System.exit(0); 
            }
            //TURNO ENEMIGO
            if(enemigo.getSalud()>0){
                if(defensaEnemigo==true){
                    enemigo.BloqueoOff(enemigo);
                    defensaEnemigo=false;
                }
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+enemigo.getNombre()+" - Vida restante: "+enemigo.getSalud()+"/"+enemigo.getSaludMaxima());
                aleatorio = NumeroAleatorio(0, 6);                
                    if(aleatorio<=3){ 
                        System.out.println("\tDecide atacar!\n");
                        enemigo.atacar(enemigo, heroe);
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);       
                    }else if(aleatorio==4){
                        System.out.println("\tDecide usar bloqueo!\n");
                        System.out.println("- Su defensa natural se multiplica por 2 durante un turno.");
                        enemigo.Bloqueo(enemigo);
                        defensaEnemigo=true;
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                    }else{
                        System.out.println("\tDecide usar una habilidad!\n");
                        enemigo.usarHabilidadesEnemigos(enemigo, heroe);
                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                    }
                }else{
                    Victoria=true;
                    System.out.println("\n\t!!!"+enemigo.getNombre()+" Derrotado!!!"
                            +" Has ganado "+enemigo.getDropDinero()+" Monedas de oro.\n");
                    heroe.dinero += enemigo.getDropDinero();
                    Musica.iniciarMusica(rutaCancionVictoria);    
                }
        }while(!Victoria);
        enemigo.regenerarSaludHabilidades(enemigo);
    }

    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
    } 
}

