package clases;

import exceptions.InvalidMoralException;
import java.util.Scanner;

/**
 *
 * @author Ivan Diaz Vera
 */
public final class Npc extends ElementoIdentificador{
    private tipoMoral moral;
    
    /**
     * Constructor de Npc
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param moral Variable tipo que nos permite indicar la moral del npc y asi modificar ciertas funciones.
     */
    public Npc(String nombre, String descripcion, String moral) throws InvalidMoralException {
        super(nombre, descripcion);
        setMoral(moral);
    }
     
    public enum tipoMoral{
        LEGAL,
        NEUTRAL,
        CAOTICO
    }   

    public tipoMoral getMoral() {
        return moral;
    }

    public void setMoral(String moral) throws InvalidMoralException{
        switch(moral.toLowerCase()){
           case "legal":
               this.moral=tipoMoral.LEGAL;
               break;
           case "neutral":
               this.moral=tipoMoral.NEUTRAL;
               break;
           case "caotico":
               this.moral=tipoMoral.CAOTICO;
               break;    
           default:
               throw new InvalidMoralException(moral+" no es valida. Solo puede ser 'legal', 'neutral' o 'caotico'.");
        }  
    }
    
    /**
     * Funcion que compara la reputacion del heroe y la moral del npc para a�adir dialogos o dar recompensas al heroe.
     * @param npcs Del cual conseguiremos beneficios o dialogos dependiendo de su moral.
     * @param heroe Del cual sacaremos una reputacion y obtendra beneficios.
     */
    public static void afinidadNpcs(Npc npcs, Heroe heroe){
        Scanner sc = new Scanner (System.in);
        int reputacion = heroe.getReputacion();
        String tipo = String.valueOf(npcs.getMoral());
            if(tipo.equals("LEGAL")){
                System.out.println("|"+npcs.getNombre()+" quiere hablar contigo.|");
                    if(reputacion>=100){
                        System.out.println("- Eres un dios entre los mortales. No merezco seguir a tu lado pero te apoyare en todo lo que pueda.");
                        heroe.setSaludMaxima(heroe.getSaludMaxima()+200);
                        heroe.setSalud(heroe.getSalud()+200);
                        heroe.setDefensa(heroe.getDefensa()+10);
                        System.out.println("- "+heroe.getNombre()+" ha recibido la bendicion de "+npcs.getNombre()+". (Aumento de varios atributos recibido)");
                    }else if(reputacion<100&&reputacion>=50){
                        System.out.println("- Estoy orgullosa de haberte conocido, te seguire apoyando.");
                        heroe.setDinero(heroe.getDinero()+1000);
                        System.out.println("- "+heroe.getNombre()+" ha recibido 1000 monedas de oro.");
                    }else if(reputacion<50&&reputacion>=20){
                        System.out.println("- Estas realizando buenas acciones, seras un buen heroe.");                      
                        heroe.setDinero(heroe.getDinero()+500);
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
                    heroe.setDinero(heroe.getDinero()+200);    
                    System.out.println("- "+heroe.getNombre()+" ha recibido 200 monedas de oro.");
                }else if(reputacion<-20&&reputacion>=-50){
                    System.out.println("- Espero que no cambies, no me gusta la gente emocional.");                      
                    heroe.setDinero(heroe.getDinero()+200);   
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
                        heroe.setDinero(heroe.getDinero()+500);  
                        System.out.println("- "+heroe.getNombre()+" ha recibido 500 monedas de oro.");
                    }else if(reputacion>-50&&reputacion<=-20){
                        System.out.println("- La proxima vez deja que sufran algo mas.");                      
                        heroe.setDinero(heroe.getDinero()+200);  
                        System.out.println("- "+heroe.getNombre()+" ha recibido 200 monedas de oro.");
                    }else if(reputacion>-20&&reputacion<=0){
                        System.out.println("- Acaso no sabes divertirte.");
                    }else{
                        System.out.println("- No me gusta tu actitud benevolente.");
                    }
            }    
        System.out.println("*** Pulse cualquier tecla para salir ***");
        sc.nextLine();    
    }
}
