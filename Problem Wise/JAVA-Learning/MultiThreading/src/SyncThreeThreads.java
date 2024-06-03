import java.util.concurrent.Semaphore;

public class SyncThreeThreads {


    public static void syncThreeThreads(int n){
        SyncThreeThreads printer = new SyncThreeThreads(n);
        Thread printFirst = new Thread(()->
        {
            try {
                printer.printFirst(() -> System.out.println("First"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread printSecond =  new Thread(()->
        {
            try {
                printer.printSecond(() -> System.out.println("Second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread printThird =  new Thread(()->
        {
            try {
                printer.printThird(() -> System.out.println("Third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        printFirst.start();
        printSecond.start();
        printThird.start();

        try{
            printFirst.join();
            printSecond.join();
            printThird.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }



    }
    private int iteration;
    private Semaphore first = new Semaphore(1);
    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    private int counter = 0;
    private SyncThreeThreads(int n){
        this.iteration = n;
    }



    private void printFirst(Runnable printer) throws InterruptedException {
        while(counter<iteration) {
            first.acquire();
            printer.run();
            counter++;
            second.release();
        }

    }

    private void printSecond(Runnable printer) throws InterruptedException {
        while(counter<iteration) {
            second.acquire();
            printer.run();
            counter++;
            third.release();
        }

    }

    private void printThird(Runnable printer) throws InterruptedException {
        while(counter<iteration) {
            third.acquire();
            printer.run();
            counter++;
            first.release();
        }
    }

}
