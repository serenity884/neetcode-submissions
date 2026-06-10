class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, 1);
        Arrays.fill(curr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curr[j] = curr[j - 1] + prev[j];
            }
            prev = curr;
        }
        return curr[n - 1];
    }
}
