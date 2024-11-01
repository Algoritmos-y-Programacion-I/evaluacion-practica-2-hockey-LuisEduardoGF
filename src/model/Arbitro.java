
package model;

public abstract class Arbitro extends Persona {
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }

    public abstract void desplazarse();
}
