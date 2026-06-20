class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[l] <= nums[mid]) { // left half is the "clean" sorted one
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1; // target in clean left half
                } else {
                    l = mid + 1; // target must be in right half
                }
            } else { // right half is the "clean" sorted one
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1; // target in clean right half
                } else {
                    r = mid - 1; // target must be in left half
                }
            }
        }
        return -1;
    }
}
