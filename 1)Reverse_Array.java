/* Write a program to reverse an array  */

import java.util.*;
public class reverse_array {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(reverse(arr)));
    }
    public static int[] reverse(int[] intarr){
        int temp;
        for(int i=0;i<(intarr.length/2);i++){
            System.out.println(i+" "+intarr[i]+" "+intarr[intarr.length-i-1]);
            temp=intarr[i];
            intarr[i]=intarr[intarr.length-i-1];   // imp:  intarrlength-i-AS ARRAY IS ZERO INDEXED
            intarr[intarr.length-i-1]=temp;
        }
        return intarr;
    }
