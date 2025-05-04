Count pairs with given sum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/count-pairs-with-given-sum--150253

class Solution {
    int countPairs(int arr[], int target) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // Check how many times the complement has occurred before
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }

            // Update the frequency of the current number
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
