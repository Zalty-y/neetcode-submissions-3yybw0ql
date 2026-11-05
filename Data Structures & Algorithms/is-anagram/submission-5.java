class Solution {
    public boolean isAnagram(String s, String t) {
    int[] letters = new int[26];
    int offset = 'a';

    for (char c : s.toCharArray()) {
      letters[c - offset]++;
    }

    for (char c : t.toCharArray()) {
      letters[c - offset]--;
    }

    for (int num : letters) {
      if (num != 0) return false;
    }

    return true;
    }
}
