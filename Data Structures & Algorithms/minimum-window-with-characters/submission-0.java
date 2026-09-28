class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int[] f = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            f[c]++;

            // Current window contains everything required by t
            while (isMatch(freq, f)) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                // Shrink from left
                f[s.charAt(l)]--;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    boolean isMatch(int[] required, int[] window) {
        for (int i = 0; i < 128; i++) {
            if (window[i] < required[i]) {
                return false;
            }
        }

        return true;
    }
}