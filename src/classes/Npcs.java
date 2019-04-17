/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Npcs extends ElementoIdentificador{
    private tipoMoral moral;

    public Npcs(String nombre, String descripcion, tipoMoral moral) {
        super(nombre, descripcion);
        this.moral = moral;
    }
     
    public enum tipoMoral{
        LEGAL,
        NEUTRAL,
        CAOTICO
    }   

    public tipoMoral getMoral() {
        return moral;
    }

    public void setMoral(tipoMoral moral) {
        this.moral = moral;
    }  
    
    public static void afinidadNpcs(Npcs npcs, Heroes heroe){
        Scanner sc = new Scanner (System.in);
        int reputacion = heroe.getReputacion();
        System.out.println(reputacion);
        String tipo = String.valueOf(npcs.getMoral());
            if(tipo.equals("LEGAL")){
                System.out.println("|"+npcs.getNombre()+" quiere hablar contigo.|");
                    if(reputacion>=100){
                        System.out.println("- Eres un dios entre los mortales. No merezco seguir a tu lado pero te apoyare en todo lo que pueda.");
                        heroe.saludMaxima += 200;
                        heroe.salud += 200;
                        heroe.setDefensa(heroe.getDefensa()+10);
                        System.out.println("- "+heroe.getNombre()+" ha recibido la bendicion de "+npcs.getNombre()+". (Aumento de varios atributos recibido)");
                    }else if(reputacion<100&&reputacion>=50){
                        System.out.println("- Estoy orgullosa de haberte conocido, te seguire apoyando.");
                        heroe.dinero += 1000;
                        System.out.println("- "+heroe.getNombre()+" ha recibido 1000 monedas de oro.");
                    }else if(reputacion<50&&reputacion>=20){
                        System.out.println("- Estas realizando buenas acciones, seras un buen heroe.");                      
                        heroe.dinero += 500;
                        System.out.println("- "+heroe.getNombre()+" ha recibido 500 monedas de oro.");
                    }else if(reputacion<20&&reputacion>=0){
                        System.out.println("- Deberias esforzarte mas por ayudar a los demas.");
                    }else{
                        System.out.println("- Me empiezas a dar miedo.");
                    }
            }else if(tipo.equals("NEUTRAL")){
                System.out.println("|"+npcs.getNombre()+" quiere hablar contigo.|");
                if(reputacion>=-20&&reputacion<=20){
                    System.out.println("- Veo que todo te importa muy poco, me recuerdas a mi.");
                    heroe.setFuerza(heroe.getFuerza()+5);
                    heroe.setAgilidad(heroe.getAgilidad()+5);
                    System.out.println("- "+heroe.getNombre()+" ha recibido la bendicion de "+npcs.getNombre()+". (Aumento de varios atributos recibido)");
                }else if(reputacion>20&&reputacion<=50){
                    System.out.println("- Espero que no cambies, no me gusta la gente emocional.");
                    heroe.dinero += 200;    
                    System.out.println("- "+heroe.getNombre()+" ha recibido 200 monedas de oro.");
                }else if(reputacion<-20&&reputacion>=-50){
                    System.out.println("- Espero que no cambies, no me gusta la gente emocional.");                      
                    heroe.dinero += 200;    
                    System.out.println("- "+heroe.getNombre()+" ha recibido 200 monedas de oro.");
                }else{
                    System.out.println("- Eres otro cabeza hueca, no te dejes llevar por los sentimientos.");
                }
            }else if(tipo.equals("CAOTICO")){
                System.out.println("|"+npcs.getNombre()+" quiere hablar contigo.|");
                    if(reputacion<=-100){
                        System.out.println("- Eres la viva imagen de la muerte. Te seguire hasta el fin del mundo.");
                        heroe.setFuerza(heroe.getFuerza()+10);
                        heroe.setMagia(heroe.getMagia()+5);
                        System.out.println("- "+heroe.getNombre()+" ha recibido la bendicion de "+npcs.getNombre()+". (Aumento de varios atributos recibido)");
                    }else if(reputacion>-100&&reputacion<=-50){
                        System.out.println("- Vas por buen camino, pronto quemaremos ciudades enteras.");
                        heroe.dinero += 500;
                        System.out.println("- "+heroe.getNombre()+" ha recibido 500 monedas de oro.");
                    }else if(reputacion>-50&&reputacion<=-20){
                        System.out.println("- La proxima vez deja que sufran algo mas.");                      
                        heroe.dinero += 200;
                        System.out.println("- "+heroe.getNombre()+" ha recibido 200 monedas de oro.");
                    }else if(reputacion>-20&&reputacion==0){
                        System.out.println("- Deberias esforzarte mas por ayudar a los demas.");
                    }else{
                        System.out.println("- No me gusta tu actitud benevolente.");
                    }
            }    
        System.out.println("*** Pulse cualquier tecla para salir ***");
        sc.nextLine();    
    }
    
    public void Final (Npcs npcs, Heroes heroe){
        int reputacion = heroe.getReputacion();
        String tipo = String.valueOf(npcs.getMoral());
            if(tipo.equals("LEGAL")){
                     
            }else if(tipo.equals("NEUTRAL")){
                 
            }else if(tipo.equals("CAOTICO")){
                
            }    
    }
}
