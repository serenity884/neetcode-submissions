class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int result = 1;
        int len = 1;
        int prevSign = 0; // 0 = none/equal, 1 = increasing, -1 = decreasing

        for (int i = 1; i < n; i++) {
            int sign;
            if (arr[i-1] < arr[i]) sign = 1;
            else if (arr[i-1] > arr[i]) sign = -1;
            else sign = 0;

            if (sign == 0) {
                len = 1;              // equal pair breaks everything
            } else if (sign == prevSign) {
                len = 2;              // alternation broken, but this pair starts fresh
            } else {
                len++;                // alternation continues
            }
            prevSign = sign;
            result = Math.max(result, len);
        }
        return result;
    }
}