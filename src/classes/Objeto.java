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
public class Objeto extends ElementoIdentificador{
    private int poder;
    private int cantidad;
    private tipoObjeto tipo;
    private int precio;

    public Objeto(String nombre, int poder, int cantidad, String descripcion, tipoObjeto tipo, int precio) {
        super(nombre, descripcion);
        this.poder = poder;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.precio = precio;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
   
}
