package Ejercicio7;

import java.util.Random;

public class FabricarMotor implements Runnable {

    private Vehiculo vehiculo;

    public FabricarMotor(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("FM: Fabricando motor");
        try {
            Thread.sleep(r.nextInt(1000, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Motor m = new Motor();
        System.out.println("FM: Motor fabricado");

        synchronized (vehiculo) {
            while (vehiculo.getCarroceria() == null) {
                try {
                    System.out.println("Todavía no se puede ensamblar el motor, se está ensamblando la carroceria");
                    vehiculo.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("FM: Ensamblando motor");
            vehiculo.ensamblarMotor(m);

        }
    }
}
