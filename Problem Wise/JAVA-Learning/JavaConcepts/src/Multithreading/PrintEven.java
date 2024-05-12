package Multithreading;


public class PrintEven extends Thread {
    int target = 0;
    Counter count = null;

    public PrintEven(Counter count, int target) {
        this.target = target;
        this.count = count;
    }

    @Override
    public void run() {
        super.run();
        while (count.getCount() <= target)
            if (count.getCount() % 2 == 0) {
                synchronized (count) {
                System.out.println(count.getCount());
                count.incrementBy(1);
                }
            }
    }

}

