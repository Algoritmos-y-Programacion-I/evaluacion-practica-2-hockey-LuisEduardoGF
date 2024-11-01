
package model;

public class ArbitroPrincipal extends Arbitro {
    public ArbitroPrincipal(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void desplazarse() {
        System.out.println("Arbitro Principal se desplaza sobre el hielo");
    }
}
