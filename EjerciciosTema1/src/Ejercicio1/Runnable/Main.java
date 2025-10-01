package Ejercicio1.Runnable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce n1: ");
        int n1 = sc.nextInt();

        System.out.println("Introduce n2");
        int n2 = sc.nextInt();

        Thread t = new Thread(new Hilo1(n1, n2));

        t.start();

        if(t.isAlive()) {
            System.out.println("El hilo se ha lanzado");
        }

    }
}

