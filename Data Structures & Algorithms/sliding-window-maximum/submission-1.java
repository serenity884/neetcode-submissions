class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int r = 0; r < nums.length; r++) {

            // Remove indices outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= r - k) {
                deque.pollFirst();
            }

            // Remove smaller values from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }

            deque.offerLast(r);

            // Window has reached size k
            if (r >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}