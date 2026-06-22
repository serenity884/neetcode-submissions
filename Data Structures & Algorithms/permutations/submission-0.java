class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], slate, result);
        return result;
    }

    public void backtrack(
        int[] nums, boolean[] used, List<Integer> slate, List<List<Integer>> result) {
        if (slate.size() == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // checks the FULL set of used indices, not just one
            used[i] = true;
            slate.add(nums[i]);
            backtrack(nums, used, slate, result);
            slate.remove(slate.size() - 1);
            used[i] = false;
        }
    }
}
