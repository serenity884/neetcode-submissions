class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            if (!hashSet.add(n)) {
                return true;
            }
        }
        return false;
    }
}