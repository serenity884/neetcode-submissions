class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }
        int max = 0;
        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;
                int curr = n;
                while (numSet.contains(curr + 1)) {
                    curr++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
