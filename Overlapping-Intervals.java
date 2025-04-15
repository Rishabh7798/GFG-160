Overlapping Intervals - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/overlapping-intervals--170633

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> result = new ArrayList<>();

        // Step 1: Sort intervals by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize with first interval
        int[] current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // If current interval overlaps with next one
            if (current[1] >= arr[i][0]) {
                // Merge intervals
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                // No overlap, add current to result and move to next
                result.add(current);
                current = arr[i];
            }
        }

        // Add the last interval
        result.add(current);
        return result;
    }
}
