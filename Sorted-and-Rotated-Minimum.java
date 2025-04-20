Sorted and Rotated Minimum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/minimum-element-in-a-sorted-and-rotated-array3611

// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        // If the array is not rotated at all
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the minimum element
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            // Check if mid+1 is the minimum element
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // Decide which side to go
            if (arr[mid] >= arr[low]) {
                // Left half is sorted, go right
                low = mid + 1;
            } else {
                // Right half is sorted, go left
                high = mid - 1;
            }
        }

        return -1; // Should never reach here if input is valid
    }
}
