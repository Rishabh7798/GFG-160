Search in a row-wise sorted matrix - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/search-in-a-row-wise-sorted-matrix

class Solution {
    // Function to search a given number in row-wise sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            // Apply binary search on each row
            int low = 0, high = m - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mat[i][mid] == x) {
                    return true;
                } else if (mat[i][mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
