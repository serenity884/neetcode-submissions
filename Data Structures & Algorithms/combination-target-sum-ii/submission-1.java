class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    public void backtrack(
        int[] candidates, int start, int target, List<Integer> slate, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(slate));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i] || (i > start && candidates[i] == candidates[i - 1])) {
                continue;
            }
            slate.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}
