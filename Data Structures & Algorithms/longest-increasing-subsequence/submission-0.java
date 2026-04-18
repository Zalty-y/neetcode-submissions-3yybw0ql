class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][n + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, -1, cache, nums);
    }

    private int dfs(int i, int lastAdded, int[][] cache, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i][lastAdded + 1] != -1) {
            return cache[i][lastAdded + 1];
        }

        cache[i][lastAdded + 1] = dfs(i+1, lastAdded, cache, nums);

        if (lastAdded == -1 || nums[lastAdded] < nums[i]) {
            cache[i][lastAdded + 1] = Math.max(cache[i][lastAdded + 1], dfs(i+1, i, cache, nums) + 1);
        }

        return cache[i][lastAdded + 1];
    }
}
