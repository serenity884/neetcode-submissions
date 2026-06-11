class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(
                    nums[i - k - 1]); // slide window: drop the element that fell out of range
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}