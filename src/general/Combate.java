/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import classes.Enemigos;
import classes.Heroes;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Combate {
    

    public static void batalla(Heroes arrayHeroes, Enemigos arrayEnemigos) {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random(System.nanoTime());
        int aleatorio, vida;
        
        /*
        boolean Good=true;
        boolean Evil=true;
        
        do{
            if(arrayHeroes.get(1).getSalud()>0){
                System.out.println("Ataque(1),Defensa(2),Hechizos(3),Pocion(4)\n");
                int opciones=sc.nextInt();
                
                switch(opciones){
                    case 1:
                        vida = heroes.ataque_fisico();
                        monstruos.daño(vida);
                        System.out.println(heroes.getNombre()+" ha realizado un ataque de: "+heroes.ataque_fisico());
                        System.out.println("La salud restante de monstruos es de: "+monstruos.getSalud()+"\n");
                        break;
                    case 2:
                        heroes.bloqueo();
                        System.out.println("La Defensa de heroes es de : "+heroes.bloqueo());
                        break;
                    case 3:
                        break;
                    case 4:
                        vida = heroes.pocion();
                        heroes.recuperar(vida);
                        System.out.println(heroes.getNombre()+" ha utilizado una pocion y se ha curado: "+heroes.pocion());
                        System.out.println("La salud restante de heroes es de: "+heroes.getSalud()+"\n");
                        break;
                }
            }else{
                Good=false;
            }
            
            if(monstruos.getSalud()>0){
                aleatorio=rand.nextInt(3);
                if(aleatorio==0){
                    vida = monstruos.ataque_fisico();
                    heroes.daño(vida);
                    System.out.println(monstruos.getNombre()+" ha relizado un ataque de: "+monstruos.ataque_fisico());
                    System.out.println("La salud restante de heroes es de: "+heroes.getSalud()+"\n");
                }else if(aleatorio==1){    
                    heroes.bloqueo();
                    System.out.println("La Defensa de monstruos es de : "+monstruos.bloqueo());   
                }else if(aleatorio==2){
                    vida = monstruos.pocion();
                    monstruos.recuperar(vida);
                    System.out.println(monstruos.getNombre()+" ha utilizado una pocion y se ha curado: "+monstruos.pocion());
                    System.out.println("La salud restante de monstruos es de: "+monstruos.getSalud()+"\n");
                }   
            }else{
                Evil=false;
            }
        }while(Good && Evil);     
    }   
        */
       
    }
}