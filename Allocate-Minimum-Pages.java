Allocate Minimum Pages - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/allocate-minimum-number-of-pages0937

class Solution {
    public static int findPages(int[] arr, int k) {
        if (arr.length < k) return -1;  // Not enough books to assign at least one to each student

        int low = getMax(arr);
        int high = getSum(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int k, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                studentCount++;
                currentSum = pages;

                if (studentCount > k) return false;
            } else {
                currentSum += pages;
            }
        }

        return true;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
