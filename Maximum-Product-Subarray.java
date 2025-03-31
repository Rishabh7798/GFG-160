Maximum Product Subarray - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/maximum-product-subarray3604

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int maxProd = arr[0], minProd = arr[0], result = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                // Swap max and min if the current element is negative
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            // Compute new max and min products ending at index i
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            
            // Update the global maximum product
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}
