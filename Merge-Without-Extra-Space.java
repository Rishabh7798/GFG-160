Merge Without Extra Space - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/merge-two-sorted-arrays-1587115620

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
            System.out.println("~");
        }
    }
}

// User function Template for Java
class Solution {
    public void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < n + m) {
                // Compare elements in array 'a'
                if (i < n && j < n) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
                // Compare elements between arrays 'a' and 'b'
                else if (i < n && j >= n) {
                    if (a[i] > b[j - n]) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                // Compare elements in array 'b'
                else if (i >= n && j >= n) {
                    if (b[i - n] > b[j - n]) {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                i++;
                j++;
            }
            gap = nextGap(gap);
        }
    }

    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2); // Equivalent to Math.ceil(gap/2.0)
    }
}
