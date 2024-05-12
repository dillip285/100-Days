package Multithreading;

public class ThreadBasic {


    public void invokeThread(int number){

        Counter counter = new Counter();
        PrintEven printEven = new PrintEven(counter, number);
        PrintOdd printOdd = new PrintOdd(counter, number);
        printOdd.start();
        printEven.start();

    }



}
