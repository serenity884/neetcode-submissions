class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(
        int[] nums, boolean[] used, List<Integer> slate, List<List<Integer>> result) {
        if (slate.size() == nums.length) {
            result.add(new ArrayList<Integer>(slate));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            slate.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, slate, result);
            slate.remove(slate.size() - 1);
            used[i] = false;
        }
    }
}
