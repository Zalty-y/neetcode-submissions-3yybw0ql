class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n - 1, cache, s);
    }

    private int dfs(int i, int[] cache, String s) {
        if (i < 0) {
            return 1;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        cache[i] = s.charAt(i) == '0' ? 0 : dfs(i - 1, cache, s);
        
        if (i > 0 && ((s.charAt(i) < '7' && s.charAt(i - 1) == '2') || s.charAt(i - 1) == '1')) {
            cache[i] += dfs(i - 2, cache, s);
        }

        return cache[i];
    }
}
