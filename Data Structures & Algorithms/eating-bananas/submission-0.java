class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int result = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int total = 0;
            for (int p : piles) {
                total += (p + mid - 1) / mid;
                if (total > h)
                    break;
            }
            if (total <= h) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
