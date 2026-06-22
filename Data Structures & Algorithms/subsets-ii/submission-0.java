class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> slate, List<List<Integer>> result) {
        result.add(new ArrayList<>(slate));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            slate.add(nums[i]);
            backtrack(nums, i + 1, slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}
