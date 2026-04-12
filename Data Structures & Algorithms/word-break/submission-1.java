class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] cache = new boolean[n + 1];
        cache[0] = true;

        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                int wordStart = i - word.length() + 1;
                if (wordStart >= 0 && cache[wordStart] && wordDict.contains(s.substring(wordStart, i+1))) {
                    cache[i+1] = true;
                }
            }
        }

        return cache[n];
    }
}
