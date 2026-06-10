class Solution {
    public int uniquePaths(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n];
    }
}
