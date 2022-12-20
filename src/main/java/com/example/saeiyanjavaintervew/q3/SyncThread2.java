package com.example.saeiyanjavaintervew.q3;

public class SyncThread2 extends Thread {
    
    private Object obj1;
    private Object obj2;

    public SyncThread2(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }

    public void run() {
        synchronized (obj2) {
           System.out.println("Thread 2: Has  ObjectLock2");
           /* Adding sleep() method so that
              Thread 1 can lock ObjectLock1 */
           try { 
               Thread.sleep(100);
           }
           catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Thread 2: Waiting for ObjectLock 1");
           /*Thread 2 has ObjectLock2 
             but waiting for ObjectLock1*/
           synchronized (obj1) {
              System.out.println("Thread 2: No DeadLock");
           }
        }
     }
}
