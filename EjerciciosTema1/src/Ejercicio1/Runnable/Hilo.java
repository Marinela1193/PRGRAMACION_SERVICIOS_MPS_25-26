package Ejercicio1.Runnable;

public class Hilo implements Runnable{

    int n1;
    int n2;

    public Hilo(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {

        try {

            if (n1 < n2) {
                for (int contador = n1; contador <= n2; contador++) {

                    System.out.println(contador);
                    Thread.sleep(1000);

                }
            }
            if (n2 < n1) {
                for (int contador = n2; contador <= n1; contador++) {

                    System.out.println(contador);
                    Thread.sleep(1000);
                }
            }
            if (n1 == n2) {
                System.out.println("Tienes que indicar dos número diferentes");
            }

        } catch (InterruptedException ie) {
            System.out.println("Hilo interrumpido");
        }
    }
}
