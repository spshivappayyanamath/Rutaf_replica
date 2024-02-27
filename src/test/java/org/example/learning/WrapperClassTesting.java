package org.example.learning;

import java.util.Iterator;
import java.util.PriorityQueue;

public class WrapperClassTesting {
    public static void Test(){
        int val=1;
        int val1=1;
        System.out.println( val);
        Integer integer= Integer.valueOf(val);
        Integer integer1= Integer.valueOf(val1);

//        auto boxing - converting primitive to wrapper class
        Integer integer2=val1;
        System.out.println(integer2);

//        unboxing - converting wrapper class to primitive
        Integer integer3=10;

        int x= integer3;
        System.out.println(x);

        if (integer == integer1){
            System.out.println("equal");
        }
//        if(integer.){
//
//        }
        System.out.println(integer);

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        Iterator iterator = priorityQueue.iterator();
        while ((iterator.hasNext())){
//            System.out.println(iterator.next());
        }


    }
    public static void main(String args[]){
        Test();
    }
}
