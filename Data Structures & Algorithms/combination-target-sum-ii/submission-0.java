class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(
        int[] candidates, int target, int start, List<Integer> slate, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1])
                continue; // skip duplicates at THIS level
            slate.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}
