class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(n);
        }
        int[] result = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int n : buckets[i]) {
                    if (j < k) result[j++] = n;
                }
            }
        }
        return result;
    }
}
