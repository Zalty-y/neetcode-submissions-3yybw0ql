class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, n, dp);
    }

    private int dfs(int[] nums, int i, int[] dp) {
        if (i <= 0) {
            return 0;
        }
        if (i == 1) {
            return nums[0];
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = dfs(nums, i-2, dp) + nums[i-1];
        int skip = dfs(nums, i-1, dp);

        return dp[i] = Math.max(rob, skip);
    }
}
