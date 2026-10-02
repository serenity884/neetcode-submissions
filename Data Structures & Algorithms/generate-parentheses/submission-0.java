class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, new StringBuilder(), 0, 0, result);
        return result;
    }

    private void backtrack(int n, StringBuilder slate, int open, int close, List<String> result) {
        // We used all n pairs
        if (slate.length() == 2 * n) {
            result.add(slate.toString());
            return;
        }

        // We can add "(" as long as we haven't used all n
        if (open < n) {
            slate.append("(");
            backtrack(n, slate, open + 1, close, result);
            slate.deleteCharAt(slate.length() - 1); // undo
        }

        // We can add ")" only if there is an unmatched "("
        if (close < open) {
            slate.append(")");
            backtrack(n, slate, open, close + 1, result);
            slate.deleteCharAt(slate.length() - 1); // undo
        }
    }
}