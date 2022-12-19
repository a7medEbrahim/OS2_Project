
package com.mycompany.bookingtickets;

class Customer extends Thread {
    Tickets pc;
    public Customer(Tickets sharedObject) { 
        
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
