package com.example.saeiyanjavaintervew.q2;

public class MyRunnable implements Runnable{
    

        private SynchronizedHashMap clazz;

        private Integer number;
    
        public MyRunnable(SynchronizedHashMap clazz){
            this.clazz = clazz;
            
        }
    
        Integer min = 50;
        Integer max = 150;


        @Override
        public void run(){
            number= (int) Math.floor(Math.random()*(max-min+1)+min);
            clazz.put(number, "saeiyan");
        }
    
    
}
