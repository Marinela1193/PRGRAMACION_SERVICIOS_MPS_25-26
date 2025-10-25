package Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Capsula> contenedor = new ArrayList<>();

        MaquinaProductora mp = new MaquinaProductora("Cappuccino",3,contenedor);
        MaquinaConsumidora mc = new MaquinaConsumidora(contenedor);

        new Thread(mp).start();
        new Thread(mc).start();
    }
}
