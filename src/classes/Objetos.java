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
public class Objetos extends ElementoIdentificador{
    private int poder;
    private int cantidad;
    private tipoObjeto tipo;

    public Objetos(String nombre, int poder, int cantidad, String descripcion, tipoObjeto tipo) {
        super(nombre, descripcion);
        this.poder = poder;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
    
    public enum tipoObjeto{
        ATAQUE,
        CURACION
    };
    
    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }  

    public tipoObjeto getTipo() {
        return tipo;
    }

    public void setTipo(tipoObjeto tipo) {
        this.tipo = tipo;
    }
    
   
}
