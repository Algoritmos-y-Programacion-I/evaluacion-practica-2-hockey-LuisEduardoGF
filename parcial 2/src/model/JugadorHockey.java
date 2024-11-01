
package model;

/**
 * Clase que representa a un Jugador de Hockey, derivada de Persona.
 */
public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo {
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, Posicion posicion) {
        super(nombre, edad);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }
}
