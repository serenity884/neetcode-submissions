class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int[] f = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int l = 0;

        for (int r = 0; r < s2.length(); r++) {
            // Add current character to window
            f[s2.charAt(r) - 'a']++;

            // If window becomes too large, remove left character
            if (r - l + 1 > s1.length()) {
                f[s2.charAt(l) - 'a']--;
                l++;
            }

            // Only compare when window size == s1.length()
            if (r - l + 1 == s1.length() && isMatch(count, f)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isMatch(int[] srcF, int[] resF) {
        for (int i = 0; i < 26; i++) {
            if (srcF[i] != resF[i]) {
                return false;
            }
        }
        return true;
    }
}