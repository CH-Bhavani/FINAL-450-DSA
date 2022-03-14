/*
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

*/





// method -1



// Java implementation of the approach
class GFG{

// Function to return the maximum
// water that can be stored
public static int maxWater(int[] arr, int n) 
{
    
    // To store the maximum water
    // that can be stored
    int res = 0;

    // For every element of the array
    // except first and last element
    for(int i = 1; i < n - 1; i++)
    {
        
        // Find maximum element on its left
        int left = arr[i];
        for(int j = 0; j < i; j++)
        {
            left = Math.max(left, arr[j]);
        }

        // Find maximum element on its right
        int right = arr[i];
        for(int j = i + 1; j < n; j++)
        {
            right = Math.max(right, arr[j]);
        }

        // Update maximum water value
        res += Math.min(left, right) - arr[i];
    }
    return res;
}

// Driver code
public static void main(String[] args)
{
    int[] arr = { 0, 1, 0, 2, 1, 0, 
                  1, 3, 2, 1, 2, 1 };
    int n = arr.length;

    System.out.print(maxWater(arr,n));
}
}


// method -2




// Java program to find maximum amount of water that can
// be trapped within given set of bars.

class Test {
    static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    // Method for maximum amount of water
    static int findWater(int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {

        System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
    }
}


// method-3



// JAVA Code For Trapping Rain Water
import java.util.*;

class GFG {

    static int findWater(int arr[], int n)
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1,
                      3, 2, 1, 2, 1 };
        int n = arr.length;

        System.out.println("Maximum water that "
                           + "can be accumulated is "
                           + findWater(arr, n));
    }
}

