Two Sum - Pair with Given Sum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/key-pair5616

// User function Template for Java
class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
