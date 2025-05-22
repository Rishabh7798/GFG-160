Equilibrium Point - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/equilibrium-point-1587115620

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];  // totalSum now becomes right sum

            if (leftSum == totalSum) {
                return i;  // 0-based index
            }

            leftSum += arr[i];
        }

        return -1;  // No equilibrium index found
    }
}
