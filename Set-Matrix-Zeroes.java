Set Matrix Zeroes - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/set-matrix-zeroes

//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        for (int i = 0; i < n; i++){
            if (mat[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int j = 0; j < m; j++){
            if (mat[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < n; i++){
            if (mat[i][0] == 0){
                for (int j = 1; j < m; j++){
                    mat[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < m; j++){
            if (mat[0][j] == 0){
                for (int i = 1; i < n; i++){
                    mat[i][j] = 0;
                }
            }
        }
        
        if(firstColHasZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < m; j++){
                mat[0][j] = 0;
            }
        }
    }    
}
