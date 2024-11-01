
package model;

/**
 * Clase que representa un equipo de hockey.
 */
public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;
    private JugadorHockey[] jugadores;

    public Equipo() {
        jugadores = new JugadorHockey[CANTIDAD_JUGADORES];
    }

    public void agregarJugador(JugadorHockey jugador, int posicion) {
        if (posicion >= 0 && posicion < jugadores.length) {
            jugadores[posicion] = jugador;
        }
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}
