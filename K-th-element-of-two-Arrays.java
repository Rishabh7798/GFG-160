K-th element of two Arrays - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/problem/k-th-element-of-two-sorted-array1317

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length;
        
        // Ensure a is the smaller array
        if (n > m) return kthElement(b, a, k);

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int l1 = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int l2 = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int r1 = (cutA == n) ? Integer.MAX_VALUE : a[cutA];
            int r2 = (cutB == m) ? Integer.MAX_VALUE : b[cutB];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return -1; 
    }
}
