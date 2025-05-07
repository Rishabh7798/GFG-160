Union of Arrays with Duplicates - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/union-of-two-arrays3538

class Solution {
    public static int findUnion(int a[], int b[]) {
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements of array a to the set
        for (int num : a) {
            unionSet.add(num);
        }

        // Add all elements of array b to the set
        for (int num : b) {
            unionSet.add(num);
        }

        // Size of the set is the number of unique elements
        return unionSet.size();
    }
}
