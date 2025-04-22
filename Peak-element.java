Peak element - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/peak-element

class Solution {

    public int peakElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftOK = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOK = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);

            if (leftOK && rightOK) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; 
    }
}
