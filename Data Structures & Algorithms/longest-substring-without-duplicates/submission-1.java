class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!seen.add(s.charAt(i))) {
                seen.remove(s.charAt(j));
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
