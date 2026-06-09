class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, int remainingTarget, List<Integer> slate,
        List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remainingTarget)
                continue;
            slate.add(nums[i]);
            backtrack(nums, i, remainingTarget - nums[i], slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}
