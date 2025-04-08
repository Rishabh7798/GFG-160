Non Repeating Character - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/non-repeating-character-1587115620

class Solution {
    static char nonRepeatingChar(String s) {
        int[] freq = new int[26]; // For lowercase English letters
        
        // Count frequencies of characters
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '$'; // If no non-repeating character is found
    }
}
