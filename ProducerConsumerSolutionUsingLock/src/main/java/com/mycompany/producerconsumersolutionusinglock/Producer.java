
package com.mycompany.producerconsumersolutionusinglock;

class Producer extends Thread {
    ProducerConsumerImpl pc;
    
    public Producer(ProducerConsumerImpl sharedObject) { 
         
        this.pc = sharedObject; 
    }
    @Override public void run() { 
        while(true){
        try { pc.put(); 
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
        }
    } 
}