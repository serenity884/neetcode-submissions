class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int result = 0;
        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            // (window size) - (most frequent char's count) = chars that need replacing
            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
