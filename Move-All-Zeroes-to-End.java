Move All Zeroes to End - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751

// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0; // Pointer for the position of the next non-zero element
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Swap the non-zero element with the element at nonZeroIndex
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                
                // Move the nonZeroIndex forward
               nonZeroIndex++;
            }
        }
    }
}
