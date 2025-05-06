Intersection of Two arrays with Duplicate Elements

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashSet<Integer> setA = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Add all elements of a[] into setA
        for (int num : a) {
            setA.add(num);
        }

        // Iterate through b[], check if element exists in setA
        for (int num : b) {
            if (setA.contains(num)) {
                result.add(num);
                setA.remove(num); // remove to ensure only one occurrence
            }
        }

        return result;
    }
}
