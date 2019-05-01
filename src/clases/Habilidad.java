package clases;

import exceptions.InvalidTipoException;

/**
 *
 * @author Ivan Diaz Vera
 */
public class Habilidad extends ElementoIdentificador{
    private int especial;
    private int usosMaximos;
    private int usosRestantes;
    private tipoHechizo tipo;

    /**
     * Constructor de Habilidad
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param especial Variable de tipo entero que indica el atributo especial.
     * @param usosMaximos Variable de tipo entero que indica el numero maximo de usos de una habilidad.
     * @param usosRestantes Variable de tipo entero que indica el numero restante de usos de una habilidad.
     * @param tipo Variable tipo que nos permite indicar el tipo de hechizo y asi modificar ciertas funciones.
     */
    public Habilidad(String nombre, String descripcion, int especial, int usosMaximos, int usosRestantes, String tipo) throws InvalidTipoException{
        super(nombre, descripcion);
        this.especial = especial;
        this.usosMaximos = usosMaximos;
        this.usosRestantes = usosRestantes;
        setTipo(tipo);
    }

    public enum tipoHechizo{
        OFENSIVO,
        CURATIVO
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

    public void setTipo(String tipo) throws InvalidTipoException {
        switch(tipo.toLowerCase()){
            case "ofensivo":
                this.tipo=tipoHechizo.OFENSIVO;
                break;
            case "curativo":
                this.tipo=tipoHechizo.CURATIVO;
                break;
            default:
                throw new InvalidTipoException(tipo+" no es valido. Solo puede ser 'ofensivo' o 'curativo'");
        }
    }
}
