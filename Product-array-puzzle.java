Product array puzzle - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/product-array-puzzle4525

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];

        // Step 1: Calculate left product for each index
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        // Step 2: Multiply with right product while traversing from end
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct *= arr[i];
        }

        return res;
    }
}
