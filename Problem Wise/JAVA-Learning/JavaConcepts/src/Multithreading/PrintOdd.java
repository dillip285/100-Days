package Multithreading;

public class PrintOdd extends Thread{
    int target = 0;
    Counter count = null;

    public PrintOdd(Counter count, int target) {
        this.target = target;
        this.count = count;
    }

    @Override
    public void run() {
        super.run();
        while (count.getCount() <= target)
            if (count.getCount() % 2 == 1) {
                synchronized (count) {
                    System.out.println(count.getCount());

                    count.incrementBy(1);
                }
            }
    }

}
