class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += countPalindromes(i, i, s);
            result += countPalindromes(i, i+1, s);
        }

        return result;
    }

    private int countPalindromes(int left, int right, String s) {
        if (left < 0 || right >= s.length()) {
            return 0;
        }

        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }

        return result;
    }
}
