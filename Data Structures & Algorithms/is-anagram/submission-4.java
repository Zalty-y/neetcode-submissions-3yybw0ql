class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int offset = (int)'a';
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int charIndexS = (int)s.charAt(i) - offset;
            int charIndexT = (int)t.charAt(i) - offset;
            letters[charIndexS] += 1;
            letters[charIndexT] -= 1;
        }

        for (int count : letters) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
