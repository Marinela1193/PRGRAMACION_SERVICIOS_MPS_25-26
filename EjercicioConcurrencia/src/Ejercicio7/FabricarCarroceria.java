package Ejercicio7;

import java.util.Random;

public class FabricarCarroceria implements Runnable {

    private Vehiculo vehiculo;

    public FabricarCarroceria(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        Random r = new Random();

            System.out.println("FC: Fabricando carrocería");
            try {
                Thread.sleep(r.nextInt(1000,2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Carroceria c = new Carroceria();
            System.out.println("FC: Carrocería fabricada");
            try {
                synchronized (vehiculo) {
                    System.out.println("FC: Ensamblando carrocería");
                    vehiculo.ensamblarCarroceria(c);
                    vehiculo.notify();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

    }
}
