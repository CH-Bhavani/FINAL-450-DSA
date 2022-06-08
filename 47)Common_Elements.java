/*


Common elements in all rows of a given matrix

Difficulty Level : Medium
Last Updated : 08 Apr, 2022
Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.
Example: 

Input:
mat[4][5] = {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };

Output: 
1 8 or 8 1
8 and 1 are present in all rows.


*/




import java.util.*;
public class CommonElements {
    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        int m= mat.length;
        int n=mat[0].length;
        Common(mat,m,n);
    }
    public static  void Common(int[][] mat,int m,int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int j = 0; j < n; j++)
            mp.put(mat[0][j], 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i) {
                    mp.put(mat[i][j], mp.get(mat[i][j]) + 1);
                    if (mp.get(mat[i][j]) == m - 1)
                        System.out.println(mat[i][j]);
                }
            }
        }
    }
}
