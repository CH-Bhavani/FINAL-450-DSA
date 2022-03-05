/*Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
Kadane's Algorithm:


Initialize:

    max_so_far = INT_MIN

    max_ending_here = 0



Loop for each element of the array

  (a) max_ending_here = max_ending_here + a[i]

  (b) if(max_so_far < max_ending_here)

            max_so_far = max_ending_here

  (c) if(max_ending_here < 0)

            max_ending_here = 0

return max_so_far



*/



class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        int max_so_far=Integer.MIN_VALUE,max_ending_here=0;
        // Your code here
        for(int i=0;i<n;i++){
            max_ending_here=max_ending_here+arr[i];
            if(max_ending_here>max_so_far) max_so_far=max_ending_here;
            if(max_ending_here<0) max_ending_here=0;
        }
        return max_so_far;
        
    }
    
}
