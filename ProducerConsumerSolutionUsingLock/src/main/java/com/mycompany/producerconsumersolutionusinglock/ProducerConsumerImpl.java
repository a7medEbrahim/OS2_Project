
package com.mycompany.producerconsumersolutionusinglock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ProducerConsumerImpl {
    private static final int CAPACITY = 5; 
    private final Queue queue = new LinkedList<>(); 
    private final Lock aLock = new ReentrantLock(); 
    private final Condition bufferNotFull = aLock.newCondition(); 
    private final Condition bufferNotEmpty = aLock.newCondition();
    private static  int number = 0; 
    
    

    public void put() throws InterruptedException {
        while(number==10){}
        aLock.lock();
        try { 
            while (queue.size() == CAPACITY) { 
                System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                bufferNotEmpty.await();
            } 
            
            number++; 
            boolean isAdded = queue.offer(number); 
            if (isAdded) {
                System.out.printf("%s added %d into queue %n", Thread .currentThread().getName(), number);
                bufferNotFull.signalAll();
                
            }
        }
        
         
        finally {
            aLock.unlock();
        }            
    }
    public void get() throws InterruptedException {
        
        aLock.lock();
        try { 
            
            while (queue.size() == 0) {
                System.out.println("\t\t\t\t"+Thread.currentThread().getName() + " : Buffer is empty, waiting");           
                bufferNotFull.await();
            } 
            Integer value = (Integer) queue.poll(); 
            if (value != null) {
                System.out.printf("\t\t\t\t %s consumed %d from queue %n", Thread .currentThread().getName(), value);
                bufferNotEmpty.signalAll(); 
                while(value==10){
                    System.exit(0);
                }
            }
        
        } finally {
            aLock.unlock(); 
        } 
    } 
}
