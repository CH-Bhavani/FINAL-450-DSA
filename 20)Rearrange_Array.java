/*Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
Difficulty Level : Medium
Last Updated : 30 Dec, 2021
Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance. 
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

Examples : 

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}


*/




public class RearrangeArray {
    void rightrotate(int arr[], int n, int outofplace,
                     int cur)
    {
        int temp=arr[cur];
        for(int i=cur;i>outofplace;i--){
            arr[i]=arr[i-1];
        }
        arr[outofplace]=temp;
    }

    void rearrange(int arr[], int n) {
        int outofIndex = -1;
        for (int ind = 0; ind < n; ind++) {
            if (outofIndex >= 0) {
                if ((arr[ind] >= 0 && arr[outofIndex] < 0) || (arr[ind] < 0 && arr[outofIndex] >= 0))
                { rightrotate(arr, n, outofIndex, ind);
                if (ind - outofIndex >= 2)
                    outofIndex += 2;
                else
                    outofIndex = -1;
            }
            }
            if (outofIndex == -1) {
                if (((arr[ind] >= 0) && ((ind & 0x01) == 0)) || ((arr[ind] < 0) && (ind & 0x01) == 1))
                    outofIndex = ind;
            }
        }
    }
    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
    public static void main(String[] args)
    {
        RearrangeArray rearrange = new RearrangeArray();
        int arr[] = { -5, -2, 5, 2, 4,
                7, 1, 8, 0, -8 };
        int n = arr.length;

        System.out.println("Given array is ");
        rearrange.printArray(arr, n);

        rearrange.rearrange(arr, n);

        System.out.println("RearrangeD array is ");
        rearrange.printArray(arr, n);
    }
}
