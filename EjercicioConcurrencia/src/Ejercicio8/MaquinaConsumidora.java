package Ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MaquinaConsumidora implements Runnable {

    private List<Capsula> contenedor;
    Capsula capsula = new Capsula();

    public MaquinaConsumidora(List<Capsula> contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true) {
            synchronized (contenedor) {
                try {
                    while (contenedor.size() < 6) {
                        contenedor.wait();
                    }
                    Thread.sleep(500);
                    System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
                    Thread.sleep(1000);
                    System.out.println("Hilo Consumidor: Caja creada");

                    contenedor.clear();

                    contenedor.notify();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
