class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] f = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            if (r < s1.length()) {
                f[s2.charAt(r) - 'a']++;
                continue;
            }
            if (isMatch(freq, f)) {
                return true;
            }

            if ((r - l) >= s1.length()) {
                f[s2.charAt(l) - 'a']--;
                f[s2.charAt(r) - 'a']++;
            }
            l++;
        }
        return isMatch(freq, f);
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
