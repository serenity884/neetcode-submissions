class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s = nums1.length - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[s] = nums2[n];
                n--;
            } else {
                nums1[s] = nums1[m];
                m--;
            }
            s--;
        }

        while (n >= 0) {
            nums1[s] = nums2[n];
            n--;
            s--;
        }
    }
}