class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            maxHeap.offer(s);
        }
        while (maxHeap.size() > 1) {
            int x1 = maxHeap.poll();
            int x2 = maxHeap.poll();
            if (x1 == x2) {
                continue;
            } else {
                maxHeap.offer(Math.abs(x1 - x2));
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
