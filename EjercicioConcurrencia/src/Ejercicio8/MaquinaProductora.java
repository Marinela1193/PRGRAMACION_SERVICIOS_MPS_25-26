package Ejercicio8;

import java.sql.Array;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MaquinaProductora implements Runnable {

    String nombre;
    int intensidad;
    private List<Capsula> contenedor;
    Capsula capsula = new Capsula();

    public MaquinaProductora(String nombre, int intensidad, List<Capsula> contenedor)
    {
        this.nombre = nombre;
        this.intensidad = intensidad;
        this.contenedor = contenedor;
    }

    @Override
    public void run () {
        Random r = new Random();
        synchronized (contenedor) {
            try {
                while(contenedor.size()<6) {
                    Thread.sleep(r.nextInt(500, 1000));

                    Capsula c = new Capsula(nombre, intensidad);
                    contenedor.add(c);
                    System.out.println("Hilo Productor: Se ha fabridado una capsula. Total en contenedor: " + contenedor.size());
                    if(contenedor.size() == 6){
                        contenedor.notify();
                        contenedor.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}