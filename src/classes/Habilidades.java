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
    private int usosMaximos;
    private int usosRestantes;

    public Habilidades(String nombre, String descripcion, int usosMaximos, int usosRestantes) {
        super(nombre, descripcion);
        this.usosMaximos = usosMaximos;
        this.usosRestantes = usosRestantes;
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
