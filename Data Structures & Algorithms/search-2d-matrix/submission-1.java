class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = matrix[mid / n][mid % n];
            if (target == val) {
                return true;
            } else if (target < val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
