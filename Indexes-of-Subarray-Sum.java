Indexes of Subarray Sum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/subarray-with-given-sum-1587115621

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, end = 0, sum = 0;
        int n = arr.length;

        while (end <= n) {
            if (sum == target) {
                // Convert to 1-based index
                result.add(start + 1);
                result.add(end);
                return result;
            } else if (sum < target) {
                if (end < n)
                    sum += arr[end];
                end++;
            } else {
                sum -= arr[start];
                start++;
            }
        }

        result.add(-1);
        return result;
    }
}
