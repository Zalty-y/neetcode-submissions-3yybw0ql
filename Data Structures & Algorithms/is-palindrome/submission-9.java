class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            char leftChar = Character.toLowerCase(s.charAt(l));
            char rightChar = Character.toLowerCase(s.charAt(r));
            while (!Character.isLetterOrDigit(leftChar) && l < r) {
                l++;
                leftChar = Character.toLowerCase(s.charAt(l));
            }
            while (!Character.isLetterOrDigit(rightChar) && l < r) {
                r--;
                rightChar = Character.toLowerCase(s.charAt(r));
            }

            if (leftChar != rightChar) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
