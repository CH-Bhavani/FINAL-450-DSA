/*

Given an integer N, find its factorial.

Example 1:

Input: N = 5
Output: 120
Explanation : 5! = 1*2*3*4*5 = 120
Example 2:

Input: N = 10
Output: 3628800
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800


*/



// method 1 using array

class Solution {
    static ArrayList<Integer> factorial(int n){
        //code here
        ArrayList<Integer> arr=new ArrayList<>();
        int res_size=1;
        int res[]=new int[1000000];
        res[0]=1;
        for(int x=2;x<=n;x++){
            res_size=multiply(x,res,res_size);
        }
        for(int i=res_size-1;i>=0;i--) arr.add(res[i]);
        return arr;
    }
    public static int multiply(int x,int res[], int res_size){
        int carry=0;
        for(int i=0;i<res_size;i++){
            int prod=res[i]*x+carry;
            res[i]=prod%10;
            carry=prod/10;
        }
        while(carry!=0){
            
            res[res_size]=carry%10;
            carry=carry/10;
            res_size++;
        }
        return res_size;
    }
}




//using linkedList
