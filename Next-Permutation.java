import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) { // If such an element is found
            int j = n - 1;
            // Step 2: Find the element just larger than arr[i] from the right
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 4: Reverse the remaining part to get the next permutation
        reverse(arr, i + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases

        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation

            StringBuilder out = new StringBuilder();
            for (int num : arr) {
                out.append(num).append(" ");
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}
