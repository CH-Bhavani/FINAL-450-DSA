/*





Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> l = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, down = m-1, left = 0, right = n-1, dir = 0;
        while(top<=down && left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++)
                    l.add(matrix[top][i]);
                top++;
                dir=1;
            }
            else if(dir==1){
                for(int i=top;i<=down ;i++){
                    l.add(matrix[i][right]);
                }
                right--;
                dir=2;
                
            }
            else if(dir==2){
                for(int i=right;i>=left;i--){
                    l.add(matrix[down][i]);
                }
                down--;
                dir=3;
            }
            else if(dir==3){
                for(int i=down ;i>=top;i--){
                    l.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }
        }
        return l;

    }
}
