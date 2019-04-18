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
public class Habilidad extends ElementoIdentificador{
    private int especial;
    private int usosMaximos;
    private int usosRestantes;
    private tipoHechizo tipo;

    public Habilidad(String nombre, String descripcion, int especial, int usosMaximos, int usosRestantes, tipoHechizo tipo) {
        super(nombre, descripcion);
        this.especial = especial;
        this.usosMaximos = usosMaximos;
        this.usosRestantes = usosRestantes;
        this.tipo = tipo;
    }
    
    public enum tipoHechizo{
        OFENSIVO,
        SANACION
    };

    public int getEspecial() {
        return especial;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }
    
    public int getUsosMaximos() {
        return usosMaximos;
    }

    public void setUsosMaximos(int usosMaximos) {
        this.usosMaximos = usosMaximos;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }

    public void setUsosRestantes(int usosRestantes) {
        this.usosRestantes = usosRestantes;
    }  

    public tipoHechizo getTipo() {
        return tipo;
    }

    public void setTipo(tipoHechizo tipo) {
        this.tipo = tipo;
    }
}
