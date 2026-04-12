class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] cache = new boolean[n + 1];
        cache[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int wordStart = i - word.length();
                if (wordStart >= 0 && cache[wordStart] && wordDict.contains(s.substring(wordStart, i))) {
                    cache[i] = true;
                }
            }
        }

        return cache[n];
    }
}
