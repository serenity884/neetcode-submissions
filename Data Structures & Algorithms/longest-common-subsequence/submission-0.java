class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text2;
            text2 = text1;
            text1 = temp;
        }
        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i < m + 1; i++) {
            int prevDiag = 0;
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[j]; // dp[i-1][j], save before overwrite
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prevDiag + 1;
                }
                dp[j] = Math.max(dp[j], dp[j - 1]);
                prevDiag = temp;
            }
        }
        return dp[n];
    }
}
