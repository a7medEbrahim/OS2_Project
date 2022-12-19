/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookingtickets;


class Admin extends Thread {
    Tickets pc;
    
    public Admin(Tickets sharedObject) { 
         
        this.pc = sharedObject; 
    }
    @Override public void run() { 
        while(true){
        try { pc.put(); 
   
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
        }
    } 
}