/*
Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

Example 1:

Input:
5
4 2 -3 1 6

Output: 
Yes

Explanation: 
2, -3, 1 is the subarray 
with sum 0.
Example 2:

Input:
5
4 2 0 1 6

Output: 
Yes

Explanation: 
0 is one of the element 
in the array so there exist a 
subarray with sum 0.

*/




class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        HashSet<Integer> hs=new HashSet<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(arr[i]==0 || sum==0 || hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
}
