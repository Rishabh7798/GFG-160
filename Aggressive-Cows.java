Aggressive Cows - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/aggressive-cows

// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);  // Step 1: Sort the stalls

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;       // Update result as this distance is possible
                low = mid + 1;      // Try for a bigger minimum distance
            } else {
                high = mid - 1;     // Try for a smaller minimum distance
            }
        }

        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int count = 1;  // Place the first cow in the first stall
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= minDist) {
                count++;
                lastPos = stalls[i];
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
