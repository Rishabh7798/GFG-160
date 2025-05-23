Longest Subarray with Sum K - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/longest-sub-array-with-sum-k0809

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store (prefixSum, earliestIndex)
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: entire subarray from 0 to i has sum k
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Case 2: there exists a prefixSum that satisfies prefixSum - k
            if (map.containsKey(prefixSum - k)) {
                int prevIndex = map.get(prefixSum - k);
                maxLen = Math.max(maxLen, i - prevIndex);
            }

            // Only put prefixSum in map if it's not already there
            // because we want the longest subarray, so earliest index is best
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
