class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] results = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            minHeap.offer(p);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int i = 0;
        while (!minHeap.isEmpty()) {
            results[i++] = minHeap.poll();
        }
        return results;
    }
}
