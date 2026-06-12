class Solution {
    public int trap(int[] height) {
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                water += (leftMax - height[l]);
                 l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                water += (rightMax - height[r]);
                 r--;
            }
        }
        return water;
    }
}
