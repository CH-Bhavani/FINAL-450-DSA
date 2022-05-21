/*

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


*/


class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        if(m==null || m.length==0 || m[0].length==0)
            return false;
        int col=m[0].length;
        int row=m.length;
        if(m[0][0]>t || m[row-1][col-1]<t) 
            return false;
        for(int i=0;i<row;i++){
            if(m[i][0]<=t && m[i][col-1]>=t){
                    if(binary_search(m[i],t)!=-1)
                        return true;
                }
            }
        return false;
        
        }
    public static int binary_search(int[] arr,int t){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==t)
                return mid;
            else if (arr[mid]<t)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
