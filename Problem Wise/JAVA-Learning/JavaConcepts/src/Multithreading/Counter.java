package Multithreading;

public class Counter{
        private int count = 1;
        
        public void incrementBy(int num){
            this.count+=num;
        }
        
        public int getCount(){
            return this.count;
        }
    }