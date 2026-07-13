class LFUCache {
    static class Node {
        int key, value, freq;
        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    int capacity;
    int minFreq;
    HashMap<Integer, Node> cache = null;
    HashMap<Integer, LinkedHashSet<Integer>> freqMap = null;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            touch(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            touch(node);
            return;
        }

        if (capacity == cache.size()) {
            LinkedHashSet<Integer> set = freqMap.get(minFreq);
            int evictKey = set.iterator().next();
            set.remove(evictKey);
            if (set.isEmpty())
                freqMap.remove(minFreq);
            cache.remove(evictKey);
        }
        minFreq = 1;
        Node newNode = new Node(key, value, 1);
        freqMap.computeIfAbsent(minFreq, f -> new LinkedHashSet<Integer>()).add(key);
        cache.put(key, newNode);
    }

    public void touch(Node node) {
        int freq = node.freq;
        LinkedHashSet<Integer> set = freqMap.get(freq);
        set.remove(node.key);
        if (set.isEmpty()) {
            freqMap.remove(node.freq);
            if (minFreq == node.freq) {
                minFreq++;
            }
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<Integer>()).add(node.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */