
package model;

/**
 * Clase abstracta que representa una Persona en el juego de hockey.
 */
public abstract class Persona {
    protected String nombre;
    protected int edad;

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre Nombre de la persona.
     * @param edad Edad de la persona.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
