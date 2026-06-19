class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int area = 0;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            area = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(area, maxArea);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
