package com.example.saeiyanjavaintervew.q3;

public class ThreadDeadLockSimulation {
    
    public static void main(String[] args) throws InterruptedException {

        Object obj1 = new Object();
        Object obj2 = new Object();
    
        Thread t1 = new Thread(new SyncThread1(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread1(obj1, obj2), "t2");
        
        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        
    }
}
