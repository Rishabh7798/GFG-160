Max Circular Subarray Sum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/max-circular-subarray-sum-1587115620

class Solution {
  // a: input array
  // n: size of array
  // Function to find maximum circular subarray sum.
      // Function to find maximum circular subarray sum
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        
        // Step 1: Find max subarray sum using standard Kadane's algorithm
        int maxKadane = kadane(arr);
        
        // Step 2: Find total array sum and min subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert array elements to find min subarray sum
        }
        
        // Step 3: Find min subarray sum using Kadane's on the inverted array
        int minKadane = kadane(arr);
        int maxCircular = totalSum + minKadane; // Restore original values by adding totalSum
        
        // Step 4: Handle case where all elements are negative
        if (maxCircular == 0) return maxKadane;
        
        // Step 5: Return the maximum of both cases
        return Math.max(maxKadane, maxCircular);
    }
    
    // Standard Kadane's algorithm to find max subarray sum
    private int kadane(int arr[]) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
