package Ejercicio3;

public class Hilo3 implements Runnable{
    int num = (int) (Math.random() * 100) + 1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Mostrando primos hasta el " + num);
        try {
            for (int i = 1; i <=num; i++) {
                if (esPrimo(i)) {
                    System.out.println(
                            Thread.currentThread(). threadId() + " " +
                                    Thread.currentThread().getName() + " " +
                                    Thread.currentThread().getState()
                    );
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(1000);
                }
            }
        }catch(InterruptedException ie) {
            System.out.println("El hilo se ha interrumpido");
        }
    }

    boolean esPrimo(int num) {
        if (num <= 1) {

            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
