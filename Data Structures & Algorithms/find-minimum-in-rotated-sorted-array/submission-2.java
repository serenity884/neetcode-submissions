class Solution {
    public int findMin(int[] nums) {
        return find(0, nums.length - 1, nums);
    }

    public int find(int l, int r, int[] nums) {
        if (l == r)
            return nums[l];

        int mid = l + (r - l) / 2;

        if (nums[mid] > nums[r]) {
            return find(mid + 1, r, nums); // wrap point is to the right of mid
        } else {
            return find(l, mid, nums); // wrap point is at-or-left of mid; KEEP mid
        }
    }
}