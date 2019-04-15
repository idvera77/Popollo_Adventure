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
    private TipoConducta moral;

    public Npcs(TipoConducta moral, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.moral = moral;
    }
     
    private enum TipoConducta{
        LEGAL,
        BUENO,
        NEUTRAL,
        MALO,
        CAOTICO
    }   
}
