class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return dfs(cost, n, dp);
    }

    private int dfs(int[] cost, int n, int[] dp) {
        if (n < 2) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = Math.min(dfs(cost, n-1, dp) + cost[n-1], dfs(cost, n-2, dp) + cost[n-2]);
    }
}
