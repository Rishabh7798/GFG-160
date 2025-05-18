Count distinct elements in every window - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/count-distinct-elements-in-every-window

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int outElement = arr[i - k];
            freqMap.put(outElement, freqMap.get(outElement) - 1);
            if (freqMap.get(outElement) == 0) {
                freqMap.remove(outElement);
            }

            // Add the new element
            int inElement = arr[i];
            freqMap.put(inElement, freqMap.getOrDefault(inElement, 0) + 1);

            result.add(freqMap.size());
        }

        return result;
    }
}
