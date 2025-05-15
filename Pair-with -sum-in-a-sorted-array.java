Pair with given sum in a sorted array - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/pair-with-given-sum-in-a-sorted-array4940

class Solution {

    int countPairs(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2; // nC2 pairs
                    break; // all further pairs will be duplicates
                } else {
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

        return count;
    }
}
