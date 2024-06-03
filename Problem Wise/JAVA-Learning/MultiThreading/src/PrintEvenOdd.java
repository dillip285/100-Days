import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class PrintEvenOdd extends Thread{

    public static void printEvenOdd(int n){
        PrintEvenOdd printer = new PrintEvenOdd(100);

        Thread printEven = new Thread(() -> {
            try {
                printer.printEven(i -> System.out.println("Even: " + i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread printOdd = new Thread(() -> {
            try {
                printer.printOdd(i -> System.out.println("Odd: " + i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        printEven.start();
        printOdd.start();

        try {
            printEven.join();
            printOdd.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private int range;

    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(1);

    private PrintEvenOdd(int n){
        this.range = n;
    }

    private void printEven(Consumer<Integer> printEven) throws InterruptedException {
        for(int i = 2 ; i <= this.range ; i+=2){
            even.acquire();
            printEven.accept(i);
            odd.release();
        }
    }

    private void printOdd(Consumer<Integer> printOdd) throws InterruptedException {
        for(int i = 1 ; i <= this.range ; i+=2){
            odd.acquire();
            printOdd.accept(i);
            even.release();
        }
    }
}