class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] ascii = new int[26];
            for (int i = 0; i < str.length(); i++) {
                ascii[str.charAt(i) - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(ascii), v -> new ArrayList<String>()).add(str);
        }
        return new ArrayList(map.values());
    }
}
