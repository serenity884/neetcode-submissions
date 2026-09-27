class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            char charL = s.charAt(l);
            char charR = s.charAt(r);
            if (Character.toLowerCase(charL) != Character.toLowerCase(charR)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
