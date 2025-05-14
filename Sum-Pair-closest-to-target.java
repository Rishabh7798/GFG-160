Sum Pair closest to target

// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr.length < 2) return result;

        Arrays.sort(arr); // Sort array for two-pointer approach

        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);

            if (diff < closestDiff) {
                // Better (closer) pair found
                closestDiff = diff;
                maxAbsDiff = Math.abs(arr[left] - arr[right]);
                result = Arrays.asList(arr[left], arr[right]);
            } else if (diff == closestDiff) {
                // Same closeness to target; check for max absolute difference
                int currAbsDiff = Math.abs(arr[left] - arr[right]);
                if (currAbsDiff > maxAbsDiff) {
                    maxAbsDiff = currAbsDiff;
                    result = Arrays.asList(arr[left], arr[right]);
                }
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
