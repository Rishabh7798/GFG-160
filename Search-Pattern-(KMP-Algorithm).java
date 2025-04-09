Search Pattern (KMP-Algorithm) - 

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Step 1: Build LPS (Longest Prefix Suffix) array
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);

        // Step 2: Search using LPS
        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found at index (i - j)
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return result;
    }

    // Utility function to build the LPS array
    void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0; // length of the previous longest prefix suffix
        lps[0] = 0; // lps[0] is always 0

        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
