package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        int num = (int)(Math.random()*11)+10;
        System.out.println("Número: "+ num);

        Hilos4 h = new Hilos4(num
        );
        Thread t = new Thread(h);
        t.start();

        System.out.println("Pulsa enter cuando creas que el contador ha llegado a "+num);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        h.detener();

        try{
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
