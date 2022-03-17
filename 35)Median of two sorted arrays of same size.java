/*
There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array 
obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)). 

*/




import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ar1[] = { 1, 2, 3, 6 };
        int ar2[] = { 4, 6, 8, 10 };
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 != n2) {
            System.out.println(
                    "Doesn't work for arrays "
                            + "of unequal size");
        }
        else if (n1 == 0) {
            System.out.println("Arrays are empty.");
        }
        else if (n1 == 1) {
            System.out.println((ar1[0] + ar2[0]) / 2);
        }
        else {
            System.out.println(
                    "Median is "
                            + getMedian(
                            ar1, ar2, 0, 0,
                            ar1.length - 1, ar2.length - 1));
        }
    }
    public static  int getMedian(int[] arr1,int[] arr2,int start1,int start2,int end1,int end2){
        if(end1-start1==1){
            return (Math.max(arr1[start1],arr2[start2])+Math.min(arr1[end1],arr2[end2]))/2;}
        int med1=median(arr1,start1,end1);
         int med2=median(arr2,start2,end2);
         if(med1==med2) return med1;
         else if(med1>med2){
             return getMedian(arr1,arr2,start1,(end2+start2+1)/2,(end1+start1+1)/2,end2);
         }
         else
             return getMedian(arr1,arr2,(end1+start1+1)/2,start2,end1,(start2+end2+1)/2);
        }
        public static int median(int[] arr,int start,int end){
        int n=end-start+1;
        if(n%2==0)
            return (arr[start+(n/2-1)]+arr[start+ n/2]/2);
        else
            return (arr[start+n/2]);
    }
}
