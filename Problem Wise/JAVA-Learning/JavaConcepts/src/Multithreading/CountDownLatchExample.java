package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is waiting at the latch");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 has passed the latch");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 is waiting at the latch");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 has passed the latch");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3 is waiting at the latch");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 has passed the latch");
        });

        t1.start();
        t2.start();
        t3.start();
        latch.countDown();
        latch.countDown();
        latch.countDown();
        t1.join();
        t2.join();
        t3.join();
    }


}