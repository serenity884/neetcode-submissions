class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;
        while (l < r) {
            int water = Math.min(heights[l], heights[r]) * Math.abs(l - r);
            max = Math.max(water, max);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
