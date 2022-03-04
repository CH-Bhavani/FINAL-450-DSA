/*

Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy
Last Updated : 03 Mar, 2022
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.

*/


//method -1   o(n)


import java.util.Arrays;

public class sort0_1 {
    public static void main(String[] args) {
        int[] arr = {23, 4, -7, 30, -85, -4, 72};
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                if(i!=j){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}




//method -2  two pointer approach



import java.util.Arrays;

public class sort0_1 {
    public static void main(String[] args) {
        int[] arr = {-23, 4, -7, 30, -85, -4, 72,-5,43};
        int left=0,right=arr.length-1;
        while(left<=right){
            if(arr[left]<0 && arr[right]<0) left++;
            else if(arr[left]>0 && arr[right]<0){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            else if(arr[right]>0 && arr[left]<0){
                left++;
                right--;
            }
            else{
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}



//method -3    Dutch National flag algorithm



import java.util.Arrays;

public class sort0_1 {
    public static void main(String[] args) {
        int[] arr = {-23, 4, 30, -85, -4, 72,-5,43};
        int low=0,high=arr.length-1;
        while(low<=high){
            if(arr[low]<=0)
                low++;
            else
                swap(arr,low,high--);
        }
        System.out.println(Arrays.toString(arr));
    }
        public static  void swap( int[] arr,int l,int h)
    {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }

}

