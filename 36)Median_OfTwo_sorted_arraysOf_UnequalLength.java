/*
iven two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays,
in O(log n + log m) time complexity, when n is the number of elements in the first array, and m is the number of elements in the second array. 


Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3

Input: ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
Output : The median is 11.
Explanation : The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even, 
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.
*/







// method-1


import java.io.*;
import java.util.Arrays;
 
public class GFG {
    public static int Solution(int[] arr)
    {
        int n = arr.length;
       
        // If length of array is even
        if (n % 2 == 0)
        {
            int z = n / 2;
            int e = arr[z];
            int q = arr[z - 1];
 
            int ans = (e + q) / 2;
            return ans;
        }
       
        // If length if array is odd
        else
        {
            int z = Math.round(n / 2);
            return arr[z];
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
         
        // TODO Auto-generated method stub
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
 
        int i = arr1.length;
        int j = arr2.length;
 
        int[] arr3 = new int[i + j];
 
        // Merge two array into one array
        System.arraycopy(arr1, 0, arr3, 0, i);
        System.arraycopy(arr2, 0, arr3, i, j);
 
        // Sort the merged array
        Arrays.sort(arr3);
 
        // calling the method
        System.out.print("Median = " + Solution(arr3));
    }
}




// method -2




public class GFG {
 
    // Method to find median
    static double Median(int[] A, int[] B)
    {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return Median(B, A); // Swapping to make A smaller
 
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? A[leftAsize - 1]
                    : Integer.MIN_VALUE; // checking overflow of indices
            int leftB
                    = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA
                    = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB
                    = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;
 
            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
        else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
 
  // Driver code
    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
        System.out.println("Median of the two arrays are");
        System.out.println(Median(arr1, arr2));
    }
}
