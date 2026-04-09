class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return recursion(n, 0, dp);
    }

    private int recursion(int n, int i, int[] dp) {
        if (i >= n) return i == n ? 1 : 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = recursion(n, i + 1, dp) + recursion(n, i + 2, dp);
    }
}
