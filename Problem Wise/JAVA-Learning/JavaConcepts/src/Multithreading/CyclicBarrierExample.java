package Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private CyclicBarrier barrier;

    public CyclicBarrierExample(int parties) {
        barrier = new CyclicBarrier(parties);
    }

    public void await() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierExample barrier = new CyclicBarrierExample(3);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is waiting at the barrier");
            barrier.await();
            System.out.println("Thread 1 has passed the barrier");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 is waiting at the barrier");
            barrier.await();
            System.out.println("Thread 2 has passed the barrier");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3 is waiting at the barrier");
            barrier.await();
            System.out.println("Thread 3 has passed the barrier");
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}