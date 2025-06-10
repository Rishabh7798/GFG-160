Permutations of a String - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/recursion-and-backtracking-gfg-160/problem/permutations-of-a-given-string2041

import java.util.*;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder current, ArrayList<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;
            // Skip duplicates
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(chars[i]);
            backtrack(chars, used, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
            used[i] = false;
        }
    }
}
