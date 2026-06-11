class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;

        for (int n : nums) {
            currMax = Math.max(currMax, 0) + n;
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(currMin, 0) + n;
            minSum = Math.min(currMin, minSum);
            total += n;
        }
        if (maxSum < 0)
            return maxSum; // <-- needed for all-negative arrays
        return Math.max(maxSum, total - minSum);
    }
}