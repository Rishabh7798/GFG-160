Longest Consecutive Subsequence - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/longest-consecutive-subsequence2449

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        // Add all elements to the set
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        // Iterate over the array
        for (int num : arr) {
            // Check if it is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the maximum length
                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }
}
