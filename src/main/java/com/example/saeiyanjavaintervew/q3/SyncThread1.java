package com.example.saeiyanjavaintervew.q3;

public class SyncThread1 extends Thread{
    
    private Object obj1;
    private Object obj2;

    public SyncThread1(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }
    @Override
    public void run() {
        synchronized (obj1) {
           System.out.println("Thread 1: Has  ObjectLock1");
           /* Adding sleep() method so that
              Thread 2 can lock ObjectLock2 */
           try { 
               Thread.sleep(100);
           }
           catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Thread 1: Waiting for ObjectLock 2");
           /*Thread 1 has ObjectLock1 
             but waiting for ObjectLock2*/
           synchronized (obj2) {
              System.out.println("Thread 1: No DeadLock");
           }
        }
    }

}
