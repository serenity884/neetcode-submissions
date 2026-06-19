class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            prefix[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            postfix[i] = product;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pfix = i > 0 ? prefix[i - 1] : 1;
            int pofix = i < nums.length - 1 ? postfix[i + 1] : 1;
            result[i] = pfix * pofix;
        }
        return result;
    }
}
