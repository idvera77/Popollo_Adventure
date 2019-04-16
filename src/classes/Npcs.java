/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
    
    public static void Beneficios_Perjuicios(Npcs npcs, Heroes heroe){
        int reputacion = heroe.getReputacion();
        String tipo = String.valueOf(npcs.getMoral());
            if(tipo.equals("LEGAL")){
                    if(reputacion>=100){
                         
                    }else if(reputacion>=50){
                         
                    }else if(reputacion>=20){
                         
                    }else{
                         
                    }
            }else if(tipo.equals("NEUTRAL")){
                 if(reputacion==0){
                         
                    }else if(reputacion<=50){
                         
                    }else if(reputacion>=-50){
                         
                    }else{
                         
                    }
            }else if(tipo.equals("CAOTICO")){
                if(reputacion>=100){
                         
                     }else if(reputacion>=50){
                         
                     }else if(reputacion>=20){
                         
                     }else{
                         
                     }
            }     
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
