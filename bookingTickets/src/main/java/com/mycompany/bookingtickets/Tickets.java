package com.mycompany.bookingtickets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class Tickets {
    private static final int CAPACITY = 100; 
    private final Queue queue = new LinkedList<>(); 
    private final Lock aLock = new ReentrantLock(); 
    private final Condition bufferNotFull = aLock.newCondition(); 
    private final Condition bufferNotEmpty = aLock.newCondition();
    private static  int number = 0; 
    public static  int num_Tickets ; 

    public int numtickets(int n){
    num_Tickets=n;
    return num_Tickets;
    }

    public void put() throws InterruptedException {
        while(number==num_Tickets){}
        aLock.lock();
        try { 
            while (queue.size() == CAPACITY) { 
                bufferNotEmpty.await();
            } 
            
            number++; 
            boolean isAdded = queue.offer(number); 
            if (isAdded) {
                System.out.printf("%s added ticket number: %d .%n", Thread .currentThread().getName(), number);
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
                System.out.println("\t\t\t\t"+Thread.currentThread().getName() + " : there is no tickets now.");           
                bufferNotFull.await();
            } 
            Integer value = (Integer) queue.poll(); 
            if (value != null) {
                System.out.printf("\t\t\t\t %s booked ticket %d . %n", Thread .currentThread().getName(), value);
                bufferNotEmpty.signalAll(); 
                while(value==num_Tickets){
                    System.exit(0);
                }
            }
        
        } finally {
            aLock.unlock(); 
        } 
    } 
}
