public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;	

        for (int i = 0; i < s.length(); i++) {
            int odd = getPalindrome(s, i, i);
            int even = getPalindrome(s, i, i+1);

            int maxLength = Math.max(odd, even);

            if (maxLength > end - start + 1) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int getPalindrome(String s, int left, int right) {
        while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
