package com.example.saeiyanjavaintervew.q2;

import java.util.Map;

public class Test {
    
    public static void main(String[] args) throws Exception{
        SynchronizedHashMap<Integer,String> customHashMap = new SynchronizedHashMap<Integer,String>();


        for(int i = 0 ; i < 1000 ; i ++){
            new Thread(new MyRunnable(customHashMap)).start();
        }

        for(Map.Entry<Integer,String> entry : customHashMap.entrySet()){
            System.out.println("syncronize hashmap is:");
            System.out.println(entry);
        }
    }
}
