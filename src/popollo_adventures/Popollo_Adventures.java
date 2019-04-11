/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popollo_adventures;



import classes.Enemigos;
import classes.Habilidades;
import classes.Heroes;
import classes.Objetos;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Mystra77
 */
public class Popollo_Adventures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Inicio.
        Scanner sc = new Scanner (System.in);    

        //Declaracion de variables
        //Habilidades
        Habilidades golpeFuerte = new Habilidades("Golpe Fuerte","Empleas todas tus fuerzas.",30,5,5);
        Habilidades remolino = new Habilidades("Gira y gira.","Da un poco de mareo.",50,3,3);
        
        ArrayList<Habilidades> habilidadesOfensivas= new ArrayList();
        habilidadesOfensivas.add(golpeFuerte);
        habilidadesOfensivas.add(remolino);
        
        Habilidades helada = new Habilidades("Helada","Frio invernal.",20,5,5);
        Habilidades bolaDeFuego = new Habilidades("Bola de Fuego","Envuelve al enemigo en llamas.",40,3,3);
        
        ArrayList<Habilidades> hechizosOfensivos= new ArrayList();
        hechizosOfensivos.add(helada);
        hechizosOfensivos.add(bolaDeFuego);
             
        Habilidades curacionL = new Habilidades("Curar Heridadas Leves","Sana las heridas superficiales.",10,3,3);
        Habilidades curacionG = new Habilidades("Curar Heridas Graves","Sana cualquier tipo de heridas.", 40, 1,1);
            
        ArrayList<Habilidades> hechizosCurativos = new ArrayList();
        hechizosCurativos.add(curacionL);
        hechizosCurativos.add(curacionG);
        
        //Ataques Enemigos
        Habilidades Cabezazo = new Habilidades("Cabezazo", "Fuerte embestida con la cabeza.", 15, 5, 5);
        Habilidades Morder = new Habilidades("Morder", "Bocado fuerte.", 30, 2, 2);
        
        ArrayList<Habilidades> golpesSalvajesE = new ArrayList();
        golpesSalvajesE.add(Cabezazo);
        golpesSalvajesE.add(Morder);
        
        Habilidades Llamarada = new Habilidades("Llamarada", "Envuelve al objetivo en llamas", 15, 5, 5);
        Habilidades Acido = new Habilidades("Acido", "Puede derretir armaduras.", 30, 2, 2);
        
        ArrayList<Habilidades> golpesMagicosE = new ArrayList();
        golpesMagicosE.add(Cabezazo);
        golpesMagicosE.add(Morder);
         
        //Objetos
        Objetos bombaP = new Objetos("Bomba Pequeña",15,3,"Pequeño artefacto explosivo, inflige 15 puntos de daño.");
        Objetos bombaG = new Objetos("Bomba Grande",50,1,"Gran artefacto explosivo, inflige 50 puntos de daño.");
        Objetos pocion = new Objetos("Pocion",20,5,"Bebida que restaura 20 puntos de salud.");
            
        ArrayList<Objetos> objetosArray = new ArrayList();
        objetosArray.add(bombaP);
        objetosArray.add(bombaG);
        objetosArray.add(pocion);
         
        Heroes popollo = new Heroes("Popollo", "Un adorable Popollito comilon", 120, 120, 30, 10, 20, 30, habilidadesOfensivas, objetosArray);
        Heroes narcyl = new Heroes("Narcyl", "Sacerdotisa al cargo de Popollo", 70, 70, 15, 30, 15, 20, hechizosCurativos, objetosArray);
        Heroes mystra = new Heroes("Mystra", "Un adorable Popollito comilon", 90, 90, 10, 50, 30, 20, hechizosOfensivos, objetosArray);
        
        ArrayList<Heroes> heroesArray = new ArrayList();
        heroesArray.add(popollo);
        heroesArray.add(narcyl);
        heroesArray.add(mystra);
        
        //Enemigos
        Enemigos poring = new Enemigos("Poring", "Una gelatina rosa monisima", 60, 60, 10, 0, 20, 10, golpesSalvajesE, 100);
        Enemigos golem = new Enemigos("Golem", "Una mole andante", 150, 150, 20, 0, 10, 50, golpesSalvajesE, 500);
        Enemigos nigromante = new Enemigos ("Nigromante", "No tiene buen aspecto", 100, 100, 10, 30, 20, 10, golpesMagicosE, 1000);
        
        ArrayList<Enemigos> combateFacil = new ArrayList();
        combateFacil.add(poring);
        combateFacil.add(poring);
        
        ArrayList<Enemigos> combateDificil = new ArrayList();
        combateDificil.add(poring);
        combateDificil.add(golem);
        combateDificil.add(nigromante);
        
        System.out.println(heroesArray.get(1).getNombre());
        int opcion=0;

        String menuInicio="\nPor favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Comenzar partida."
            +"\n\t2 - Ver galeria."
            +"\n\t3 - Combate de prueba.";     
        
        do{
            System.out.println(menuInicio); 
            opcion=Integer.parseInt(sc.nextLine());  
            
            switch(opcion){
                case 0:
                    System.out.println("Vuelve pronto ^_^");
                    break;
                case 1:               
                    break;
                case 2:
                    break;
                case 3:
                    String rutaCancionBatalla = "Combates.wav";
                    Musica cancionBatalla = new Musica();
                    cancionBatalla.iniciarMusica(rutaCancionBatalla);
                    Batalla(popollo, nigromante);
                    break;
                case 4:
                    break;                       
                default:
                    System.out.println("Por favor selecciona una opcion correcta.");
            }
        }while(opcion!=0);
    }
    
    public static void Batalla(Heroes heroes, Enemigos enemigos){
        
        Scanner sc=new Scanner(System.in);
        int dañar;
        int aleatorio;
        boolean heroesVivos=true;
        boolean enemigosVivos=true;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;
        /*
        String rutaCancionPopollo = "popollo.wav";
        Musica cancionPopollo = new Musica();
        String rutaCancionNigro = "Combates.wav";
        Musica cancionNigro = new Musica();
        */

        do{
            //TURNO ALIADO
            if(heroes.getSalud()>0){
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+heroes.getNombre());
                System.out.println("Ataque(1),Defensa(2),Habilidades(3),Objetos(4)");
                int opciones=sc.nextInt();
                System.out.println("---------------------------------------------- ºn");

                switch(opciones){
                    case 1:
                       //cancionPopollo.iniciarMusica(rutaCancionPopollo);
                       aleatorio = NumeroAleatorio(0, 2);
                       if(heroes.getAgilidad()>enemigos.getAgilidad()){
                            System.out.println("!!GOLPE CRITICO!!");
                            dañar = heroes.getFuerza()*2;
                            enemigos.daño(enemigos,dañar);
                            System.out.println(heroes.getNombre()+" inflige "+heroes.getFuerza()*2+" puntos de daño.");
                            System.out.println(+enemigos.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                            System.out.println(enemigos.getNombre()+" tiene "+enemigos.getSalud()+" puntos de vida restantes.\n");     
                        }else if(heroes.getAgilidad()==enemigos.getAgilidad()){
                            dañar = heroes.getFuerza();
                            enemigos.daño(enemigos,dañar);
                            System.out.println(heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                            System.out.println(+enemigos.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                            System.out.println(enemigos.getNombre()+" tiene "+enemigos.getSalud()+" puntos de vida restantes.\n");
                        }else{
                            if(aleatorio==0){
                                System.out.println("Ataque fallado");
                            }else{
                                dañar = heroes.getFuerza();
                                enemigos.daño(enemigos,dañar);
                                System.out.println(heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                                System.out.println(+enemigos.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                                System.out.println(enemigos.getNombre()+" tiene "+enemigos.getSalud()+" puntos de vida restantes.\n");
                            }  
                        }
                        break;

                    case 2:
                        System.out.println(heroes.getNombre()+" aumenta su defensa contra el siguiente ataque.\n");
                        break;

                    case 3:
                        break;

                    case 4:
                        break;
                }
            }else{
                heroesVivos=false;
                System.out.println("Derrota");
            } 
            //TURNO ENEMIGO
            if(enemigos.getSalud()>0){
            aleatorio = NumeroAleatorio(0, 6);
            //cancionNigro.iniciarMusica(rutaCancionNigro);
                if(aleatorio<=3){
                    aleatorio = NumeroAleatorio(0, 2);
                    if(enemigos.getAgilidad()>heroes.getAgilidad()){
                        System.out.println("!!GOLPE CRITICO!!");
                        dañar = enemigos.getFuerza()*2;
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()*2+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes.");     
                    }else if(enemigos.getAgilidad()==heroes.getAgilidad()){
                        dañar = enemigos.getFuerza();
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes."); 
                    }else{
                        if(aleatorio==0){
                            System.out.println("Ataque fallado");
                        }else{
                            dañar = enemigos.getFuerza();
                            heroes.daño(heroes,dañar);
                            System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                                    System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                                    System.out.println(heroes.getNombre()+" tiene "+heroes.getSalud()+" puntos de vida restantes.");
                                }  
                            }    
                }else if(aleatorio==4){            
                    System.out.println("Uso Bloqueo");   
                }else{
                    System.out.println("Uso Habilidad");
                }    
            }else{
                enemigosVivos=false;
                System.out.println("!!!Enemigos Derrotados!!!");
                String rutaCancionVictoria = "Victoria.wav";
                Musica cancionVictoria = new Musica();    
                cancionVictoria.iniciarMusica(rutaCancionVictoria);
            }
        }while(heroesVivos&&enemigosVivos);
    }
    
    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}


