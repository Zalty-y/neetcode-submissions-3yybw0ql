class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[n+1][m+1];
        cache[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (cache[y][x] != 0) {
                    continue;
                }
                cache[y][x] = cache[y-1][x] + cache[y][x-1];
            }
        }

        return cache[n][m];
    }
}
