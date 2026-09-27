class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int total = 0;
        int maxL = 0, maxR = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                maxL = Math.max(maxL, height[l]);
                total += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                total += maxR - height[r];
                r--;
            }
        }
        return total;
    }
}
