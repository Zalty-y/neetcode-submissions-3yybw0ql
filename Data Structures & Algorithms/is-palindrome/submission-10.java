class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }
            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
