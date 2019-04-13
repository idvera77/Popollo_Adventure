/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import classes.Enemigos;
import classes.Heroes;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Combate {


   public static void Batalla(Heroes heroes, Enemigos enemigos){
       
        //Sonidos Combate
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaCancionCombates = "./sonidos/Combates.wav";
        String rutaSonidoFisicoAliado = "./sonidos/FisicoAliado.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";
        String rutaSonidoCuraciones = "./sonidos/Curaciones.wav";
        
        Scanner sc=new Scanner(System.in);
        int dañar;
        int aleatorio;
        boolean heroesVivos=true;
        boolean enemigosVivos=true;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;
        

        do{
            //TURNO ALIADO
            if(heroes.getSalud()>0){
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+heroes.getNombre()+" - Vida restante: "+heroes.getSalud()+"/"+heroes.getSaludMaxima());
                System.out.println("\tAtaque(1),Defensa(2),Habilidades(3),Objetos(4)");
                int opciones=sc.nextInt();
                System.out.println("----------------------------------------------");

                switch(opciones){
                    case 1:
                       aleatorio = NumeroAleatorio(0, 2);
                       if(heroes.getAgilidad()>enemigos.getAgilidad()){
                            System.out.println("!!GOLPE CRITICO!!");
                            dañar = heroes.getFuerza()*2;
                            enemigos.daño(enemigos,dañar);
                            System.out.println("- "+heroes.getNombre()+" inflige "+heroes.getFuerza()*2+" puntos de daño.");
                            System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño."
                                    +"\n");
                        }else if(heroes.getAgilidad()==enemigos.getAgilidad()){
                            dañar = heroes.getFuerza();
                            enemigos.daño(enemigos,dañar);
                            System.out.println("- "+heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                            System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño."
                                +"\n");
                        }else{
                            if(aleatorio==0){
                                System.out.println("Ataque fallado");
                            }else{
                                dañar = heroes.getFuerza();
                                enemigos.daño(enemigos,dañar);
                                System.out.println(heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                                System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño."
                                    +"\n");
                            }
                        }
                        Musica.iniciarSonidos(rutaSonidoFisicoAliado);
                        break;

                    case 2:
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                        System.out.println(heroes.getNombre()+" duplica su defensa durante un turno..\n");
                        break;

                    case 3:
                        
                        String listaHabilidades="";
                        

                        for (int i = 0; i < heroes.getHabilidadesArray().size(); i++) {
                            listaHabilidades +="\t("+(i+1)+")"+heroes.getHabilidadesArray().get(i).getNombre()+" - Usos restantes:*"+heroes.getHabilidadesArray().get(i).getUsosRestantes()+"*";
                        }     
                        System.out.println(listaHabilidades);
                        opciones=sc.nextInt();
                            switch(opciones){
                                case 1:
                                    System.out.println(heroes.getNombre()+" usa "+heroes.getHabilidadesArray().get(0).getNombre());
                                    Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    break;
                                case 2:
                                    if(heroes.getHabilidadesArray().get(1).getUsosRestantes()!=0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getHabilidadesArray().get(1).getNombre());
                                        heroes.getHabilidadesArray().get(1).setUsosRestantes(heroes.getHabilidadesArray().get(1).getUsosRestantes()-1);
                                        enemigos.dañoHabilidades(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    }else{
                                        System.out.println("No puedes utilizar la habilidad. Pierdes el turno.\n");
                                    }
                                    break;
                            }
                        break;

                    case 4:
                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                        break;
                }

            }else{
                System.out.println("Derrota");
                heroesVivos=false;
            }
            //TURNO ENEMIGO
            if(enemigos.getSalud()>0){
            System.out.println("Turno de "+enemigos.getNombre()+" - Vida restante: "+enemigos.getSalud()+"/"+enemigos.getSaludMaxima());
            aleatorio = NumeroAleatorio(0, 6);
                if(aleatorio<=3){          
                    aleatorio = NumeroAleatorio(0, 2);
                    if(enemigos.getAgilidad()>heroes.getAgilidad()){
                        System.out.println("!!GOLPE CRITICO!!");
                        dañar = enemigos.getFuerza()*2;
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()*2+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes.");
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                    }else if(enemigos.getAgilidad()==heroes.getAgilidad()){
                        dañar = enemigos.getFuerza();
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes.");
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                    }else{
                        if(aleatorio==0){
                            System.out.println("Ataque fallado");
                        }else{
                            dañar = enemigos.getFuerza();
                            heroes.daño(heroes,dañar);
                            System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                            System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                            System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes.");
                            Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                                }
                            }
                }else if(aleatorio==4){
                    System.out.println("Uso Bloqueo");
                    Musica.iniciarSonidos(rutaSonidoDefensa);
                }else{
                    System.out.println("Uso Habilidad");
                    Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                }
            }else{
                enemigosVivos=false;
                System.out.println("!!!Enemigos Derrotados!!!");
                Musica.iniciarMusica(rutaCancionVictoria);
            }
        }while(heroesVivos&&enemigosVivos);
    }

    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}

