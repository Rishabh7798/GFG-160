Sorted and Rotated Minimum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/minimum-element-in-a-sorted-and-rotated-array3611

// User function Template for Java
class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the high, min must be in right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Else the min lies in left half including mid
                high = mid;
            }
        }

        // After the loop, low == high and pointing to the smallest element
        return arr[low];
    }
}
