class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (seen.get(rem) != null) {
                return new int[] {seen.get(rem), i};
            }
            seen.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
