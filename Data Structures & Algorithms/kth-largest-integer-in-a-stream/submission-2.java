class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            this.add(n);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
