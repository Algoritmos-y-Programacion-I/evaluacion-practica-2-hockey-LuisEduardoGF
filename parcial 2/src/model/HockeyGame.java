
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HockeyGame {

    private List<JugadorHockey> jugadores;
    private List<Arbitro> arbitros;
    private Random random;

    /** 
     * Constructor de la clase HockeyGame para inicializar jugadores y árbitros.
     * 
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de HockeyGame con listas de jugadores y árbitros predefinidas.
     */
    public HockeyGame() {
        jugadores = new ArrayList<>();
        arbitros = new ArrayList<>();
        random = new Random();

        // Adding players to the game
        jugadores.add(new JugadorHockey("Jugador 1"));
        jugadores.add(new JugadorHockey("Jugador 10"));
        jugadores.add(new JugadorHockey("Jugador 9"));
        jugadores.add(new JugadorHockey("Jugador 3"));
        jugadores.add(new JugadorHockey("Jugador 7"));

        // Adding referees to the game
        arbitros.add(new ArbitroPrincipal());
        arbitros.add(new JuezDeLinea());
    }

    /** 
     * Inicia la simulación de una jugada de hockey.
     * 
     * @pre La lista de jugadores y árbitros está inicializada y contiene elementos.
     * @post Simula una jugada con pases y desplazamientos de árbitros hasta que se cumplan las condiciones para un gol.
     */
    public void startGame() {
        int passCount = 0;
        int lastPlayerIndex = -1;
        List<Integer> participatingPlayers = new ArrayList<>();

        while (passCount < 5) {
            int currentPlayerIndex = random.nextInt(jugadores.size());
            
            // Ensure a different player is passing each time
            if (currentPlayerIndex != lastPlayerIndex) {
                JugadorHockey currentPlayer = jugadores.get(currentPlayerIndex);
                JugadorHockey nextPlayer = jugadores.get((currentPlayerIndex + 1) % jugadores.size());

                System.out.println(currentPlayer.getNombre() + " se la pasa a " + nextPlayer.getNombre());
                
                // Add player to the list of participants
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

        // Check if the conditions for a goal are met
        if (passCount >= 5 && participatingPlayers.size() >= 3) {
            JugadorHockey scoringPlayer = jugadores.get(lastPlayerIndex);
            System.out.println(scoringPlayer.getNombre() + " entra el disco en la red. ¡Gol!");
        }
    }

    /** 
     * Método principal (main) para iniciar la ejecución del juego de hockey.
     * 
     * @pre No se requieren precondiciones específicas.
     * @post Ejecuta la simulación de la jugada de hockey.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        HockeyGame game = new HockeyGame();
        game.startGame();
    }
}

// Supporting class declarations
abstract class Persona {
    protected String nombre;

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre Nombre de la persona.
     * @pre Nombre no debe ser nulo o vacío.
     * @post Crea una instancia de Persona con el nombre especificado.
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class JugadorHockey extends Persona {
    public JugadorHockey(String nombre) {
        super(nombre);
    }
}

abstract class Arbitro extends Persona {
    public Arbitro() {
        super("Arbitro");
    }

    public abstract void desplazarse();
}

class ArbitroPrincipal extends Arbitro {
    @Override
    public void desplazarse() {
        System.out.println("Arbitro Principal se desplaza sobre el hielo");
    }
}

class JuezDeLinea extends Arbitro {
    @Override
    public void desplazarse() {
        System.out.println("Juez de Linea se desplaza sobre el hielo");
    }
}
