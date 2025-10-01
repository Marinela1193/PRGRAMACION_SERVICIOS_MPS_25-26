package Ejercicio1.ClaseAnonima;

import Ejercicio1.Runnable.Hilo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce n1: ");
        int n1 = sc.nextInt();

        System.out.println("Introduce n2");
        int n2 = sc.nextInt();

        Runnable r = new Runnable() {
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
        };

        Thread t = new Thread(new Hilo(n1, n2));

        t.start();

        if(t.isAlive()) {
            System.out.println("El hilo se ha lanzado");
        }

    }
}

