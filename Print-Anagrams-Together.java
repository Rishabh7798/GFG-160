Print Anagrams Together - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/print-anagrams-together

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Using LinkedHashMap to maintain insertion order
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        
        for (String word : arr) {
            // Convert word to character array, sort it, then convert back to string
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            // Add the word to the correct group in the map
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        
        // Convert map values to a list
        return new ArrayList<>(map.values());
    }
}
