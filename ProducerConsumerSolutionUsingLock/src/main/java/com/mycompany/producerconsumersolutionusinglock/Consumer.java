
package com.mycompany.producerconsumersolutionusinglock;


class Consumer extends Thread {
    ProducerConsumerImpl pc;
    public Consumer(ProducerConsumerImpl sharedObject) { 
        
        this.pc = sharedObject; 
    } 
    @Override public void run() {
        while(true){
            try {
                pc.get();
                Thread.sleep((int) (Math.random() * 1000));
            }
        
            catch (InterruptedException e) {
                e.printStackTrace(); }
        }
    } 
}