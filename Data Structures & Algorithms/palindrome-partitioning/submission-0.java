class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int start, List<String> slate, List<List<String>> result) {
        // We consumed the entire string
        if (start == s.length()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Try every possible substring starting at 'start'
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // Choose
                slate.add(s.substring(start, end + 1));

                // Explore
                backtrack(s, end + 1, slate, result);

                // Undo
                slate.remove(slate.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}