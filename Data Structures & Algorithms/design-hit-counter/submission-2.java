class HitCounter {
    private final int WINDOW = 300;

    Bucket[] buckets = null;
    public static final class Bucket {
        final AtomicInteger second = new AtomicInteger(-1);
        final LongAdder count = new LongAdder();
    }
    public HitCounter() {
        buckets = new Bucket[WINDOW];
        for (int i = 0; i < WINDOW; i++) buckets[i] = new Bucket();
    }

    public void hit(int timestamp) {
        Bucket bucket = buckets[timestamp % WINDOW];
        if (bucket.second.getAndSet(timestamp) != timestamp) {
            bucket.count.reset();
        }
        bucket.count.increment();
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (Bucket bucket : buckets) {
            int second = bucket.second.get();
            if (second > timestamp - WINDOW && second <= timestamp) {
                total += bucket.count.sum();
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
