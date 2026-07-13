class Solution {
    public int strStr(String haystack, String needle) {
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            int tempI = i;
            while (tempI < haystack.length() && j < needle.length() && haystack.charAt(tempI) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i;
                } // fixed logic
                tempI++;
                j++;
            }
            j = 0;
        }
        return -1;
    }
}