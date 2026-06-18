class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26]; // reset for each string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count); // "[1,0,0,...,1,0]" — safe map key
            List<String> list = results.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            results.put(key, list);
        }
        return new ArrayList<>(results.values());
    }
}
