class HitCounter {
    private static final int WINDOW = 300;

    /** Each node is a distinct timestamp with the number of hits it received. */
    private static final class Node {
        final int timestamp;
        int count;

        Node(int timestamp, int count) {
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    private final Deque<Node> hits = new ArrayDeque<>();
    private int total = 0;

    public HitCounter() {}

    /**
     * Records a hit at {@code timestamp}. Coalesces with the previous hit if it
     * shares the same timestamp.
     *
     * @param timestamp time of the hit, in seconds
     */
    public void hit(int timestamp) {
        if (!hits.isEmpty() && hits.peekLast().timestamp == timestamp) {
            hits.peekLast().count++;
        } else {
            hits.addLast(new Node(timestamp, 1));
        }
        total++;
    }

    /**
     * Returns the number of hits in the past 300 seconds, i.e. in
     * {@code (timestamp - 300, timestamp]}.
     *
     * @param timestamp current time, in seconds
     * @return hit count within the trailing 300-second window
     */
    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peekFirst().timestamp <= timestamp - WINDOW) {
            total -= hits.pollFirst().count;
        }
        return total;
    }
}