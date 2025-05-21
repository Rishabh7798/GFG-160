Container With Most Water

// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate height and width
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;

            // Calculate area and update maxArea
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
