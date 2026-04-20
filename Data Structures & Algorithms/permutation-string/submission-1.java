class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Length = s1.length();
        int s2Length = s2.length();
        Map<Character, Integer> counts = new HashMap();

        for (int i = 0; i < s1Length; i++) {
            char c = s1.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2Length; right++) {
            while (right - left + 1 > s1Length) {
                increment(counts, s2.charAt(left));
                left++;
            }

            decrement(counts, s2.charAt(right));

            if (countsAreZero(counts)) {
                return true;
            }
        }

        return false;
    }

    private static boolean countsAreZero(Map<Character, Integer> counts) {
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    private static void increment(Map<Character, Integer> counts, char c) {
        if (counts.containsKey(c)) {
            counts.put(c, counts.get(c) + 1);
        }
    }

    private static void decrement(Map<Character, Integer> counts, char c) {
        if (counts.containsKey(c)) {
            counts.put(c, counts.get(c) - 1);
        }
    }
}
