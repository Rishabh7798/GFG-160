Second Largest - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735

// User function Template for Java
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr){
            if (num > largest){
                secondLargest = largest;
                largest = num;
            }
            else if (num > secondLargest && num < largest){
                secondLargest = num;
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? - 1 : secondLargest;
    }
}
