/*
Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts. 
1) All elements smaller than lowVal come first. 
2) All elements in range lowVal to highVVal come next. 
3) All elements greater than highVVal appear in the end. 
The individual elements of three sets can appear in any order.

Examples: 

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
        lowVal = 14, highVal = 20
Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
       lowVal = 20, highVal = 20       
Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54} 

*/




import java.util.Scanner;

public class threewaypartition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        threeWay(arr, 10, 20);
        System.out.println("Modified array ");
        for (int i=0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static int[] threeWay(int[] arr,int a,int b){
        int start=0,end =arr.length-1;
        for(int i=0;i<=end;){
            if(arr[i]<a){
                int temp=arr[i];
                arr[i]=arr[start];
                arr[start]=temp;
                i++;
                start++;
            }
            else if (arr[i]>b){
                int temp=arr[i];
                arr[i]=arr[end];
                arr[end]=temp;
                end--;
            }
            else
                i++;
        }
        return arr;
    }
}
