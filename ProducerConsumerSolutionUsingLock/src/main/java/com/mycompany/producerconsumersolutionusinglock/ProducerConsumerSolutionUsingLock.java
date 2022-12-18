package com.mycompany.producerconsumersolutionusinglock;


public class ProducerConsumerSolutionUsingLock {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();
        Producer p = new Producer(sharedObject);
        p.setName("producer1:");
        Consumer c = new Consumer(sharedObject);
        c.setName("consumer1:");
        Producer pp = new Producer(sharedObject);        
        pp.setName("producer2:");
        Consumer cc = new Consumer(sharedObject);
        cc.setName("consumer2:");
        p.start();
        c.start();
        pp.start();
        cc.start();          
        
    }
}








