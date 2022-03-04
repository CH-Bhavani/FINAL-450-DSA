/*
Find the "Kth" max and min element of an array */



// method1
using sorting



// method 2
 using priority queue (implement min heap to find kth minimum)

  
import java.util.*;
public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {23, 4, -7, 30, -85, -4, 72};
        int k = 9;
        if (k > arr.length)
            System.out.println("null");
        else {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int value : arr) pq.add(value);
            int j = 1, min = 0;
            while (pq.size() != 0) {
                if (k == j) {
                    min = pq.poll();
                }
                pq.poll();
                j++;
            }
            System.out.println(min);

        }
    }
  
  
  
  // method 3 
  using priority  queue (implement max heap to find kth maximum)
    
    
    import java.util.*;
public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {23, 4, -7, 30, -85, -4, 72};
        int k = 1;
        if (k > arr.length)
            System.out.println("null");
        else {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int value : arr) pq.add(value);
            int j = 1, max = 0;
            while (pq.size() != 0) {
                if (k == j) {
                    max = pq.poll();
                }
                pq.poll();
                j++;
            }
            System.out.println(max);

        }
    }

}
  
  
  
  
  // method -4 
  o(n) complexity 
    
    



