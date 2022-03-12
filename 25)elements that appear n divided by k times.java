/*


Given an array of size n, find all elements in array that appear more than n/k times. For example, 
if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. 
Note that size of array is 8 (or n = 8), so we need to find all e
*/


// method -1



import java.util.*;
 
public class Main
 
{
    public static void morethanNdK(int a[], int n, int k)
    {
        int x = n / k;
        
        // Hash map initialization
        HashMap<Integer, Integer> y = new HashMap<>();
       
        // count the frequency of each element.
        for (int i = 0; i < n; i++)
        {
            // is element doesn't exist in hash table
            if (!y.containsKey(a[i]))
                y.put(a[i], 1);
           
           
            // if element does exist in the hash table
            else
            {
                int count = y.get(a[i]);
                y.put(a[i], count + 1);
            }
        }
 
        // iterate over each element in the hash table
        // and check their frequency, if it is more than
        // n/k, print it.
        for (Map.Entry m : y.entrySet())
        {
            Integer temp = (Integer)m.getValue();
            if (temp > x)
                System.out.println(m.getKey());
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
 
        int a[] = new int[] { 1, 1, 2, 2, 3, 5, 4,
                              2, 2, 3, 1, 1, 1 };
        int n = 12;
        int k = 4;
        morethanNdK(a, n, k);
    }
}




// method -2



import java.util.*;
 
class GFG {
 
    // Function to find the number of array
    // elements with frequency more than n/k times
    static void printElements(int arr[], int n, int k)
    {
 
        // Calculating n/k
        int x = n / k;
 
        // Counting frequency of every
        // element using Counter
        TreeMap<Integer, Integer> mp
            = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            mp.put(arr[i],
                   mp.getOrDefault(arr[i], 0) + 1);
 
        // Traverse the map and print all
        // the elements with occurrence
        // more than n/k times
        for (Map.Entry m:mp.entrySet()) {
            if ((int)m.getValue() > x)
              System.out.println(m.getKey());
        }
    }
 
  // Driver code
    public static void main(String[] args)
    {
        int arr[]
            = { 1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1 };
        int n = arr.length;
        int k = 4;
 
        printElements(arr, n, k);
         
    }
}
