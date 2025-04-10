Min Chars to Add for Palindrome - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/minimum-characters-to-be-added-at-front-to-make-string-palindrome

class Solution {
    public static int minChar(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String concat = s + "$" + rev;

        int[] lps = computeLPSArray(concat);

        return s.length() - lps[concat.length() - 1];
    }

    // KMP helper to build LPS (Longest Prefix Suffix) array
    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
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

        return lps;
    }
}
