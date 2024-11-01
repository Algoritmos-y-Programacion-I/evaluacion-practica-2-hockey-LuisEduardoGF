
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private List<JugadorHockey> jugadores;
    private List<Arbitro> arbitros;

    public Controller() {
        jugadores = new ArrayList<>();
        arbitros = new ArrayList<>();
        initializePlayersAndReferees();
    }

    private void initializePlayersAndReferees() {
        jugadores.add(new JugadorHockey("Jugador 1", 25, Posicion.ALA));
        jugadores.add(new JugadorHockey("Jugador 2", 23, Posicion.DEFENSA));
        jugadores.add(new JugadorHockey("Jugador 3", 28, Posicion.CENTRO));
        jugadores.add(new JugadorHockey("Jugador 4", 26, Posicion.DEFENSA));
        jugadores.add(new JugadorHockey("Jugador 5", 22, Posicion.ALA));
        jugadores.add(new JugadorHockey("Portero", 30, Posicion.PORTERO));

        arbitros.add(new ArbitroPrincipal("Arbitro Principal 1", 40));
        arbitros.add(new JuezDeLinea("Juez de Linea 1", 35));
    }

    /**
     * Simula un partido en el que varios jugadores se pasan el disco y los árbitros se desplazan entre cada pase.
     * La jugada termina cuando se cumplen las condiciones para un gol.
     */
    public void simularJuego() {
        int passCount = 0;
        int lastPlayerIndex = -1;
        List<Integer> participatingPlayers = new ArrayList<>();
        Random random = new Random();

        while (passCount < 5) {
            int currentPlayerIndex = random.nextInt(jugadores.size());

            if (currentPlayerIndex != lastPlayerIndex) {
                JugadorHockey currentPlayer = jugadores.get(currentPlayerIndex);
                JugadorHockey nextPlayer = jugadores.get((currentPlayerIndex + 1) % jugadores.size());

                System.out.println(currentPlayer.getNombre() + " se la pasa a " + nextPlayer.getNombre());

                // Track players participating in the play to ensure at least 3 different players
                if (!participatingPlayers.contains(currentPlayerIndex)) {
                    participatingPlayers.add(currentPlayerIndex);
                }

                // Simulate referee movement
                Arbitro arbitro = arbitros.get(passCount % arbitros.size());
                arbitro.desplazarse();

                lastPlayerIndex = currentPlayerIndex;
                passCount++;
            }
        }

        // Check if goal conditions are met
        if (passCount >= 5 && participatingPlayers.size() >= 3) {
            JugadorHockey scoringPlayer = jugadores.get(lastPlayerIndex);
            System.out.println(scoringPlayer.getNombre() + " entra el disco en la red. ¡Gol!");
        } else {
            System.out.println("No se cumplieron las condiciones para un gol.");
        }
    }

    public String fixture() {
        String fixture = "Fixture de equipos";
        Random random = new Random();
        int equipo1 = random.nextInt(jugadores.size());
        int equipo2;
        do {
            equipo2 = random.nextInt(jugadores.size());
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Jugador " + equipo1 + " vs Jugador " + equipo2;
        return fixture;
    }
}
