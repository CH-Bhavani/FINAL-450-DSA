/*

Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not. Both the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.
 

Example 1:

Input:
a1[] = {11, 1, 13, 21, 3, 7}
a2[] = {11, 3, 7, 1}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 2:

Input:
a1[] = {1, 2, 3, 4, 5, 6}
a2[] = {1, 2, 4}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 3:

Input:
a1[] = {10, 5, 2, 23, 19}
a2[] = {19, 5, 3}
Output:
No
Explanation:
a2[] is not a subset of a1[]

*/







class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Set<Long> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(a1[i]);
        }
        int s=hs.size();
        for(int i=0;i<m;i++){
            hs.add(a2[i]);
        }
        return hs.size()==s?"Yes":"No";
        
    }
}




// method -2



class GFG {

    /* Return true if arr2[] is a subset 
    of arr1[] */
    static boolean isSubset(int arr1[],
                            int arr2[], 
                            int m, int n)
    {
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (arr2[i] == arr1[j])
                    break;

            /* If the above inner loop 
            was not broken at all then
            arr2[i] is not present in
            arr1[] */
            if (j == m)
                return false;
        }

        /* If we reach here then all
        elements of arr2[] are present
        in arr1[] */
        return true;
    }

  
  
  
  
  
  
  
  // method -3
  
  
  
  // Java program to find whether an array
// is subset of another array
class Main {
    /* Return true if arr2[] is a subset of arr1[] */
    static boolean isSubset(int arr1[],
                            int arr2[], int m,
                            int n)
    {
        int i = 0;

        sort(arr1, 0, m - 1);
        for (i = 0; i < n; i++) {
            if (binarySearch(arr1, 
                             0, m - 1, 
                             arr2[i]) == -1)
                return false;
        }

        /* If we reach here then all elements of arr2[]
          are present in arr1[] */
        return true;
    }

    /* FOLLOWING FUNCTIONS ARE ONLY 
    FOR SEARCHING AND
     * SORTING PURPOSE */
    /* Standard Binary Search function*/
    static int binarySearch(int arr[], 
                            int low, int high,
                            int x)
    {
        if (high >= low) 
        {
            /*low + (high - low)/2;*/
            int mid = (low + high)
                      / 2; 

            /* Check if arr[mid] is the first occurrence of
            x. arr[mid] is first occurrence if x is one of
            the following is true: (i)  mid == 0 and
            arr[mid] == x (ii) arr[mid-1] < x and arr[mid]
            == x
         */
            if ((mid == 0 || x > arr[mid - 1])
                && (arr[mid] == x))
                return mid;
            else if (x > arr[mid])
                return binarySearch(arr, 
                                    (mid + 1), high,
                                    x);
            else
                return binarySearch(arr, low, 
                                    (mid - 1), x);
        }
        return -1;
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
      
        for (int j = low; j < high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) 
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 3, 7, 1 };

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.print("arr2[] is subset of arr1[] ");
        else
            System.out.print(
                "arr2[] is not a subset of arr1[]");
    }
}
  
  
  
  
  // method --4
  
  
  
  
// Java code to find whether an array is subset of
// another array
import java.util.Arrays;
class GFG 
{
    /* Return true if arr2[] is a subset of arr1[] */
    static boolean isSubset(int arr1[], 
                            int arr2[], int m,
                            int n)
    {
        int i = 0, j = 0;

        if (m < n)
            return false;

        Arrays.sort(arr1); // sorts arr1
        Arrays.sort(arr2); // sorts arr2

        while (i < n && j < m) {
            if (arr1[j] < arr2[i])
                j++;
            else if (arr1[j] == arr2[i]) {
                j++;
                i++;
            }
            else if (arr1[j] > arr2[i])
                return false;
        }

        if (i < n)
            return false;
        else
            return true;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 3, 7, 1 };

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");
    }
}

  
  
  
  
  // method -5
  
  
  // Java code to find whether an array is subset of
// another array
import java.util.HashSet;
class GFG 
{
    /* Return true if arr2[] is a subset of arr1[] */
    static boolean isSubset(int arr1[], 
                            int arr2[], int m,
                            int n)
    {
        HashSet<Integer> hset = new HashSet<>();

        // hset stores all the values of arr1
        for (int i = 0; i < m; i++) {
            if (!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }

        // loop to check if all elements
        //  of arr2 also lies in arr1
        for (int i = 0; i < n; i++) 
        {
            if (!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 3, 7, 1 };

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println(
                "arr2 is not a subset of arr1");
    }
}
// This code is contributed by Kamal Rawal
