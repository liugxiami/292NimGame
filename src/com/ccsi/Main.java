package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer,Boolean> cache=new HashMap<>();
        System.out.println(canWinNim2(1,cache));
    }
    //You are playing the following Nim Game with your friend:There is a heap of stones one the table,
    //each time one of you take turns to remove 1 ot 3 stones. The one who remove the last stone will
    //You will take the first turn to remove the stones.
    //Both of you are very clever and have optimal strategies for the game. Write a function to determine
    //whether you can win the game given the number of stones in the heap.
    //math
    public static boolean canWinNim1(int k){
        return k%4!=0;
    }
    //backtrack and dynamic programming
    public static boolean canWinNim2(int k, Map<Integer,Boolean> cache){
        if(k<=0){
            cache.put(0,false);
            return false;
        }
        if(k==1){
            cache.put(1,true);
            return true;
        }
        if(k==2){
            cache.put(2,true);
            return true;
        }
        if(k==3) {
            cache.put(3,true);
            return true;
        }
        
        if(canWinNim2(k-1,cache)&&canWinNim2(k-2,cache)&&canWinNim2(k-3,cache)){ //如果前3个都是赢得话，那么当前必然输
            cache.put(k,false);
        }else{
            cache.put(k,true);
        }
        return cache.get(k);
    }
}
