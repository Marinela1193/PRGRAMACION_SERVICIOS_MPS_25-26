package Ejercicio4;

public class Hilos4 implements Runnable {

        private int contador = 0;
        private boolean ejecutar = true;
        public void detener() {ejecutar = false; }
        //declaramos variable para hacer referencia al numero del main
        private int random;

        //generamos constructor
        public Hilos4(int random){
            this.random = random;
        }

        @Override
        public void run() {
            while(ejecutar){
                try{
                    //Empezamos a contar desde 1
                    Thread.sleep(1000);
                    contador++;
                    if(contador<=5){
                    System.out.println(contador);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(contador==random){
                System.out.println("Lo has conseguido!");
            }
            else{
                System.out.println("Vuelve a intentarlo, has detenido el contador en "+ contador);
            }
        }
    }

