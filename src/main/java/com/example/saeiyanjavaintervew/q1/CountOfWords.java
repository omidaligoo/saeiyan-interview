package com.example.saeiyanjavaintervew.q1;

import java.util.HashMap;
import java.util.Map;

public class CountOfWords {
    
    public static void main(String[] args)
    {
 
        String str = "This is a test I designed to test a candidate.";
        str = str.replace(".", "");

        
        Map<String, Integer> hashMap = new HashMap<>();
 
        String[] words = str.split(" ");
 
        for (String word : words) {
            // containsKey(key) will return a boolean value
            // i.e. true if it contains the key and false if
            // it doesn't.
            if (hashMap.containsKey(word))
                hashMap.put(word, hashMap.get(word) + 1);
 
            else
                hashMap.put(word, 1);
        }
 
        System.out.println(hashMap);
    }
}
