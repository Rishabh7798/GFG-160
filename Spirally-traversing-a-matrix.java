Spirally traversing a matrix - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/spirally-traversing-a-matrix-1587115621

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (mat == null || mat.length == 0)
            return result;
        
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        
        while (top <= bottom && left <= right) {
            
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;
            
            // Traverse from right to left (if there is a new row)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top (if there is a new column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
