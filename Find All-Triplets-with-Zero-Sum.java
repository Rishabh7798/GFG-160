Find All Triplets with Zero Sum - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/find-all-triplets-with-zero-sum

 class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        // Build map from value to list of indices
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Set<String> seen = new HashSet<>();

        // Try every pair (i, j) and find if there exists k such that i < j < k and arr[i] + arr[j] + arr[k] == 0
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int target = -(arr[i] + arr[j]);
                if (valueToIndices.containsKey(target)) {
                    for (int k : valueToIndices.get(target)) {
                        if (k > j) {
                            String key = i + "," + j + "," + k;
                            if (!seen.contains(key)) {
                                result.add(Arrays.asList(i, j, k));
                                seen.add(key);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
