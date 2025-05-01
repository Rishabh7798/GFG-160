Search in a sorted Matrix - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/search-in-a-matrix-1587115621

class Solution {
    // Function to search a given number in strictly sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == x) {
                return true;
            } else if (mat[row][col] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
