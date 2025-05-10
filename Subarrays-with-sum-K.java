Subarrays with sum K - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/subarrays-with-sum-k

class Solution {
    public int countSubarrays(int arr[], int k) {
        // HashMap to store prefixSum frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Initialize with 0 sum occurring once
        prefixSumMap.put(0, 1);

        for (int num : arr) {
            prefixSum += num;

            // Check if (prefixSum - k) is in map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            // Update prefixSum frequency
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
