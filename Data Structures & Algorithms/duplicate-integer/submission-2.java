class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int n : nums) {
            if (seen.get(n) != null) {
                return true;
            }
            seen.put(n, n);
        }
        return false;
    }
}