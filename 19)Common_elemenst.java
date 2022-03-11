/*
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order. 
If there are no such elements return an empty array. In this case the output will be printed as -1.

 

Expected Time Complexity: O(n1 + n2 + n3)
Expected Auxiliary Space: O(n1 + n2 + n3)

*/






// method -1 works well if array does not contain duplicates.




class Solution
{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> arr=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3){
            if(a[i]==b[j] && b[j]==c[k]){
                arr.add(a[i]);
                i++;
                j++;
                k++;
            }
            else if (a[i]<b[j]) i++;
            else if (b[j]<c[k]) j++;
            else k++;
        }
        return arr;
    }
}





// method -2  handling duplicates by rembering previous values



class Solution
{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> arr=new ArrayList<>();
        int i=0,j=0,k=0;
        int prev1,prev2,prev3;
        prev1=prev2=prev3=Integer.MIN_VALUE;
        while(i<n1 && j<n2 && k<n3){
            while(i<n1 && a[i]==prev1){
                i++;
            }
            while(j<n2 && b[j]==prev2){
                j++;
            }
            while(k<n3 && c[k]==prev3){
                k++;
            }
            if(i<n1 && j<n2 && k<n3){
                if(a[i]==b[j] && b[j]==c[k]){
                    prev1=a[i];
                    prev2=b[j];
                    prev3=c[k];
                    arr.add(a[i]);
                    j++;
                    k++;
                    i++;
                    
                }
                else if (a[i]<b[j]){
                    prev1=a[i];
                    i++;
                }
                else if(b[j]<c[k]){
                    prev2=b[j];
                    j++;
                }
                else{
                    prev3=c[k];
                    k++;
                }
            }
        }
        return arr;
    }
}



// method -3 remove duplicates and find frequency



class GFG {
    public static void commonElements(int[] arr1,
                                      int[] arr2,
                                      int[] arr3, int n1,
                                      int n2, int n3)
    {
        // creating a max variable
        // for storing the maximum
        // value present in the all
        // the three array
        // this will be the size of
        // array for calculating the
        // frequency of each element
        // present in all the array
        int max = Integer.MIN_VALUE;

        // deleting duplicates in linear time
        // for arr1
        int res1 = 1;
        for (int i = 1; i < n1; i++) 
        {
            max = Math.max(arr1[i], max);
            if (arr1[i] != arr1[res1 - 1]) 
            {
                arr1[res1] = arr1[i];
                res1++;
            }
        }

        // deleting duplicates in linear time
        // for arr2
        int res2 = 1;
        for (int i = 1; i < n2; i++) 
        {
            max = Math.max(arr2[i], max);
            if (arr2[i] != arr2[res2 - 1])
            {
                arr2[res2] = arr2[i];
                res2++;
            }
        }

        // deleting duplicates in linear time
        // for arr3
        int res3 = 1;
        for (int i = 1; i < n3; i++) 
        {
            max = Math.max(arr3[i], max);
            if (arr3[i] != arr3[res3 - 1]) 
            {
                arr3[res3] = arr3[i];
                res3++;
            }
        }

        // creating an array for finding frequency
        int[] freq = new int[max + 1];

        // calculating the frequency of
        // all the elements present in
        // all the array
        for (int i = 0; i < res1; i++)
            freq[arr1[i]]++;
        for (int i = 0; i < res2; i++)
            freq[arr2[i]]++;
        for (int i = 0; i < res3; i++)
            freq[arr3[i]]++;

        // iterating till max and
        // whenever the frequency of element
        // will be three we print that element
        for (int i = 0; i <= max; i++)
            if (freq[i] == 3)
                System.out.print(i + " ");
    }
  
    // Driver Code
    public static void main(String[] arg)
    {

        int arr1[] = { 1, 5, 10, 20, 40, 80 };
        int arr2[] = { 6, 7, 20, 80, 100 };
        int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

        commonElements(arr1, arr2, arr3, 6, 5, 8);
    }
}

