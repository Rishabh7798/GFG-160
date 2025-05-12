Count all triplets with given sum in sorted array - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/count-all-triplets-with-given-sum-in-sorted-array

class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    // If duplicates exist for left and right
                    if (arr[left] == arr[right]) {
                        int len = right - left + 1;
                        count += (len * (len - 1)) / 2; // nC2 pairs
                        break;
                    } else {
                        // Count how many times arr[left] and arr[right] repeat
                        int countLeft = 1, countRight = 1;

                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            countLeft++;
                            left++;
                        }
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            countRight++;
                            right--;
                        }

                        count += countLeft * countRight;
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
