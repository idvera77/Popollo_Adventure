/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Mystra77
 */
public class Objeto extends ElementoIdentificador{
    private int poder;
    private int cantidad;
    private tipoObjeto tipo;
    private int precio;
    
    /**
     * Constructor de Npc
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param poder Variable de tipo entero que indica el poder del objeto actual.
     * @param cantidad Variable de tipo entero que indica la cantidad disponible del objeo.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param tipo Variable tipo que nos permite indicar el tipo de objeto y asi modificar ciertas funciones.
     * @param precio Variable de tipo entero que indica el precio de un objeto.
     */
    public Objeto(String nombre, int poder, int cantidad, String descripcion, String tipo, int precio) {
        super(nombre, descripcion);
        this.poder = poder;
        this.cantidad = cantidad;
        setTipo(tipo);
        this.precio = precio;
    }
    
    public enum tipoObjeto{
        ATAQUE,
        CURACION
    };
    
    public tipoObjeto getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
           switch(tipo.toLowerCase()){
           case "ataque":
               this.tipo=tipoObjeto.ATAQUE;
               break;
           case "curacion":
               this.tipo=tipoObjeto.CURACION;
               break;
           default:
               break;
       }
        
    }
    
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
