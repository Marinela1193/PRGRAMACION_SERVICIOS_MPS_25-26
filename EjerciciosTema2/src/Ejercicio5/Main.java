package Ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int contador;

    public static void main(String[] args){

        System.out.println("Indica cada cuántos segundos quieres que se guarde el saludo: ");
        Scanner sc = new Scanner(System.in);
        int seg = sc.nextInt();
        sc.nextLine();

        Thread t = new Thread(()-> {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("saludo.txt", true));

                while(!Thread.currentThread().isInterrupted()) {

                    writer.write("¡Hola mundo!");
                    writer.newLine();
                    writer.flush();
                    Thread.sleep(seg * 1000);

                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        });

        t.start();

        System.out.println("Pulsa enter para interrumpir el hilo");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();


        t.interrupt();
        System.out.println("Interrumpiendo hilo");

        try{
            t.join();
            System.out.println("¡Adiós!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
