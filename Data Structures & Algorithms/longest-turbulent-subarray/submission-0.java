class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = 1;
        int maxLen = 1;
        int prevSign = 0;
        for (int r = 1; r < arr.length; r++) {
            int sign;
            if (arr[r - 1] < arr[r])
                sign = 1;
            else if (arr[r - 1] > arr[r])
                sign = -1;
            else
                sign = 0;

            if (sign == 0) {
                len = 1;
            } else if (sign == prevSign) {
                len = 2;
            } else {
                len++;
            }
            prevSign = sign;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}