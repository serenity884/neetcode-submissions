class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0)
            return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            maxHeap.offer(s);
        }
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x == y) {
                continue;
            } else if (x > y) {
                y = x - y;
                maxHeap.offer(y);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
