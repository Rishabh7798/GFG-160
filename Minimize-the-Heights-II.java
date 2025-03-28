Minimize the Heights II - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/minimize-the-heights3351

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0; // If only one tower, difference is 0
        
        Arrays.sort(arr); // Sort the array
        
        int minHeight = arr[0];
        int maxHeight = arr[n - 1];
        int minDiff = maxHeight - minHeight; // Initial difference
        
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue; // Ensure height doesn't go negative
            
            int newMin = Math.min(arr[0] + k, arr[i] - k);
            int newMax = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            
            minDiff = Math.min(minDiff, newMax - newMin);
        }
        
        return minDiff;
    }
}
