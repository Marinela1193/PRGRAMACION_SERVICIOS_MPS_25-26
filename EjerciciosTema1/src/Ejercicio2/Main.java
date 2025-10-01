package Ejercicio2;

import Ejercicio1.Runnable.Hilo1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de hilos a crear: ");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){

            Thread t = new Thread(new nHilos(), "Hilo " + i);
            t.start();
        }

    }
}