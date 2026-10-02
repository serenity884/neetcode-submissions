class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        int start = 0;
        backtrack(nums, start, target, slate, result);
        return result;
    }

    public void backtrack(
        int[] nums, int start, int target, List<Integer> slate, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(slate));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            slate.add(nums[i]);
            backtrack(nums, i, target - nums[i], slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}