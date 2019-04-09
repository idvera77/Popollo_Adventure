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
public class Habilidades extends ElementoIdentificador{
    private int especial;
    private int usosMaximos;
    private int usosRestantes;

    public Habilidades(String nombre, String descripcion, int especial, int usosMaximos, int usosRestantes) {
        super(nombre, descripcion);
        this.especial = especial;
        this.usosMaximos = usosMaximos;
        this.usosRestantes = usosRestantes;
    }

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
}
