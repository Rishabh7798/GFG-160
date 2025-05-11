Count Subarrays with given XOR - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/count-subarray-with-given-xor

class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int xor = 0;
        long count = 0;
        
        for (int num : arr) {
            xor ^= num;
            
            // If current xor is equal to k, it means one subarray from index 0 to current gives k
            if (xor == k) {
                count++;
            }

            // If there exists a prefix with xor ^ k, then a subarray exists with xor = k
            int required = xor ^ k;
            count += freq.getOrDefault(required, 0);

            // Store the current xor in map
            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
