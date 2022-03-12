/*

Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence..

*/


class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int n)
	{
	   // add your code here
	   Arrays.sort(arr);
      int count=0,ans=0;
      ArrayList<Integer> a=new ArrayList<>();
      a.add(arr[0]);
      for(int i=1;i<n;i++){
          if(arr[i]!=arr[i-1]) a.add(arr[i]);
          
      }
      for(int i=0;i<a.size();i++){
          if(i>0 && a.get(i)==a.get(i-1)+1) count++;
          else
            count=1;
          ans=Math.max(ans,count);
      }
      return ans;
	}
}



// method -2



    static int findLongestConseqSubseq(int arr[], int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) 
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) 
            {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }






// method -3


public class Longset_Sub
{
    // return the length of the longest
    // subsequence of consecutive integers
    static int findLongestConseqSubseq(int arr[], int N)
    {

        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) 
        {
            // adding element from 
            // array to PriorityQueue
            pq.add(arr[i]);
        }
        
        // Storing the first element 
        // of the Priority Queue
        // This first element is also 
        // the smallest element
        int prev = pq.poll();
        
        // Taking a counter variable with value 1
        int c = 1;
        
        // Storing value of max as 1
        // as there will always be
        // one element
        int max = 1;

        for (int i = 1; i < N; i++) 
        {
            // check if current peek 
            // element minus previous
            // element is greater then 
            // 1 This is done because
            // if it's greater than 1 
            // then the sequence
            // doesn't start or is broken here
            if (pq.peek() - prev > 1) 
            {
                // Store the value of counter to 1
                // As new sequence may begin
                c = 1;
                
                // Update the previous position with the
                // current peek And remove it
                prev = pq.poll();
            }
            
            // Check if the previous
            //  element and peek are same
            else if (pq.peek() - prev == 0) 
            {
                // Update the previous position with the
                // current peek And remove it
                prev = pq.poll();
            }
            // if the difference 
            // between previous element and peek is 1
            else 
            {
                // Update the counter
                // These are consecutive elements
                c++;
                 
                // Update the previous position
                //  with the current peek And remove it
                prev = pq.poll();
            }

            // Check if current longest 
            // subsequence is the greatest
            if (max < c) 
            {
                // Store the current subsequence count as
                // max
                max = c;
            }
        }

        return max;
    }


