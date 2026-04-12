class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] cache = new boolean[n + 1];
        cache[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                if (wordDict.contains(s.substring(i, j)) && cache[i]) {
                    cache[j] = true;
                }
            }
        }

        return cache[n];
    }
}
