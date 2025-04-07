Anagram - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/anagram-1587115620

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are different, they can't be anagrams
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];

        // Increment for s1 and decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
