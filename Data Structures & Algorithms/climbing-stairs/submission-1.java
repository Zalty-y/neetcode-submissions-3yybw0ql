class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        int result = recursion(n, dp);

        return result;
    }

    private int recursion(int n, int[] dp) {
        if (n < 3) {
            return Math.max(0, n);
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = recursion(n - 1, dp) + recursion(n - 2, dp);
    }
}
