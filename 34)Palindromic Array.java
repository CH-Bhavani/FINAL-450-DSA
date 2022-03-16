/*
Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

 

Example:
Input:
2
5
111 222 333 444 555
3
121 131 20

Output:
1
0

Explanation:
For First test case.
n=5;
A[0] = 111    //which is a palindrome number.
A[1] = 222   //which is a palindrome number.
A[2] = 333   //which is a palindrome number.
A[3] = 444  //which is a palindrome number.
A[4] = 555  //which is a palindrome number.
As all numbers are palindrome so This will return 1.

*/


// method-1
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  //add code here.{
    	// code here
        for(int i=0; i<n; i++){
            int num = a[i];
            int rev = 0;
            int rem;
            while(num>0){
                rem = num%10;
                rev = rev*10 + rem;
                num/=10;
            }
            if(rev!=a[i])   
            	return 0;
        }
        return 1;
    }
}


// method -2



for(int i = 0; i < n; i++){
                     String sb0 = Integer.toString(a[i]);
                     int len = sb0.length();
                     for(int j = 0; j < len/2; j++){
                         if(sb0.charAt(j)!=sb0.charAt(len-j-1)){
                             return 0;}}}
                     return 1;
