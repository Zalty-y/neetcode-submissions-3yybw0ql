class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            if (!charCount.containsKey(c)) {
                return false;
            }

            int newValue = charCount.get(c) - 1;

            if (newValue < 0) {
                return false;
            }

            charCount.put(c, newValue);
        }

        int countSum = 0;

        for (int count : charCount.values()) {
            countSum += count;
        }

        return countSum == 0;
    }
}
