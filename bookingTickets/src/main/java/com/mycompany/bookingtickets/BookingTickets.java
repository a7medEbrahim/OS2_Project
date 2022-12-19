package com.mycompany.bookingtickets;

import java.util.Scanner;


public class BookingTickets {

    public static void main(String[] args) {
        
        Tickets l= new Tickets();
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("enter numper of tickets : ");
        int num = in.nextInt();
        l.numtickets(num);
        
        Admin p = new Admin(l);
        p.setName("Admin :");
        Customer c = new Customer(l);
        c.setName("customer 1:");
        Customer cc = new Customer(l);
        cc.setName("customer 2:");
        Customer ccc = new Customer(l);
        ccc.setName("customer 3:");
        
        Customer cccc = new Customer(l);
        cccc.setName("customer 4:");
        Customer ccccc = new Customer(l);
        ccccc.setName("customer 5:");
        
        Customer cccccc = new Customer(l);
        cccccc.setName("customer 6:");
        p.start();
        c.start();
        cc.start();        
        ccc.start();
        cccc.start();
        ccccc.start();
        cccccc.start();


    }
}
