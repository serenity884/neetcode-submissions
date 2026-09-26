class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            int[] nums = new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a']++;
            }
            anagramMap.computeIfAbsent(Arrays.toString(nums), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<List<String>>(anagramMap.values());
    }
}
