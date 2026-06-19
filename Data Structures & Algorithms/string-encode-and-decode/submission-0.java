class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int j = 0;
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                len = Integer.parseInt(str.substring(j, i));
                strs.add(str.substring(i + 1, i + 1 + len));
                i += 1 + len;
                j = i;
            }
        }
        return strs;
    }
}
