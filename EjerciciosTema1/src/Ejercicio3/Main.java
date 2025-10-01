package Ejercicio3;

import Ejercicio2.nHilos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de hilos a crear: ");
        int n = sc.nextInt();

        Thread[] hilos = new Thread[n];

        for (int i = 0; i < n; i++) {
            hilos[i] = new Thread(new nHilos(), "Hilo " + (i +1));
            hilos[i].start();
        }

        boolean algunoVivo;
        {
            do {
                algunoVivo = false;
                for (Thread t : hilos) {
                    System.out.println(t.threadId() + " " + t.getName() + " " + t.getState());
                    if (t.isAlive()) {
                        algunoVivo = true;
                    }
                }
                try {
                    Thread.sleep(1000); // espera 1 segundo
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (algunoVivo);
        }
    }
}
